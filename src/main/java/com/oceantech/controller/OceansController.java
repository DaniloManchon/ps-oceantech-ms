package com.oceantech.controller;

import com.oceantech.dto.OceansDto;
import com.oceantech.model.Oceans;
import com.oceantech.service.OceansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class OceansController {
    @Autowired
    OceansService service;

    @PostMapping(value = "/create/oceans")
    public ResponseEntity<Oceans> create(@RequestBody @Validated OceansDto dto){
        String name = dto.getName();
        String data = dto.getData();
        float ph = dto.getPh();
        int co = dto.getCo();
        return service.createOcean(name,data,ph,co);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Oceans> getByName(@PathVariable("name") String name) {
        return service.getOceanByName(name);
    }
//    @GetMapping("/search/{id}")
//    public ResponseEntity<Oceans> getById(@PathVariable("id") String id) {
//        return service.getOceanById(id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        return service.deleteOceans(id);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        return service.deleteAllOceans();
    }
}
