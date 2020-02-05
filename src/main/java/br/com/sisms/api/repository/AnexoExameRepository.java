package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.AnexoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnexoExameRepository extends JpaRepository<AnexoExame, Long> {

    @Modifying
    @Query("DELETE FROM AnexoExame ae WHERE ae.exame.id = :id")
    void deleteAllByExameId(final Long id);

    List<AnexoExame> findByExameId(final Long id);

}
