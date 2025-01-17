package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.AccountDomain;

import java.util.List;

public interface IListAccountUseCase {
    List<AccountDomain> execute();
}
