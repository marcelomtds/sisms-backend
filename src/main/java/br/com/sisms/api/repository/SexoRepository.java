package br.com.sisms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sisms.api.model.entity.Sexo;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long> {

}
