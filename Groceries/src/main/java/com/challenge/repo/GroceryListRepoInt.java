package com.challenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.challenge.model.GroceryItem;
import com.challenge.model.GroceryList;

public interface GroceryListRepoInt extends JpaRepository<GroceryList, Integer> {
	//@Query("SELECT g FROM grocery_item g WHERE g.grocery_list = ?1")
	//List<GroceryItem> findAllGroceryItemById(int id);
}
