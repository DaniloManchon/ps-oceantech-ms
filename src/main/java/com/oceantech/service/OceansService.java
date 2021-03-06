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

    public ResponseEntity<Oceans> createOcean(String name, String data, float ph, int co) {
        try {
            Oceans _oceans = new Oceans(name,data,ph,co);
            repository.save(_oceans);
            return new ResponseEntity<>(_oceans, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Oceans> getOceanById(String id) {
        Optional<Oceans> oceansData = repository.findById(id);

        if (oceansData.isPresent()) {
            return new ResponseEntity<>(oceansData.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Oceans> getOceanByName(String name) {
        Optional<Oceans> oceansData = Optional.ofNullable(repository.findByName(name));
        if (oceansData.isPresent()) {
            return new ResponseEntity<>(oceansData.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Oceans> updateOceansByName(String name, String data, float ph, int co){
        if(getOceanByName(name) != null){
            try{
                repository.deleteByName(name);
                Oceans _oceans = repository.save(new Oceans(name,data,ph,co));
                return new ResponseEntity<>(_oceans, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteOceansByName(String name) {
        try {
            repository.deleteByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<HttpStatus> deleteAllOceans() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
