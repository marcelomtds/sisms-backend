package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {

    UF findByDescricaoIgnoreCase(String descricao);

}
