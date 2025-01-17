package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.CustomerDomain;

import java.util.List;

public interface IListCustomerUseCase {

    List<CustomerDomain> execute();

}
