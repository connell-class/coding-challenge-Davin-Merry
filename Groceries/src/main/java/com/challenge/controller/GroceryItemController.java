package com.challenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.model.GroceryItem;
import com.challenge.repo.GroceryItemRepoInt;

/**
 * This controller will list any groceries
 * ([TODO] Not on a list, if possible).
 * 
 * @author Davin Merry
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/grocery-items")
public class GroceryItemController {
	@Autowired
	private GroceryItemRepoInt gi;
	
	//[TODO] Get all groceries that do not belong in the current list.
	@GetMapping("all")
	public Iterable<GroceryItem> getAll() {
		return gi.findAll();
	}
	
	@GetMapping("item/{id}")
	public Optional<GroceryItem> getItem(@PathVariable int id) {
		try {
			return gi.findById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@PostMapping("create")
	public void addGrocery(@RequestBody GroceryItem g) {
		try {
			gi.save(g);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
