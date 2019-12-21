package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.OutraMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutraMedidaRepository extends JpaRepository<OutraMedida, Long> {

    OutraMedida findByDescricaoIgnoreCase(final String descricao);

}
