package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/income", method = RequestMethod.GET)
	public String getIncomeForm(@ModelAttribute("newTransaction") Transaction newTransaction) {
		return "TranIncome";
	}

	@RequestMapping(value = "/income", method = RequestMethod.POST)
	public String processIncomeForm(@ModelAttribute("newTransaction") @Valid Transaction tranToBeAdded,
			BindingResult result) {

		if (result.hasErrors()) {
			return "income";
		}

		// Error caught by ControllerAdvice IF no authorization...
		Savings s = savingsService.processIncome(tranToBeAdded);

		return "redirect:/savings/" + s.getId();

	}

}
