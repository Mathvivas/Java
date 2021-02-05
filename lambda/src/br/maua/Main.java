package br.maua;

public class Main {

    public static void main(String[] args) {
        Function colocarPrefixoSenhor = valor -> "Sr. " + valor;
        System.out.println(colocarPrefixoSenhor.gerar("Matheus"));
    }
}
