package br.com.acmepay.application.usecase;

import br.com.acmepay.application.ports.in.IListAccountUseCase;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.out.IListAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListAccountUseCase implements IListAccountUseCase {

    private final IListAccount listAccount;

    
    @Override
    public List<AccountDomain> execute() {

        var accountDomain = AccountDomain.builder().build();

     return accountDomain.listAccount(listAccount);
    }
    
}
