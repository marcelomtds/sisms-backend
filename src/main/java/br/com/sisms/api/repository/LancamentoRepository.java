package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query("SELECT lanc FROM Lancamento lanc "
            + "LEFT JOIN CategoriaAtendimento ca ON (lanc.pacote.categoriaAtendimento.id = ca.id OR lanc.atendimento.categoriaAtendimento.id = ca.id) "
            + "WHERE 1 = 1 "
            + "AND (:tipoAtendimentoId IS NULL OR lanc.tipoAtendimento.id = :tipoAtendimentoId) "
            + "AND (:pacoteId IS NULL OR lanc.pacote.id = :pacoteId) "
            + "AND (:atendimentoId IS NULL OR lanc.atendimento.id = :atendimentoId) "
            + "AND (lanc.tipoLancamento.id IN (:tiposLancamentoId)) "
            + "AND (:pacienteId IS NULL OR lanc.paciente.id = :pacienteId) "
            + "AND (:formaPagamentoId IS NULL OR lanc.formaPagamento.id = :formaPagamentoId) "
            + "AND (:categoriaAtendimentoId IS NULL OR ca.id = :categoriaAtendimentoId) "
            + "AND (:usuarioId IS NULL OR lanc.usuario.id = :usuarioId) "
            + "AND (:categoriaLancamentoId IS NULL OR lanc.categoriaLancamento.id = :categoriaLancamentoId) "
            + "AND (CAST(:dataInicio AS date) IS NULL OR lanc.data >= :dataInicio) "
            + "AND (CAST(:dataFim AS date) IS NULL OR lanc.data <= :dataFim)")
    Page<Lancamento> findByFilter(
            final Long tipoAtendimentoId,
            final Long pacoteId,
            final Long atendimentoId,
            final List<Long> tiposLancamentoId,
            final Long pacienteId,
            final Long formaPagamentoId,
            final Long categoriaAtendimentoId,
            final Long usuarioId,
            final Long categoriaLancamentoId,
            final LocalDate dataInicio,
            final LocalDate dataFim,
            final Pageable pageable);

    @Query("SELECT " +
            "SUM(CASE lanc.tipoLancamento.id " +
            "WHEN '4' " +
            "THEN (lanc.valor * -1) " +
            "ELSE lanc.valor " +
            "END) " +
            "FROM Lancamento lanc " +
            "WHERE lanc.tipoLancamento.id IN ('3', '4') " +
            "AND lanc.paciente.id = :id")
    BigDecimal findPatientBalance(final Long id);

    @Query("SELECT lanc FROM Lancamento lanc "
            + "LEFT JOIN lanc.paciente pac "
            + "WHERE lanc.tipoLancamento.id IN ('3', '4') "
            + "AND pac.id = :id "
            + "ORDER BY lanc.data DESC")
    List<Lancamento> findExtractByPatient(final Long id);
}
