package com.matheus.api.domain.consulta.validacoes.agendamento;

import com.matheus.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
