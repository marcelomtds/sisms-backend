package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Pacote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

    @Query("SELECT p FROM Pacote p "
            + "WHERE 1 = 1 "
            + "AND (:categoriaAtendimentoId IS NULL OR p.categoriaAtendimento.id = :categoriaAtendimentoId) "
            + "AND (:pacienteId IS NULL OR p.paciente.id = :pacienteId) "
            + "AND (:usuarioId IS NULL OR p.usuario.id = :usuarioId) "
            + "AND (CAST(:dataInicio AS date) IS NULL OR p.dataCriacao >= :dataInicio) "
            + "AND (CAST(:dataFim AS date) IS NULL OR p.dataCriacao <= :dataFim) "
            + "AND (:aberto IS NULL OR p.aberto = :aberto)")
    Page<Pacote> findByFilter(
            final Long categoriaAtendimentoId,
            final Long pacienteId,
            final Long usuarioId,
            final Boolean aberto,
            final LocalDate dataInicio,
            final LocalDate dataFim,
            Pageable pageable);

    Pacote findFirstByCategoriaAtendimentoIdAndPacienteIdOrderByNumeroDesc(final Long categoriaAtendimentoId, final Long pacienteId);

    Pacote findFirstByCategoriaAtendimentoIdAndPacienteIdAndAbertoIsTrueOrderByNumeroDesc(final Long categoriaAtendimentoId, final Long pacienteId);

}
