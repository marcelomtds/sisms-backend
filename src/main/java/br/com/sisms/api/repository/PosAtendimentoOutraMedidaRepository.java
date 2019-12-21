package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.PosAtendimentoOutraMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PosAtendimentoOutraMedidaRepository extends JpaRepository<PosAtendimentoOutraMedida, Long> {

    @Modifying
    @Query("DELETE FROM PosAtendimentoOutraMedida paom WHERE paom.posAtendimento.id = :id")
    void deleteAllByPosAtendimentoId(final Long id);

}
