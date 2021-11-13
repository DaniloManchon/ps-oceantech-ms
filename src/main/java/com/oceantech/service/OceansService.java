package com.oceantech.service;

import com.oceantech.model.Oceans;
import com.oceantech.repository.OceansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OceansService {

    @Autowired
    OceansRepository repository;

    //CRUD
    //Create
    public ResponseEntity<Oceans> createOcean(Oceans oceans) {
        try {
            Oceans _oceans = repository.save(new Oceans(
                   oceans.getId(),
                   oceans.getNome(),
                   oceans.getData(),
                   oceans.getPh(),
                   oceans.getCo()
            ));
            return new ResponseEntity<>(_oceans, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //read
    public ResponseEntity<Oceans> getOceanById(String id) {
        Optional<Oceans> oceansData = repository.findById(id);

        if (oceansData.isPresent()) {
            return new ResponseEntity<>(oceansData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Oceans> getOceanByName(String name) {
        Optional<Oceans> oceansData = Optional.ofNullable(repository.findByName(name));
        if (oceansData.isPresent()) {
            return new ResponseEntity<>(oceansData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //update
    //TODO ARRUMAR ISSO
//    public ResponseEntity<Oceans> updateOceans(String name, Oceans Oceans) {
//        Optional<Oceans> oceansData = repository.findByName(name);
//
//        if (oceansData.isPresent()) {
//
//            return new ResponseEntity<>(repository.save(_caracteristicas), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    //delete
    public ResponseEntity<HttpStatus> deleteOceans(String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllOceans() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
