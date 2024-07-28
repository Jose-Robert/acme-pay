package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.repository.IAccountRepository;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.out.IListAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListAccountService implements IListAccount {

    private final IAccountRepository repository;

    @Override
    public List<AccountDomain> execute() {
        var accounts = repository.findAll();

        return  accounts.stream()
                    .filter(e -> !e.getClose())
                    .map(a -> AccountDomain.builder()
                            .id(a.getId())
                            .created_at(a.getCreated_at())
                            .updated_at(a.getUpdated_at())
                            .close(a.getClose())
                            .agency(a.getAgency())
                            .number(a.getNumber())
                            .document(a.getDocument())
                            .balance(a.getBalance())
                            .build())
                    .toList();
    }
}
