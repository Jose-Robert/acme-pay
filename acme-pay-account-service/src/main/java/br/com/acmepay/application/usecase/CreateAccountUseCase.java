package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.ValidDocumentException;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateRedisAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICheckDocumentCustomer checkDocumentCustomer;
    private final ICreateRedisAccount iCreateTemporaryAccount;

    @Override
    public void execute(AccountDomain domain) throws ValidDocumentException {
        domain.create(iCreateTemporaryAccount, checkDocumentCustomer);
    }

}
