package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Item;
import edu.mum.domain.Customer;

public interface ItemDao extends GenericDao<Item> {
      
	public List<Item> findBySellerOrBuyer(Integer price, Customer buyer, Customer seller);
	public List<Item> findByCategoryName(String categoryName);
	public List<Item> findItemCriteria(Integer initialPrice, Customer buyer, Customer seller);
}
