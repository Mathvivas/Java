package br.maua.enums;

public enum Produto {

    JOIAS("000"),
    LIVROS("111"),
    ELETRONICOS("333"),
    BEBIDAS("555"),
    BRINQUEDOS("888");

    private String codigo;

    Produto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
}
