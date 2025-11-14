package viva.matheus.ecommerceMensageria;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var orderDispatcher = new KafkaDispatcher<Order>()) {
            try(var emailDispatcher = new KafkaDispatcher<String>()) {
                // mensagem mandada, id do pedido, id do usuário e valor da compra
                var userId = UUID.randomUUID().toString();
                var orderId = UUID.randomUUID().toString();
                var amount = new BigDecimal(Math.random() * 5000 + 1); // Pelo menos 1 real entre 1 e 5000
                var order = new Order(userId, orderId, amount);
                var email = "Thank you! We are processing your order!";
                orderDispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);
                emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);
            }
        }
    }
}