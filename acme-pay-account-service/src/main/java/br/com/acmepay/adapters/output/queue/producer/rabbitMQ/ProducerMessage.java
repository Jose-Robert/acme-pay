package br.com.acmepay.adapters.output.queue.producer.rabbitMQ;

public interface ProducerMessage {
    void publish(String document);
}
