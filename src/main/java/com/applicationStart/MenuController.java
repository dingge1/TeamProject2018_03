package com.applicationStart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController // Returns objects, not views 
public class MenuController {
	
	MenuRepo menuRepo;
	
	/*
	 * The following alternate variables are used to literally alternate between 
	 * ascending and descending list of orders. For example, when clicking the 'containsNuts' header
	 * on the menu interface, a GET request is called and the menu is filtered to show items that do not 
	 * contain nuts. However, if the customer clicks on this again then we must execute the opposite; hence we
	 * use alternate variables to do so.
	 */
	boolean alternateNuts = true;
	boolean alternatePrice = true;
	boolean alternateVeg = true;
	
	@Autowired
	public MenuController(MenuRepo menuRepo) {
		this.menuRepo = menuRepo;
	}
	
	@RequestMapping(value = "/menu", method=RequestMethod.GET)
	public List<MenuItem> getItems() {
		return menuRepo.findAll();
	}
	
	@RequestMapping(value="/filterMenuVeg", method=RequestMethod.GET)
	public List<MenuItem> getItemsFilteredByVeg(){
		if(alternateVeg) {
			alternateVeg = false;
			return menuRepo.findAllByOrderByIsVegAsc();
		} else {
			alternateVeg = true;
			return menuRepo.findAllByOrderByIsVegDesc();
		}
	}
	
	@RequestMapping(value="/filterMenuNuts", method=RequestMethod.GET)
	public List<MenuItem> getItemsFilteredByNuts(){
		if(alternateNuts) {
			alternateNuts = false;
			return menuRepo.findAllByOrderByContainsNutsAsc();
		} else {
			alternateNuts = true;
			return menuRepo.findAllByOrderByContainsNutsDesc();
		}
	}
	
	@RequestMapping(value="/filterMenuPrice", method=RequestMethod.GET)
	public List<MenuItem> getItemsFilteredByPrice(){
		if(alternatePrice) {
			alternatePrice = false;
			return menuRepo.findAllByOrderByPriceAsc();
		} else {
			alternatePrice = true;
			return menuRepo.findAllByOrderByPriceDesc();
		}
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public List<MenuItem> addItem(@RequestBody MenuItem menuItem){
		menuRepo.save(menuItem);
		return menuRepo.findAll();
	}
	
	@RequestMapping(value = "/delete/{id}", method=RequestMethod.POST)
	public List<MenuItem> deleteItem(@PathVariable long id){
		menuRepo.delete(id);
		return menuRepo.findAll();
	}
	
	
	
	
	
}
