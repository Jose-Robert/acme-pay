package br.com.acmepay.adapters.output.service;

import br.com.acmepay.adapters.output.feign.ICardFeignClient;
import br.com.acmepay.application.ports.out.ICreateCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CreateCardService implements ICreateCard {

    private final ICardFeignClient cardFeignClient;

    @Override
    public BigDecimal execute(String document) {
        return cardFeignClient.getSalaryCustomer(document);
    }
}
