import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import static org.apache.zookeeper.Watcher.Event.EventType.None;

import java.io.IOException;

public class EleicaoDeLider {

    private static final String HOST = "localhost";
    private static final String PORT = "2181";
    private static final int TIMEOUT = 5000;

    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Tratando Main: " + Thread.currentThread().getName());
        EleicaoDeLider eleicaoDeLider = new EleicaoDeLider();
        eleicaoDeLider.conectar();
        eleicaoDeLider.executar();
        eleicaoDeLider.fechar();
    }

    public void executar() throws InterruptedException {
        synchronized (zooKeeper) {
            zooKeeper.wait();
        }
    }

    public void fechar() throws InterruptedException {
        zooKeeper.close();
    }

    public void conectar() throws IOException {
        zooKeeper = new ZooKeeper(
                String.format("%s:%s", HOST, PORT),
                TIMEOUT,
                (evento) -> {
                    if ( evento.getType() == None ) {
                        if ( evento.getState() == Watcher.Event.KeeperState.SyncConnected ) {
                            System.out.println("Tratando evento: " + Thread.currentThread().getName());
                            System.out.println("Conectou");
                        } else if ( evento.getState() == Watcher.Event.KeeperState.Disconnected ) {
                            synchronized (zooKeeper) {
                                System.out.println("Desconectou");
                                System.out.println("Estamos na thread: " + Thread.currentThread().getName());
                                zooKeeper.notify();
                            }
                        }
                    }
                }
        );
    }
}
