package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.TipoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAtendimentoRepository extends JpaRepository<TipoAtendimento, Long> {

}
