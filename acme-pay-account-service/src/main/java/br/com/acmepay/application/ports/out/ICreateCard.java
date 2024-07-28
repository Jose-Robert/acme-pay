package br.com.acmepay.application.ports.out;

import java.math.BigDecimal;

public interface ICreateCard {
    BigDecimal execute(String document);
}
