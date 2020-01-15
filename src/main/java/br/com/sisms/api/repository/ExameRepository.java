package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Exame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

    @Query("SELECT e FROM Exame e "
            + "WHERE 1 = 1 "
            + "AND (:pacienteId IS NULL OR e.paciente.id = :pacienteId) "
            + "AND (:categoriaExameId IS NULL OR e.categoriaExame.id = :categoriaExameId) "
            + "AND (CAST(:dataInicio AS date) IS NULL OR e.data >= :dataInicio) "
            + "AND (CAST(:dataFim AS date) IS NULL OR e.data <= :dataFim)")
    Page<Exame> findByFilter(
            final Long pacienteId,
            final Long categoriaExameId,
            final LocalDate dataInicio,
            final LocalDate dataFim,
            Pageable pageable);

}
