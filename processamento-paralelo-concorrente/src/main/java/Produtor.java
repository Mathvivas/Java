import java.util.List;
import java.util.Random;

public class Produtor implements Runnable {

    private List<Integer> items;
    private int maximo = 1;
    private Random gerador = new Random();

    public Produtor(List<Integer> items) {
        this.items = items;
    }

    @Override
    public void run() {
        System.out.println("Produtor: " + Thread.currentThread().getName());
        while ( true ) {
            synchronized (items) {
                while ( items.size() >= maximo ) {
                    try {
                        items.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = gerador.nextInt(6) + 1;
                System.out.printf("Item produzido (%s): %d\n", Thread.currentThread().getName(), item);
                items.add(item);
                items.notify();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
