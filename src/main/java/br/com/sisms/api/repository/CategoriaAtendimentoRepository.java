package br.com.sisms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisms.api.model.entity.CategoriaAtendimento;

@Repository
public interface CategoriaAtendimentoRepository extends JpaRepository<CategoriaAtendimento, Long> {

}
