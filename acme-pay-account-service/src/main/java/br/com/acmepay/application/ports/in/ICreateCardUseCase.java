package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.CardVO;
import br.com.acmepay.application.domain.AccountDomain;

public interface ICreateCardUseCase {
    CardVO execute(AccountDomain domain);
}
