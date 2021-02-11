package br.maua.atividade2;

public abstract class Transporte {
    private Carga carga;

    public Transporte(Carga carga) {
        this.carga = carga;
    }

    public double calculaFrete() {
        return carga.getValor();
    }
}
