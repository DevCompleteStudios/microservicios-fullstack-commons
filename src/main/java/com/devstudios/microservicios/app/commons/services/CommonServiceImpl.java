package com.devstudios.microservicios.app.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public abstract class CommonServiceImpl<E, R extends CrudRepository<E, Long> > implements CommonService<E>{

    @Autowired
    protected R repository;


    @Override
    @Transactional(readOnly=true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
