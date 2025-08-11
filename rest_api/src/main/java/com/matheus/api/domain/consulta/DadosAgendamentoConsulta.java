package com.matheus.api.domain.consulta;

import com.matheus.api.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future // datas somente no futuro
        LocalDateTime data,

        Especialidade especialidade
) {}
