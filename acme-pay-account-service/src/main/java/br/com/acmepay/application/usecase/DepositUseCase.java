package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.in.IDepositUseCase;
import br.com.acmepay.application.ports.out.IDeposit;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class DepositUseCase implements IDepositUseCase {

    private final IDeposit deposit;

    @Override
    public void execute(BigDecimal amount, AccountDomain domain) {
        domain.deposit(deposit, amount);
    }


}
