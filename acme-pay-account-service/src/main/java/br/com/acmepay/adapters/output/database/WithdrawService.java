package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.input.api.request.TransactionRequest;
import br.com.acmepay.adapters.output.database.entity.AccountEntity;
import br.com.acmepay.adapters.output.database.repository.IAccountRepository;
import br.com.acmepay.adapters.output.queue.producer.kafka.ISendMessage;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.out.IWithdraw;
import br.com.acmepay.constants.ConstantsKafka;
import br.com.acmepay.constants.ConstantsTypeTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class WithdrawService implements IWithdraw {

    private final IAccountRepository accountRepository;
    private final ISendMessage sendMessage;

    @Override
    public void execute(AccountDomain domain, BigDecimal amount) throws BalanceToWithdrawException {

        var document = domain.getDocument();
        var number = domain.getNumber();
        var agency = domain.getAgency();

        var optional = accountRepository.findByDocumentAndNumberAndAgency(document, number, agency);

        if (optional.isPresent()) {

            var entity = optional.get();

            var oldBalance = entity.getBalance();

            if (oldBalance.compareTo(amount) >= 0){
                entity.setBalance(oldBalance.subtract(amount));
                entity.setUpdated_at(LocalDateTime.now());
        }else {
           throw new BalanceToWithdrawException("insufficient balance to withdraw");
        }

            accountRepository.save(entity);

            sendMessageKafka(amount, entity);
        }
    }

    private void sendMessageKafka(BigDecimal amount, AccountEntity entity) {
        var entityKafka = TransactionRequest.builder()
                .agency(entity.getAgency())
                .number(entity.getNumber())
                .document(entity.getDocument())
                .dateTransfer(LocalDateTime.now())
                .transferValue(amount)
                .typeTransaction(ConstantsTypeTransaction.WITHDRAW)
                .build();

        sendMessage.execute(ConstantsKafka.TOPIC_TRANSFER_NAME, entityKafka);
    }

}
