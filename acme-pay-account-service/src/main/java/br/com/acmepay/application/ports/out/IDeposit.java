package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.AccountDomain;

import java.math.BigDecimal;

public interface IDeposit {
    void execute(AccountDomain domain, BigDecimal amount);
}
