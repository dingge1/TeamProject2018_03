package com.applicationStart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String customerInterface(Model model) {
		return "index";
	}
	
	@RequestMapping("/waiter")
	public String waiterInterface(Model model) {
		return "waiter";
	}
	
	@RequestMapping("/kitchStaff")
	public String kitchStaffInterface(Model model) {
	  return "kitchStaff";
	}
	
}
