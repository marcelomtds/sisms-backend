package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    Localidade findByDescricaoIgnoreCaseAndUfId(final String descricao, final Long ufId);

    List<Localidade> findByUfId(final Long id);

}
