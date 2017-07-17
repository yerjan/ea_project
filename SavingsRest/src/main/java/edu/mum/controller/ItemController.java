package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.Item;
import edu.mum.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
 
 	@RequestMapping({"","/all"})
	public List<Item> list(Model model) {
		return itemService.findAll();

	}
	
 	@RequestMapping("/{id}")
	public Item getItemById(@PathVariable("id") Long id) {

		return itemService.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Item processAddNewItemForm(@RequestBody Item itemToBeAdded) {
 
 		try {
			itemService.save(itemToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return null;
	}
	
   
}
