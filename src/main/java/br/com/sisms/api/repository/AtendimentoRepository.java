package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Atendimento;
import br.com.sisms.api.model.interfaces.IRelatorioItemSerie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query("SELECT new br.com.sisms.api.model.entity.Atendimento(a.id, a.totalPago, a.paciente, a.usuario, a.pacote, a.preAtendimento, a.posAtendimento, a.categoriaAtendimento, a.tipoAtendimento, a.numero, a.aberto) FROM Atendimento a "
            + "LEFT JOIN a.preAtendimento pre "
            + "LEFT JOIN a.posAtendimento pos "
            + "LEFT JOIN a.pacote pac "
            + "WHERE 1 = 1 "
            + "AND (:tipoAtendimentoId IS NULL OR a.tipoAtendimento.id = :tipoAtendimentoId) "
            + "AND (:pacienteId IS NULL OR a.paciente.id = :pacienteId) "
            + "AND (:usuarioId IS NULL OR a.usuario.id = :usuarioId) "
            + "AND (CAST(:preAtendimentoData AS date) IS NULL OR pre.data >= :preAtendimentoData) "
            + "AND (CAST(:posAtendimentoData AS date) IS NULL OR pos.data <= :posAtendimentoData) "
            + "AND (:aberto IS NULL OR a.aberto = :aberto) "
            + "AND (:lancamentoPendente IS NULL OR (:lancamentoPendente IS TRUE AND (a.totalPago IS NULL AND pac.totalPago IS NULL OR pac.totalPago < pac.valor)) OR (:lancamentoPendente IS FALSE AND (a.totalPago IS NOT NULL OR pac.totalPago = pac.valor))) "
            + "AND (:categoriaAtendimentoId IS NULL OR a.categoriaAtendimento.id = :categoriaAtendimentoId)")
    Page<Atendimento> findByFilter(
            final Long tipoAtendimentoId,
            final Long pacienteId,
            final Long usuarioId,
            final LocalDateTime preAtendimentoData,
            final LocalDateTime posAtendimentoData,
            final Boolean aberto,
            final Boolean lancamentoPendente,
            final Long categoriaAtendimentoId,
            Pageable pageable);

    @Query("SELECT COUNT(a) FROM Atendimento a "
            + "WHERE a.pacote IS NULL "
            + "AND a.paciente.id = :pacienteId "
            + "AND a.categoriaAtendimento.id = :categoriaAtendimentoId")
    Long findTotalBySession(final Long pacienteId, final Long categoriaAtendimentoId);

    @Query("SELECT COUNT(a) FROM Atendimento a "
            + "WHERE a.pacote.id = :pacoteId "
            + "AND a.paciente.id = :pacienteId "
            + "AND a.categoriaAtendimento.id = :categoriaAtendimentoId")
    Long findTotalByPackage(final Long pacienteId, final Long pacoteId, final Long categoriaAtendimentoId);

    @Query("SELECT new br.com.sisms.api.model.entity.Atendimento(a.id, a.totalPago, a.paciente, a.usuario, a.pacote, a.preAtendimento, a.posAtendimento, a.categoriaAtendimento, a.tipoAtendimento, a.numero, a.aberto) FROM Atendimento a "
            + "LEFT JOIN a.preAtendimento pre "
            + "LEFT JOIN a.posAtendimento pos "
            + "LEFT JOIN a.pacote pac "
            + "WHERE pac.id = :id ORDER BY a.numero ASC")
    List<Atendimento> findByPacote(final Long id);

    Atendimento findFirstByPacienteIdAndCategoriaAtendimentoIdOrderByPreAtendimentoDataDesc(final Long pacienteId, final Long categoriaAtendimentoId);

    @Query(value = "SELECT "
            + "COUNT(at) AS value, "
            + "ca.descricao AS name "
            + "FROM atendimento at "
            + "INNER JOIN pre_atendimento pre ON pre.id = at.id_pre_atendimento "
            + "INNER JOIN pos_atendimento pos ON pos.id = at.id_pos_atendimento "
            + "INNER JOIN categoria_atendimento ca ON ca.id = at.id_categoria_atendimento "
            + "WHERE pre.data >= :dataInicio "
            + "AND pos.data <= :dataFim "
            + "AND ca.id IN (:categoriasAtendimentoId) "
            + "GROUP BY ca.descricao "
            + "ORDER BY value DESC", nativeQuery = true)
    List<IRelatorioItemSerie> reportServiceByFilter(
            final LocalDateTime dataInicio,
            final LocalDateTime dataFim,
            final List<Long> categoriasAtendimentoId);

    @Query(value = "SELECT "
            + "COUNT(at) AS value, "
            + "ca.descricao AS name, "
            + "EXTRACT(MONTH FROM pre.data) AS mes, "
            + "EXTRACT(YEAR FROM pre.data) AS ano "
            + "FROM atendimento at "
            + "INNER JOIN pre_atendimento pre ON pre.id = at.id_pre_atendimento "
            + "INNER JOIN pos_atendimento pos ON pos.id = at.id_pos_atendimento "
            + "INNER JOIN categoria_atendimento ca ON ca.id = at.id_categoria_atendimento "
            + "WHERE pre.data >= :dataInicio "
            + "AND pos.data <= :dataFim "
            + "AND ca.id IN (:categoriasAtendimentoId) "
            + "GROUP BY ca.descricao, mes, ano "
            + "ORDER BY ano DESC", nativeQuery = true)
    List<IRelatorioItemSerie> reportGroupedServiceByFilter(
            final LocalDateTime dataInicio,
            final LocalDateTime dataFim,
            final List<Long> categoriasAtendimentoId);
}
