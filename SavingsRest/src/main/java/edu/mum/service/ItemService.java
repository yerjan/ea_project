package edu.mum.service;

import java.util.List;

import edu.mum.domain.Item;
import edu.mum.domain.Staff;
 
public interface ItemService {

	public void save(Item Item);
	public Item update(Item Item);
	public List<Item> findAll();
	 
	public List<Item> findBySellerOrBuyer(Integer price, Staff buyer, Staff seller);
	public List<Item> findByCategoryName(String categoryName);	 
	public List<Item> findItemCriteria(Integer initialPrice, Staff buyer, Staff seller);
	public Item findOne(Long id);

}
