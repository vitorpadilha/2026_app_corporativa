package br.cefetrj.springapp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.cefetrj.springapp.model.Pessoa;
import java.util.Optional;

@Repository
public interface PessoaRepository extends GenericRepository<Pessoa>, JpaSpecificationExecutor<Pessoa> {
    public Optional<Pessoa> findByCpf(Long cpf);

    public Optional<Pessoa> findByCpfAndNomeLike(Long cpf, String nome);
}
