package br.maua.atividade3;

import br.maua.atividade2.Caminhao;
import br.maua.atividade2.Carga;
import br.maua.atividade2.Vagao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulacaoCustoFrete {

    Scanner scan = new Scanner(System.in);
    List<Carga> listaDeCargas = new ArrayList<>();

    public void runSimulacao() {

        System.out.println("\nDigite um peso: ");
        double peso = scan.nextDouble();

        System.out.println("\nDigite um valor: ");
        double valor = scan.nextDouble();

        Carga carga = new Carga(valor, peso);
        Vagao vagao = new Vagao(carga);
        Caminhao caminhao = new Caminhao(carga);


    }
}
