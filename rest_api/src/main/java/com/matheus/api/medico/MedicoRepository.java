package com.matheus.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

// <Tipo da entidade que este repository vai trabalhar, tipo do atributo da chave primária dessa entidade>
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
