package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Query("SELECT a FROM Agenda AS a WHERE a.diaSemana.id = FUNCTION ('DATE_PART', 'DOW', CURRENT_DATE) ORDER BY a.horarioInicio ASC")
    List<Agenda> findAllByWeekDay();

}
