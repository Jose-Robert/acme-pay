package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.ICustomerResourceAPI;
import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import br.com.acmepay.application.domain.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmepay.application.ports.in.IListCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResourceAPI {

    private final ICreateCustomerUseCase customerUseCase;
    private final IListCustomerUseCase listCustomerUseCase;

    @Override
    public CustomerResponse create(CustomerRequest request) {

        var domain = CustomerDomain.builder()
                        .name(request.getName())
                        .phone(request.getPhone())
                        .document(request.getDocument())
                        .email(request.getEmail())
                        .build();

        customerUseCase.execute(domain);

        return CustomerResponse.builder()
                .message("Customer created")
                .build();
    }

    @Override
    public List<CustomerResponse> list() {
        return listCustomerUseCase.execute()
                .stream()
                .map(g -> CustomerResponse.builder()
                        .message(g.toString())
                        .build())
                .toList();
    }

}
