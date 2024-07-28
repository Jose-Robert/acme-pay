package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.AccountDomain;

public interface IDeleteAccountUseCase {
    void execute(AccountDomain domain);
}
