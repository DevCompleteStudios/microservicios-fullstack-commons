package com.devstudios.microservicios.app.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devstudios.microservicios.app.commons.services.CommonService;


public abstract class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;


    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ){
        Optional<E> entity = service.findById(id);
        if(entity.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<?> create( @RequestBody E entity ){
        return ResponseEntity.ok(service.save(entity));
    }

}
