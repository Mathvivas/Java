package com.matheus.api.domain.consulta.validacoes.cancelamento;

import com.matheus.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
