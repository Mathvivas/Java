import java.util.List;
import java.util.Random;

public class Produtor implements Runnable {

    private List<Integer> items;
    private int maximo = 10;
    private Random gerador = new Random();

    public Produtor(List<Integer> items) {
        this.items = items;
    }

    @Override
    public void run() {
        System.out.println("Produtor: " + Thread.currentThread().getName());
        while ( true ) {
            synchronized (items) {
                // Espera ocupada
                while ( items.size() >= maximo );
                int item = gerador.nextInt(6) + 1;
                items.add(item);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
