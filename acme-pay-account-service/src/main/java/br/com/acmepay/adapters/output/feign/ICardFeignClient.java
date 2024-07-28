package br.com.acmepay.adapters.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(value = "customer", url = "${base-url.customer}")
public interface ICardFeignClient {

    @GetMapping(value = "/find-salary/{document}", produces = MediaType.APPLICATION_JSON_VALUE)
    BigDecimal getSalaryCustomer(@PathVariable(name = "document") String document);
}
