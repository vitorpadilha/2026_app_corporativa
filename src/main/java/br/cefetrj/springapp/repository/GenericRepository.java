package br.cefetrj.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.cefetrj.springapp.model.EntidadeGenerica;

public interface GenericRepository<T extends EntidadeGenerica>
        extends CrudRepository<T, Long>, PagingAndSortingRepository<T, Long> {

}