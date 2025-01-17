package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.repository.IAccountRepository;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.out.IDeleteAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteAccountService implements IDeleteAccount {

    private final IAccountRepository repository;

    @Override
    public void execute(AccountDomain accountDomain) {


        var entity = repository.findByNumber(accountDomain.getNumber());

        entity.setClose(accountDomain.getClose());
        entity.setUpdated_at(accountDomain.getUpdated_at());

        repository.save(entity);
    }
}
