package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.in.IDeleteAccountUseCase;
import br.com.acmepay.application.ports.out.IDeleteAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteAccountUseCase implements IDeleteAccountUseCase {

    private final IDeleteAccount deleteAccount;

    @Override
    public void execute(AccountDomain domain)  {
        domain.delete(deleteAccount);
    }

}
