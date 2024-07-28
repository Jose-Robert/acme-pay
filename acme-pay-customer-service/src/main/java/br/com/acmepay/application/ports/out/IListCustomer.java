package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.CustomerDomain;

import java.util.List;

public interface IListCustomer {
    
    List<CustomerDomain> execute();
    
}
