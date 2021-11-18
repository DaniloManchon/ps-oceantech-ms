package com.oceantech.controller;

import com.oceantech.dto.OceansDto;
import com.oceantech.dto.OceansUpdateDto;
import com.oceantech.model.Oceans;
import com.oceantech.service.OceansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class OceansController {
    @Autowired
    OceansService service;

    @PostMapping(value = "/create/oceans")
    public ResponseEntity<Oceans> create(@RequestBody @Validated OceansDto dto){
        String name = dto.getName().toLowerCase(Locale.ROOT);
        String data = dto.getData();
        float ph = dto.getPh();
        int co = dto.getCo();
        return service.createOcean(name, data, ph, co);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Oceans> getByName(@PathVariable("name") String name) {
        return service.getOceanByName(name.toLowerCase(Locale.ROOT));
    }
    @GetMapping("/search/id/{id}")
    public ResponseEntity<Oceans> getById(@PathVariable("id") String id) {
        return service.getOceanById(id);
    }

    @PostMapping("/update/{name}")
    public ResponseEntity<Oceans> getById(@PathVariable("name") String name, @RequestBody @Validated OceansUpdateDto dto) {
        String data = dto.getData();
        float ph = dto.getPh();
        int co = dto.getCo();
        return service.updateOceansByName(name.toLowerCase(Locale.ROOT), data, ph, co);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("name") String name) {
        return service.deleteOceansByName(name);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAll() {
        return service.deleteAllOceans();
    }
}
