package br.com.acmepay.application.ports.out;


import br.com.acmepay.application.domain.AccountDomain;

public interface ICreateAccount {

    void createDomain(AccountDomain accountDomain);
    void execute(String document);
}
