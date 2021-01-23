package br.maua;

public class Main {

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setSalario(20000);
        System.out.println("Imposto do Gerente: " + gerente.imposto());

        Supervisor supervisor = new Supervisor();
        supervisor.setSalario(12000);
        System.out.println("Imposto do Supervisor: " + supervisor.imposto());

        Atendente atendente = new Atendente();
        atendente.setSalario(9000);
        System.out.println("Imposto do Atendente: " + atendente.imposto());
    }
}
