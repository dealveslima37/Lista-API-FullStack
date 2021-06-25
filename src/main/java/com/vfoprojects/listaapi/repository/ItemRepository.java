package com.vfoprojects.listaapi.repository;

import com.vfoprojects.listaapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByNomeContainingIgnoreCase(String nome);

}
