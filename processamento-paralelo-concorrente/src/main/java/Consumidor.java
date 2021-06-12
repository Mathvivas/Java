import java.util.List;

public class Consumidor implements Runnable {

    private List<Integer> items;
    private int total;

    public Consumidor(List<Integer> items) {
        this.items = items;
    }

    @Override
    public void run() {
        System.out.println("Consumidor: " + Thread.currentThread().getName());
        while ( true ) {
            synchronized (items) {
                while ( items.isEmpty() ) {
                    try {
                        items.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                total += items.get(0);
                items.remove(0);
                System.out.printf("Total (%s): %d\n", Thread.currentThread().getName(), total);
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
