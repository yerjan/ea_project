package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Balance;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;
import edu.mum.service.SavingsService;

@Controller
@RequestMapping({ "/savings" })
public class SavingsController {

	@Autowired
	private SavingsService savingsService;

	@RequestMapping("/{id}")
	public String getSavingsById(@PathVariable("id") Long id, Model model) {
		Savings savings = savingsService.findOne(id);
		List<Transaction> transactions = savingsService.tranListByAccountId(id);
		Balance balance = savingsService.getActiveBalance(id);
		model.addAttribute("transactions", transactions);
		model.addAttribute("savings", savings);
		model.addAttribute("balance", balance);

		return "savings";
	}

	@RequestMapping("/income/{id}")
	public String getSavingsById1(@PathVariable("id") Long id, Model model) {
		Savings savings = savingsService.findOne(id);
		List<Transaction> transactions = savingsService.tranListByAccountId(id);
		Balance balance = savingsService.getActiveBalance(id);
		model.addAttribute("transactions", transactions);
		model.addAttribute("savings", savings);
		model.addAttribute("balance", balance);

		return "savings";
	}

}
