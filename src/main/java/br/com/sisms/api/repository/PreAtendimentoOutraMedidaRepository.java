package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.PreAtendimentoOutraMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreAtendimentoOutraMedidaRepository extends JpaRepository<PreAtendimentoOutraMedida, Long> {

    @Modifying
    @Query("DELETE FROM PreAtendimentoOutraMedida paom WHERE paom.preAtendimento.id = :id")
    void deleteAllByPreAtendimentoId(final Long id);

}
