package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@UseCase
@AllArgsConstructor
public class CreateCustomerUseCase implements ICreateCustomerUseCase {

    private final ICreateCustomer createCustomer;

    @Override
    public void execute(CustomerDomain domain) {

        domain.create(createCustomer);
    }
}
