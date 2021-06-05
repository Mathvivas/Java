import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteProdutoConsumidor {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        List<Integer> items = new ArrayList<>();
        Produtor produtor = new Produtor(items);
        Consumidor consumidor = new Consumidor(items);

//        new Thread(produtor).start();
//        new Thread(consumidor).start();
        pool.submit(produtor);
        pool.submit(consumidor);
    }
}
