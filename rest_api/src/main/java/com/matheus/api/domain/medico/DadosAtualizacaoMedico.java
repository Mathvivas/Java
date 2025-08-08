package com.matheus.api.domain.medico;

import com.matheus.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

// Somente campos que são permitidos atualizar
public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
