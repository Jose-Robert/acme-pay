package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.AccountDomain;

import java.math.BigDecimal;

public interface IDepositUseCase {
    void execute(BigDecimal amount, AccountDomain domain);
}
