package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

}
