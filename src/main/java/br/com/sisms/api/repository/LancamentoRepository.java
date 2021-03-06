package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query("SELECT lanc FROM Lancamento lanc "
            + "LEFT JOIN lanc.formaPagamento fp "
            + "LEFT JOIN lanc.categoriaLancamento cl "
            + "LEFT JOIN lanc.tipoAtendimento ta "
            + "LEFT JOIN lanc.pacote paco "
            + "LEFT JOIN lanc.atendimento at "
            + "LEFT JOIN Paciente pac ON (paco.paciente.id = pac.id OR at.paciente.id = pac.id) "
            + "LEFT JOIN CategoriaAtendimento ca ON (paco.categoriaAtendimento.id = ca.id OR at.categoriaAtendimento.id = ca.id) "
            + "WHERE 1 = 1 "
            + "AND (:tipoAtendimentoId IS NULL OR ta.id = :tipoAtendimentoId) "
            + "AND (:pacoteId IS NULL OR paco.id = :pacoteId) "
            + "AND (:atendimentoId IS NULL OR at.id = :atendimentoId) "
            + "AND (:tipoLancamentoId IS NULL OR lanc.tipoLancamento.id = :tipoLancamentoId) "
            + "AND (:pacienteId IS NULL OR pac.id = :pacienteId) "
            + "AND (:formaPagamentoId IS NULL OR fp.id = :formaPagamentoId) "
            + "AND (:categoriaAtendimentoId IS NULL OR ca.id = :categoriaAtendimentoId) "
            + "AND (:usuarioId IS NULL OR lanc.usuario.id = :usuarioId) "
            + "AND (:categoriaLancamentoId IS NULL OR cl.id = :categoriaLancamentoId) "
            + "AND (CAST(:dataInicio AS date) IS NULL OR lanc.data >= :dataInicio) "
            + "AND (CAST(:dataFim AS date) IS NULL OR lanc.data <= :dataFim)")
    Page<Lancamento> findByFilter(
            final Long tipoAtendimentoId,
            final Long pacoteId,
            final Long atendimentoId,
            final Long tipoLancamentoId,
            final Long pacienteId,
            final Long formaPagamentoId,
            final Long categoriaAtendimentoId,
            final Long usuarioId,
            final Long categoriaLancamentoId,
            final LocalDate dataInicio,
            final LocalDate dataFim,
            final Pageable pageable);

}
