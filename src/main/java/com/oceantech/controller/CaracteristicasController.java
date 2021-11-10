package com.oceantech.controller;

import com.oceantech.model.Caracteristicas;
import com.oceantech.repository.CaracteristicasRepository;
import com.oceantech.service.CaracteristicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaracteristicasController {

    @Autowired
    CaracteristicasService service;

    @GetMapping("/quimica")
    public ResponseEntity<Caracteristicas> readAll(){
        return service.getTutorialById("1");
    }

    //CRUD
    @PostMapping("/create/caracteristica")
    public ResponseEntity<Caracteristicas> create(@RequestBody Caracteristicas caracteristicas) {
       return service.createCaracteristica(caracteristicas);
    }

    @PostMapping("/read/caracteristica/id")
    public ResponseEntity<Caracteristicas> getById(@PathVariable("id") String id) {
    return service.getTutorialById(id);
    }

    @PutMapping("/update/caracteristicas")
    public ResponseEntity<Caracteristicas> update(@PathVariable("id") String id, @RequestBody Caracteristicas caracteristicas) {
        return service.updateCaracteristicas(id,caracteristicas);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
       return service.deleteCaracteristicas(id);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        return service.deleteAllCaracteristicas();
    }
}
