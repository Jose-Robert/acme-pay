package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.ValidDocumentException;

public interface ICreateAccountUseCase {
    void execute(AccountDomain domain) throws ValidDocumentException;
}
