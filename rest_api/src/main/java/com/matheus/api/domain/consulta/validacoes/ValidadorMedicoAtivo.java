package com.matheus.api.domain.consulta.validacoes;

import com.matheus.api.domain.ValidacaoException;
import com.matheus.api.domain.consulta.DadosAgendamentoConsulta;
import com.matheus.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        // Escolha do médico opcional - ignora
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo.");
        }
    }
}
