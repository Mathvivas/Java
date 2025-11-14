package viva.matheus.ecommerceMensageria;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var dispatcher = new KafkaDispatcher()) {
            // mensagem mandada, id do pedido, id do usuário e valor da compra
            var key = UUID.randomUUID().toString();
            var value = key + ",573629,102";
            var email = "Thank you! We are processing your order!";
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
            dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
        }
    }
}