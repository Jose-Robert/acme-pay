package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.in.IQueueSuccessUseCase;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class QueueSuccessUseCase implements IQueueSuccessUseCase {

    private final ICreateAccount createAccount;

    @Override
    public void execute(String document) {

        var accountDomain  = AccountDomain.builder().build();

        accountDomain.validDocument(createAccount, document);

    }
}
