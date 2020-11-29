package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT new br.com.sisms.api.model.entity.Menu(m.id, m.descricao, m.icone, m.rota) FROM Menu m WHERE m.pai.id IS NULL ORDER BY m.id ASC")
    List<Menu> findAllMenus();

    @Query("SELECT new br.com.sisms.api.model.entity.Menu(m.id, m.descricao, m.icone, m.rota) FROM Menu m WHERE m.pai.id = :id")
    List<Menu> findSubmenusByPaiId(final Long id);

}
