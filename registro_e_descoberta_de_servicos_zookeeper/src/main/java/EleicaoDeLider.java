import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;

public class EleicaoDeLider {
    private static final String ELEICAO = "/eleicao";
    private String nomeDoZNodeDesseProcesso;
    private ZooKeeper zooKeeper;
    private EleicaoCallback eleicaoCallback;

    public EleicaoDeLider(ZooKeeper zooKeeper, EleicaoCallback eleicaoCallback) {
        this(zooKeeper);
        this.eleicaoCallback = eleicaoCallback;
    }

    public EleicaoDeLider(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;

        try {
            if ( this.zooKeeper.exists(ELEICAO, false) == null )
                this.zooKeeper.create(ELEICAO, new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
        }
        catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    public void realizarCandidatura() throws InterruptedException, KeeperException {
        String prefixo = String.format("%s/cand_", ELEICAO);
        String pathInteiro = zooKeeper.create(prefixo, new byte[]{},
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        this.nomeDoZNodeDesseProcesso =
                pathInteiro.replace(String.format("%s/", ELEICAO), "");
        System.out.println(this.nomeDoZNodeDesseProcesso);
    }

    public void eleicaoEReeleicao() throws InterruptedException, KeeperException {
        Stat statPredecessor = null;
        String nomePredecessor = "";
        do {
            List<String> candidatos = zooKeeper.getChildren(ELEICAO, false);
            Collections.sort(candidatos);
            String oMenor = candidatos.get(0);
            if ( oMenor.equals(nomeDoZNodeDesseProcesso) ) {
                System.out.printf("Me chamo %s e sou o Líder.\n", nomeDoZNodeDesseProcesso);
                eleicaoCallback.onEleitoLider();
                return;
            }
            System.out.printf("Me chamo %s e não sou o Líder. O Líder é o %s.\n", nomeDoZNodeDesseProcesso, oMenor);
            int indicePredecessor = Collections.binarySearch(candidatos, nomeDoZNodeDesseProcesso) - 1;
            nomePredecessor = candidatos.get(indicePredecessor);
            statPredecessor = zooKeeper.exists(
                    String.format("%s/%s", ELEICAO, nomePredecessor),
                    reeleicaoWatcher
            );
        } while (statPredecessor == null);
        eleicaoCallback.onIndicadoATrabalhador();
        System.out.printf("Estou observando o %s\n", nomePredecessor);
    }

    private Watcher reeleicaoWatcher = (evento) -> {
        try {
            switch(evento.getType()) {
                case NodeDeleted:
                    // Líder inoperante
                    // Nova eleição
                    eleicaoEReeleicao();
                    break;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    };
}
