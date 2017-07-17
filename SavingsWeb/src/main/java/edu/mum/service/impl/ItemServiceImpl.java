package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Item;
import edu.mum.rest.service.ItemRestService;
import edu.mum.service.ItemService;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	private ItemRestService itemRestService;

    public void save( Item Item) {  		
		itemRestService.save(Item);
	}
	
	
 	public List<Item> findAll() {
		return (List<Item>)itemRestService.findAll();
	}

 	public Item findOne(Long id) {
		return itemRestService.findOne(id);
	}


}
