package com.rbailen.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbailen.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
