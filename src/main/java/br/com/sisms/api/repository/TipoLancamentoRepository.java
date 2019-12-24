package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLancamentoRepository extends JpaRepository<TipoLancamento, Long> {

}
