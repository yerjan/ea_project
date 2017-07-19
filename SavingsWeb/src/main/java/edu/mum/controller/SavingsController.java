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
import org.springframework.web.bind.annotation.RequestParam;

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
		System.out.println("before accountList");
		Savings savings = savingsService.findOne(id);
		System.out.println("before tranListByAccount");
		List<Transaction> transactions = savingsService.tranListByAccountId(id);
		System.out.println("before Balance");
		Balance balance = savingsService.getActiveBalance(id);
		System.out.println("before transaction");
		model.addAttribute("transactions", transactions);

		model.addAttribute("savings", savings);

		model.addAttribute("balance", balance);

		return "savings";
	}

	@RequestMapping(value = "/income", method = RequestMethod.GET)
	public String getIncomeForm(@RequestParam("accountId") Long id,
			@ModelAttribute("newTransaction") Transaction newTransaction) {
		Savings savings = savingsService.findOne(id);
		newTransaction.setSavings(savings);
		return "TranIncome";
	}

	@RequestMapping(value = "/income", method = RequestMethod.POST)
	public String processIncomeForm(@ModelAttribute("newTransaction") @Valid Transaction tranToBeAdded,
			BindingResult result) {
		System.out.println("processIncomeForm");
		if (result.hasErrors()) {
			return "TranIncome";
		}
		System.out.println("processIncomeForm1");
		Savings savings = savingsService.findOne(tranToBeAdded.getSavings().getId());
		tranToBeAdded.setSavings(savings);
		System.out.println("processIncomeForm3: " + savings.getId());
		// Error caught by ControllerAdvice IF no authorization...
		Savings s = savingsService.processIncome(tranToBeAdded);
		System.out.println("processIncomeForm4: ");
		return "redirect:/savings/" + savings.getId();

	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String getWithdrawForm(@RequestParam("accountId") Long id,
			@ModelAttribute("newTransaction") Transaction newTransaction) {
		Savings savings = savingsService.findOne(id);
		newTransaction.setSavings(savings);
		return "TranWithdraw";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String processWithdrawForm(@ModelAttribute("newTransaction") @Valid Transaction tranToBeAdded,
			BindingResult result) {
		System.out.println("processIncomeForm");
		if (result.hasErrors()) {
			return "TranWithdraw";
		}
		System.out.println("processIncomeForm1");
		Savings savings = savingsService.findOne(tranToBeAdded.getSavings().getId());
		tranToBeAdded.setSavings(savings);
		System.out.println("processIncomeForm3: " + savings.getId());
		// Error caught by ControllerAdvice IF no authorization...
		Savings s = savingsService.processWithdraw(tranToBeAdded);
		System.out.println("processIncomeForm4: ");
		return "redirect:/savings/" + savings.getId();

	}

}
