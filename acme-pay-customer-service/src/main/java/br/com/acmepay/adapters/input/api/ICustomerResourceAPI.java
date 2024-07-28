package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/customers")
public interface ICustomerResourceAPI {

    @PostMapping
    CustomerResponse create(@RequestBody CustomerRequest request);

    @GetMapping
    List<CustomerResponse> list();


}
