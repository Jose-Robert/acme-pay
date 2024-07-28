package br.com.acmepay.adapters.input.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class DocumentResponse implements Serializable {
    private String document;
}
