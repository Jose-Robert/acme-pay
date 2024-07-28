package br.com.acmepay.adapters.output.queue;

public interface IProducerMessage {
    void publish(String status, String document);
}
