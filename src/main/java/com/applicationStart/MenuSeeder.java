package com.applicationStart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Spring will search for components first and execute them
public class MenuSeeder implements CommandLineRunner { //Executes everytime application starts
	
	private MenuRepo menuRepo;
	
	@Autowired
	public MenuSeeder(MenuRepo menuRepo) {
		this.menuRepo = menuRepo;
	}

	@Override
	public void run(String... strings) throws Exception {
		List<MenuItem> items = new ArrayList<>();
		items.add(new MenuItem("Extra Cheesy Pizza", 10.0, "carbs", true, true, "Calories 100", 5));
		items.add(new MenuItem("Extra Cheesy Chips", 4.0, "carbs", false, true, "Calories 800", 6));
		items.add(new MenuItem("Extra Cheesy Tuna", 18.0, "protein", true, false, "Calories 400", 7));
		menuRepo.save(items);
	}
		
}
