package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Reserva findByPacienteId(final Long id);

    void deleteByPacienteId(final Long id);

}
