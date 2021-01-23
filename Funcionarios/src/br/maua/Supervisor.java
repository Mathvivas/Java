package br.maua;

public class Supervisor extends Funcionario {       // 5% do salário

    public double imposto() {
        return this.getSalario() * 5/100;
    }
}
