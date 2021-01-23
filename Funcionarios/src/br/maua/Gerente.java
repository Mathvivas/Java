package br.maua;

public class Gerente extends Funcionario {      // 10% do salário

    public double imposto() {
        return this.getSalario() * 10/100;
    }
}
