package com.vfoprojects.listaapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.vfoprojects.listaapi.dto.ItemDTO;
import com.vfoprojects.listaapi.model.Item;
import com.vfoprojects.listaapi.repository.ItemRepository;
import com.vfoprojects.listaapi.service.exceptions.ExistingItemException;
import com.vfoprojects.listaapi.service.exceptions.ItemNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item insert(ItemDTO dto) {
        if (repository.findByNomeContainingIgnoreCase(dto.getNome()) != null) {
            throw new ExistingItemException("Já existe um item cadastrado com esse nome");
        }

        Item item = new Item(dto.getNome(), dto.getQuantidade());

        return repository.save(item);
    }

    public List<Item> findAll() {

        return repository.findAll();
    }

    public Item findById(Long id) {
        Optional<Item> item = repository.findById(id);

        return item.orElseThrow(() -> new ItemNotFoundException("Não existe item cadastrado com esse id"));
    }

    public Item update(Long id, Item item) {
        findById(id);
        item.setId(id);
        item.setData(LocalDate.now());

        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
