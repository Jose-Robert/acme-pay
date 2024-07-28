package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.CustomerDomain;
import br.com.acmepay.application.ports.in.IListCustomerUseCase;
import br.com.acmepay.application.ports.out.IListCustomer;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@UseCase
@AllArgsConstructor
public class ListCustomerUseCase implements IListCustomerUseCase {

    private final IListCustomer iListCustomer;

    @Override
    public List<CustomerDomain> execute() {

        var customerDomain = CustomerDomain.builder().build();

        return customerDomain.listCustomer(iListCustomer);

    }

}
