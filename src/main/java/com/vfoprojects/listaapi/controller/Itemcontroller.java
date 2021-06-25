package com.vfoprojects.listaapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.vfoprojects.listaapi.dto.ItemDTO;
import com.vfoprojects.listaapi.model.Item;
import com.vfoprojects.listaapi.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens")
public class Itemcontroller {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody ItemDTO dto) {
        Item item = service.insert(dto);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> readAll() {
        List<Item> itens = service.findAll();
        return new ResponseEntity<List<Item>>(itens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> readById(@PathVariable Long id) {
        Item item = service.findById(id);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Item item) {
        service.update(id, item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
