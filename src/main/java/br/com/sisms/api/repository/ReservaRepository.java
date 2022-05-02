package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Reserva findByPacienteNomeCompletoIgnoreCase(final String pacienteNomeCompleto);
}
