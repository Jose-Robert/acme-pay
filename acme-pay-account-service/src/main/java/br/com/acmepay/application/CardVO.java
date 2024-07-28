package br.com.acmepay.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardVO implements Serializable {

    private String document;
    private BigDecimal salary;
    private BigDecimal limit;
}
