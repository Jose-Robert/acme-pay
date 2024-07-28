package br.com.acmepay.application.ports.out;


import br.com.acmepay.application.domain.AccountDomain;

import java.util.List;

public interface IListAccount {

    List<AccountDomain> execute();
}
