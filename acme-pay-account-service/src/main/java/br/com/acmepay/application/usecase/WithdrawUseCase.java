package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.in.IWithdrawUseCase;
import br.com.acmepay.application.ports.out.IWithdraw;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class WithdrawUseCase implements IWithdrawUseCase {

    private final IWithdraw withdraw;

    @Override
    public void execute(BigDecimal amount, AccountDomain domain) throws BalanceToWithdrawException {
        domain.withdraw(withdraw, amount);
    }
}
