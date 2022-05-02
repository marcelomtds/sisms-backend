package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p "
            + "WHERE 1 = 1 "
            + "AND (:nomeCompleto IS NULL OR :nomeCompleto = '' OR UPPER (p.nomeCompleto) LIKE CONCAT ('%',UPPER(:nomeCompleto),'%')) "
            + "AND (:cpf IS NULL OR :cpf = '' OR p.cpf = :cpf) "
            + "AND (:ativo IS NULL OR p.ativo = :ativo) "
            + "AND (:sexoId IS NULL OR p.sexo.id = :sexoId) "
            + "AND (:localidadeId IS NULL OR p.endereco.localidade.id = :localidadeId) "
            + "AND (:ufId IS NULL OR p.endereco.localidade.uf.id = :ufId) "
            + "AND (:telefone IS NULL OR :telefone = '' "
                + "OR p.contato.telefone1 = :telefone "
                + "OR p.contato.telefone2 = :telefone "
                + "OR p.contato.telefone3 = :telefone "
                + "OR p.contato.telefone4 = :telefone)")
    Page<Paciente> findByFilter(
            final String nomeCompleto,
            final String cpf,
            final Boolean ativo,
            final Long sexoId,
            final Long localidadeId,
            final Long ufId,
            final String telefone,
            Pageable pageable);

    List<Paciente> findAllByAtivoIsTrueOrderByNomeCompletoAsc();

    Paciente findByCpf(final String cpf);

    @Query("SELECT p FROM Paciente AS p " +
            "WHERE p.ativo = TRUE " +
            "AND FUNCTION ('DATE_PART', 'MONTH', p.dataNascimento) = FUNCTION ('DATE_PART', 'MONTH', CURRENT_DATE) " +
            "ORDER BY p.dataNascimento ASC")
    List<Paciente> findAllBirthdaysMonth();
}
