package br.com.acmepay.application.usecase;

import br.com.acmepay.application.CardVO;
import br.com.acmepay.application.domain.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateCardUseCase;
import br.com.acmepay.application.ports.out.ICreateCard;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateCardUseCase implements ICreateCardUseCase {

    private final ICreateCard createCardCustomer;

    @Override
    public CardVO execute(AccountDomain domain) {
        return domain.createCard(createCardCustomer);
    }
}
