package com.challenge.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GroceryList")
public class GroceryList {
	@Column
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			   mappedBy="groceryList")
	private List<GroceryItem> groceries = new ArrayList<GroceryItem>();

	public GroceryList() {
		super();
	}
	
	public GroceryList(int id, String name, List<GroceryItem> groceries) {
		super();
		this.id = id;
		this.name = name;
		this.groceries = groceries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<GroceryItem> getGroceries() {
		return groceries;
	}

	public void setGroceries(List<GroceryItem> groceries) {
		this.groceries = groceries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groceries == null) ? 0 : groceries.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		if (groceries == null) {
			if (other.groceries != null)
				return false;
		} else if (!groceries.equals(other.groceries))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", name=" + name + ", groceries=" + groceries + "]";
	}
}
