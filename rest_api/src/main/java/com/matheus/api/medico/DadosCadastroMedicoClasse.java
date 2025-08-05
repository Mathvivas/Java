package com.matheus.api.medico;

import com.matheus.api.endereco.DadosEndereco;

// A classe de Cadastro de Dados do Médico seria assim caso não existisse Record
public class DadosCadastroMedicoClasse {

    String nome;
    String email;
    String crm;
    Especialidade especialidade;
    DadosEndereco endereco;

    public DadosCadastroMedicoClasse(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public DadosEndereco getEndereco() {
        return endereco;
    }
}
