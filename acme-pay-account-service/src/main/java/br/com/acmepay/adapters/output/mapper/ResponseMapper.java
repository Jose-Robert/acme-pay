package br.com.acmepay.adapters.output.mapper;

import br.com.acmepay.adapters.input.api.response.CardResponse;
import br.com.acmepay.application.CardVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMapper {

    public static CardResponse toResponse(CardVO card) {
        return CardResponse.builder()
                .document(card.getDocument())
                .limit(card.getLimit())
                .salary(card.getSalary())
                .build();
    }
}
