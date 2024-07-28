package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.in.IQueueFailUseCase;
import br.com.acmepay.application.ports.out.IDeleteRedisAccount;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class QueueFailUseCase implements IQueueFailUseCase {

    private final IDeleteRedisAccount deleteRedisAccount;

    @Override
    public void execute(String document) {

        var accountDomain = AccountDomain.builder().build();

        accountDomain.invalidDocument(deleteRedisAccount, document);

    }
}
