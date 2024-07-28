package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.AccountDomain;

public interface ICreateRedisAccount {

    void execute(AccountDomain account);
}
