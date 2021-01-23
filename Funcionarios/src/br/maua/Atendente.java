package br.maua;

public class Atendente extends Funcionario {        // 2% do salário

    public double imposto() {
        return this.getSalario() * 2/100;
    }
}
