package br.com.acmepay.application.domain;

import br.com.acmepay.application.CardVO;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.out.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private String document;
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateRedisAccount iCreateTemporaryAccount, ICheckDocumentCustomer checkDocumentCustomer) {

        iCreateTemporaryAccount.execute(this);

        checkDocumentCustomer.execute(this.document);

    }

    public void delete(IDeleteAccount iDeleteAccount) {
        iDeleteAccount.execute(this);
    }

    public List<AccountDomain> listAccount(IListAccount iListAccount) {
        return iListAccount.execute();
    }

    public void transfer(ITransfer transfer, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {
        transfer.execute(this, accountDestiny, amount);
    }

    public void deposit(IDeposit deposit, BigDecimal amount) {

        deposit.execute(this, amount);

    }

    public void withdraw(IWithdraw withdraw, BigDecimal amount) throws BalanceToWithdrawException {

        withdraw.execute(this, amount);

    }

    public void validDocument(ICreateAccount createAccount, String document) {
        createAccount.execute(document);
    }

    public void invalidDocument(IDeleteRedisAccount deleteRedisAccount, String document) {
        deleteRedisAccount.execute(document);
    }

    public CardVO createCard(ICreateCard createCard) {
        BigDecimal salary = createCard.execute(this.document);
        return CardVO.builder()
                .salary(salary)
                .limit(BigDecimal.ZERO)
                .document(this.document)
                .build();
    }

}