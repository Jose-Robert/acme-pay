package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;

public interface ITransfer {
    void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException;
}
