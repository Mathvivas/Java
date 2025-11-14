package viva.matheus.ecommerceMensageria;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) {
        try (var producer = new KafkaProducer<String, String>(properties())) {
            // mensagem mandada, id do pedido, id do usuário e valor da compra
            var value = "132123,67384,3423";
            var record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER", value, value);
            // send é assíncrono, para esperar, usar .get()
            producer.send(record, (data, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                    return;
                }
                System.out.println("sucesso, enviando " + data.topic() + ":::partition " + data.partition() + "/ offset " +
                        data.offset() + "/ timestamp " + data.timestamp());
            }).get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        // Chave e valor vão transformar a mensagem de string para bytes - serializer
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}