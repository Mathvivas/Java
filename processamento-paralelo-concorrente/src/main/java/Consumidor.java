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
                // Espera ocupada
                while ( items.isEmpty() );
                int item = items.get(0);
                System.out.println("Consumido: " + item);
                total += item;
                System.out.println("Total: " + total);
                items.remove(0);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
