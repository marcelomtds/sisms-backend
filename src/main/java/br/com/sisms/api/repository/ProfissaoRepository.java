package br.com.sisms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisms.api.model.entity.Profissao;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {

	Profissao findByDescricaoIgnoreCase(String descricao);

}
