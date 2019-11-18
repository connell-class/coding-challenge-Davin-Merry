package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.model.GroceryItem;
import com.challenge.model.GroceryList;
import com.challenge.repo.GroceryListRepoInt;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/grocery-lists")
public class GroceryListController {
	@Autowired
	private GroceryListRepoInt gr;
	
	@GetMapping("get")
	public Iterable<GroceryList> getLists() {
		return gr.findAll();
	}
	
	@PostMapping("create")
	public boolean createList(@RequestBody GroceryList gl) {
		try {
			gr.save(gl);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@PostMapping("items/add")
	public boolean addItemToList(@RequestBody GroceryItem gi) {
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@DeleteMapping("items/remove/{id}")
	public boolean removeGroceryItem(@RequestBody GroceryList gl, @PathVariable int id) {
		try {
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@DeleteMapping("delete")
	public boolean removeGroceryList(@RequestBody GroceryList gl) {
		try {
			gr.delete(gl);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
