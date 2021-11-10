package com.oceantech.service;

import com.oceantech.model.Caracteristicas;
import com.oceantech.repository.CaracteristicasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CaracteristicasService {
    @Autowired
    private CaracteristicasRepository repository;

    //create
    public ResponseEntity<Caracteristicas> createCaracteristica(Caracteristicas caracteristicas) {
        try {
            Caracteristicas _caracteristicas = repository.save(new Caracteristicas(
                    caracteristicas.getData_coleta(),
                    caracteristicas.getAtlantico(),
                    caracteristicas.getPacifico(),
                    caracteristicas.getArtico(),
                    caracteristicas.getAntartico(),
                    caracteristicas.getIndigo()
            ));
            return new ResponseEntity<>(_caracteristicas, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //read
    public ResponseEntity<Caracteristicas> getTutorialById(String id) {
        Optional<Caracteristicas> caracteristicasData = repository.findById(id);

        if (caracteristicasData.isPresent()) {
            return new ResponseEntity<>(caracteristicasData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //update
    public ResponseEntity<Caracteristicas> updateCaracteristicas(String id, Caracteristicas caracteristicas) {
        Optional<Caracteristicas> caracteristicasData = repository.findById(id);

        if (caracteristicasData.isPresent()) {
            Caracteristicas _caracteristicas = caracteristicasData.get();
            _caracteristicas.setData_coleta(caracteristicas.getData_coleta());

            return new ResponseEntity<>(repository.save(_caracteristicas), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete
    public ResponseEntity<HttpStatus> deleteCaracteristicas(String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllCaracteristicas() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
