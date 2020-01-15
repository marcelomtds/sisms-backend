package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.ImagemExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemExameRepository extends JpaRepository<ImagemExame, Long> {

    @Modifying
    @Query("DELETE FROM ImagemExame ie WHERE ie.exame.id = :id")
    void deleteAllByExameId(final Long id);

    List<ImagemExame> findByExameId(final Long id);

}