package br.maua;

public abstract class Funcionario {

    private double salario;

    public double imposto() {
        return this.salario * 0.1/100;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
