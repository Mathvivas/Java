import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import static org.apache.zookeeper.Watcher.Event.EventType.None;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class EleicaoDeLider {

    private static final String HOST = "localhost";
    private static final String PORT = "2181";
    private static final int TIMEOUT = 5000;
    private static final String NAMESPACE_ELEICAO = "/eleicao";
    private static final String ZNODE_TESTE_WATCH = "/teste_watcher";
    private String nomeDoZNodeDesseProcesso;
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        System.out.println("Tratando Main: " + Thread.currentThread().getName());
        EleicaoDeLider eleicaoDeLider = new EleicaoDeLider();
        eleicaoDeLider.conectar();
        eleicaoDeLider.realizarCandidatura();
        eleicaoDeLider.elegerOLider();
        eleicaoDeLider.registrarWatcher();
        eleicaoDeLider.executar();
        eleicaoDeLider.fechar();
    }

    private class TesteWatcher implements Watcher {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
            switch (watchedEvent.getType()) {
                case NodeCreated:
                    System.out.println("ZNode Criado");
                    break;
                case NodeDeleted:
                    System.out.println("ZNode Removido");
                    break;
            }
        }
    }

    public void registrarWatcher() throws InterruptedException, KeeperException {
        TesteWatcher watcher = new TesteWatcher();
        Stat stat = zooKeeper.exists(ZNODE_TESTE_WATCH, watcher);
        // znode existe
        if ( stat != null ) {

        }
    }

    public void realizarCandidatura() throws InterruptedException, KeeperException {
        String prefixo = String.format("%s/cand_", NAMESPACE_ELEICAO);
        String pathInteiro = zooKeeper.create(prefixo, new byte[]{},
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        this.nomeDoZNodeDesseProcesso =
                pathInteiro.replace(String.format("%s/", NAMESPACE_ELEICAO), "");
        System.out.println(this.nomeDoZNodeDesseProcesso);
    }

    public void elegerOLider() throws InterruptedException, KeeperException {
        // Obter a lista de filhos do ZNode /eleicao (usar o zooKeeper)
        List<String> filhos =  zooKeeper.getChildren(NAMESPACE_ELEICAO, false);
        // Ordenar a lista de filhos
        Collections.sort(filhos);
        // Verificar se o primeiro da lista é igual ao atual nomeDoZNodeDesseProcesso
        // Se for, declarar-se líder. Caso contrário, dizer quem é o líder
        String lider = filhos.get(0);
        if ( lider.equals(nomeDoZNodeDesseProcesso) ) {
            System.out.printf("Me chamo %s e sou o líder.", nomeDoZNodeDesseProcesso);
        } else {
            System.out.printf("Não sou o líder, O líder é o %s.\n", lider);
        }
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
