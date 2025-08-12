package com.matheus.api.domain.consulta.validacoes;

import com.matheus.api.domain.ValidacaoException;
import com.matheus.api.domain.consulta.DadosAgendamentoConsulta;
import com.matheus.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo.");
        }
    }
}
