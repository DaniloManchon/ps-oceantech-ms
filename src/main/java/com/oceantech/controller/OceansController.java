package com.oceantech.controller;

import com.oceantech.model.Oceans;
import com.oceantech.service.OceansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OceansController {
    @Autowired
    OceansService service;

    @PostMapping("/create/oceans")
    public void create(@RequestBody Oceans oceans){
        service.createOcean(oceans);
    }

    @GetMapping("/search/{ocean}")
    public ResponseEntity<Oceans> getById(@PathVariable("name") String name) {
        return service.getOceanByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        return service.deleteOceans(id);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        return service.deleteAllOceans();
    }
}
