package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Item;
import edu.mum.domain.Staff;

public interface ItemDao extends GenericDao<Item> {
      
	public List<Item> findBySellerOrBuyer(Integer price, Staff buyer, Staff seller);
	public List<Item> findByCategoryName(String categoryName);
	public List<Item> findItemCriteria(Integer initialPrice, Staff buyer, Staff seller);
}
