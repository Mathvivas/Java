package br.maua.atividade2;

public abstract class Transporte {
    private Carga carga;

    public Transporte(Carga carga) {
        this.carga = carga;
    }

    public double calculaFrete(double fretePeso, double freteValor) {
        return freteValor * carga.getValor() + fretePeso * carga.getPeso();
    }

    public abstract double calculaFrete();
}
