package com.matheus.api.medico;

import com.matheus.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

// Somente campos que são permitidos atualizar
public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
