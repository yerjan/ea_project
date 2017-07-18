package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;
import edu.mum.domain.Savings;

@Component
public interface SavingRestService {

	public Savings findOne(Long index);

	public List<Savings> findByCustomerId(Long customerId);

}
