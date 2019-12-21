package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.ImagemAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemAtendimentoRepository extends JpaRepository<ImagemAtendimento, Long> {

    @Modifying
    @Query("DELETE FROM ImagemAtendimento ia WHERE ia.atendimento.id = :id")
    void deleteAllByAtendimentoId(final Long id);

    List<ImagemAtendimento> findByAtendimentoId(final Long id);

}
