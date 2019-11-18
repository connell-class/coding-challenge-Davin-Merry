package com.challenge.repo;

import org.springframework.data.repository.CrudRepository;

import com.challenge.model.GroceryItem;

public interface GroceryItemRepoInt extends CrudRepository<GroceryItem, Integer> {
	
}
