package br.maua.atividade2;

public class Vagao extends Transporte {

    public Vagao(Carga carga) {
        super(carga);
    }

    @Override
    public double calculaFrete() {
        return super.calculaFrete(0.2, 0.1);
    }
}
