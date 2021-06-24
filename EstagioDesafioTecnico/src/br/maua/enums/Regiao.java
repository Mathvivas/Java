package br.maua.enums;

public enum Regiao {

    CENTROOESTE("111"),
    NORDESTE("333"),
    NORTE("555"),
    SUDESTE("888"),
    SUL("000");

    private String codigo;

    Regiao(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
}
