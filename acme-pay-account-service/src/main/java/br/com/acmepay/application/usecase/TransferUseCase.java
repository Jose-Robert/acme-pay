package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.in.ITransferUseCase;
import br.com.acmepay.application.ports.out.ITransfer;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class TransferUseCase implements ITransferUseCase {

    private final ITransfer transfer;

    @Override
    public void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {

        accountOrigin.transfer(transfer, accountDestiny, amount);

    }
}
