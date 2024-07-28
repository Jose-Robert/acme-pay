package br.com.acmepay.application.domain.exception;

public class CustomerDeleteException extends Exception{

    public CustomerDeleteException(String menssage){
        super(menssage);
    }
}
