package com.matheus.api.controller;

import com.matheus.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    // interface que acessa o banco de dados
    private MedicoRepository repository;

    @PostMapping
    @Transactional // Escrita no banco
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

//    @GetMapping
//    public List<DadosListagemMedico> listar() {
//        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
//    }

    // PAGINAÇÃO
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    // @PathVariable diz que esse id recebido é o mesmo id que vai na url /medicos/id
    public void excluir(@PathVariable Long id) {
        // Exclusão lógica
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
