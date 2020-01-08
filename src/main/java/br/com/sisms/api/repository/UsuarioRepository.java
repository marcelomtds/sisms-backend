package br.com.sisms.api.repository;

import br.com.sisms.api.model.entity.Paciente;
import br.com.sisms.api.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT new br.com.sisms.api.model.entity.Usuario(u.id, u.nomeCompleto, u.cpf, u.dataNascimento, u.perfil, u.sexo, u.ativo) FROM Usuario u "
            + "WHERE 1 = 1 "
            + "AND (:nomeCompleto IS NULL OR :nomeCompleto = '' OR UPPER (u.nomeCompleto) LIKE CONCAT ('%',UPPER(:nomeCompleto),'%')) "
            + "AND (:cpf IS NULL OR :cpf = '' OR u.cpf = :cpf) "
            + "AND (:ativo IS NULL OR u.ativo = :ativo) "
            + "AND (:sexoId IS NULL OR u.sexo.id = :sexoId) "
            + "AND (:localidadeId IS NULL OR u.endereco.localidade.id = :localidadeId) "
            + "AND (:ufId IS NULL OR u.endereco.localidade.uf.id = :ufId) "
            + "AND (:celular IS NULL OR :celular = '' OR u.contato.celular = :celular) "
            + "AND (:celularRecado IS NULL OR :celularRecado = '' OR u.contato.celularRecado = :celularRecado) "
            + "AND (:residencial IS NULL OR :residencial = '' OR u.contato.residencial = :residencial) "
            + "AND (:comercial IS NULL OR :comercial = '' OR u.contato.comercial = :comercial)")
    Page<Usuario> findByFilter(
            final String nomeCompleto,
            final String cpf,
            final Boolean ativo,
            final Long sexoId,
            final Long localidadeId,
            final Long ufId,
            final String celular,
            final String celularRecado,
            final String residencial,
            final String comercial,
            Pageable pageable);

    Usuario findByCpf(final String cpf);

    Usuario findByCpfAndAtivoIsTrue(final String cpf);

    List<Usuario> findAllByAtivoIsTrueOrderByNomeCompletoAsc();

    @Query("SELECT u FROM Usuario as u WHERE Extract(Month FROM u.dataNascimento) = Extract(Month FROM Now())")
    List<Usuario> findAllBirthdaysMonth();

}
