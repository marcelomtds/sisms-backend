package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.CategoriaExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaExameRepository extends JpaRepository<CategoriaExame, Long> {

    CategoriaExame findByDescricaoIgnoreCase(String descricao);

}
