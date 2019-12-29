package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Atendimento;
import br.com.sisms.api.model.entity.Usuario;
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

    @Query("SELECT new br.com.sisms.api.model.entity.Atendimento(a.id, a.paciente, a.usuario, a.pacote, a.preAtendimento, a.posAtendimento, a.categoriaAtendimento, a.tipoAtendimento, a.numero, a.aberto) FROM Atendimento a "
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
            + "AND (:categoriaAtendimentoId IS NULL OR a.categoriaAtendimento.id = :categoriaAtendimentoId)")
    Page<Atendimento> findByFilter(
            final Long tipoAtendimentoId,
            final Long pacienteId,
            final Long usuarioId,
            final LocalDateTime preAtendimentoData,
            final LocalDateTime posAtendimentoData,
            final Boolean aberto,
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

    @Query("SELECT new br.com.sisms.api.model.entity.Atendimento(a.id, a.paciente, a.usuario, a.pacote, a.preAtendimento, a.posAtendimento, a.categoriaAtendimento, a.tipoAtendimento, a.numero, a.aberto) FROM Atendimento a "
            + "LEFT JOIN a.preAtendimento pre "
            + "LEFT JOIN a.posAtendimento pos "
            + "LEFT JOIN a.pacote pac "
            + " WHERE pac.id = :id ORDER BY a.numero ASC")
    List<Atendimento> findByPacote(final Long id);
}
