package br.maua.atividade2;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nDigite o peso: ");
        double peso = scan.nextDouble();


        System.out.println("\nDigite o valor: ");
        double valor = scan.nextDouble();

        Carga carga = new Carga(valor, peso);
        Vagao vagao = new Vagao(carga);
        Caminhao caminhao = new Caminhao(carga);

        double freteVagao = vagao.calculaFrete();
        double freteCaminhao = caminhao.calculaFrete();

        if ( peso < 15000 ) {
            freteVagao += 5000;
        }

        if ( valor > 40000 ) {
            freteCaminhao -= (freteCaminhao * 0.25);
        }

        System.out.println("\nPeso =  " + peso + " | " + " Valor = " + valor);
        System.out.println("Frete Vagão: $" + freteVagao + " e " + " Frete Caminhão: $" + freteCaminhao);
    }
}
