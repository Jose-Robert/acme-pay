package br.com.acmepay.adapters.input.queue;


public interface ConsumerMessage {

    void subscribe(String document);
    void subscribeInvalid(String document);
}
