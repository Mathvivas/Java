package br.maua.enums;

/**
 * Este enum define os produtos e seus códigos.
 *
 * @author Matheus
 */
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
