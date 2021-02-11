package br.maua.atividade2;

public class Caminhao extends Transporte {

    public Caminhao(Carga carga) {
        super(carga);
    }

    @Override
    public double calculaFrete() {
        return super.calculaFrete(0.12, 0.3);
    }
}
