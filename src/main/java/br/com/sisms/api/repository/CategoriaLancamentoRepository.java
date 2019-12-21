package br.com.sisms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisms.api.model.entity.CategoriaLancamento;

@Repository
public interface CategoriaLancamentoRepository extends JpaRepository<CategoriaLancamento, Long> {

	CategoriaLancamento findByDescricaoIgnoreCase(String descricao);

}
