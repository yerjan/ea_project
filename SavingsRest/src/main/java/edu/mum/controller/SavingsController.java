package edu.mum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;
import edu.mum.service.SavingsService;

@RestController
@RequestMapping({ "/savings" })
public class SavingsController {

	@Autowired
	private SavingsService savingsService;

	@RequestMapping
	public List<Savings> listSavings(Model model, @RequestParam(value = "customerId", required = false) Long id) {
		if (id != null) {
			return savingsService.findByCustomer(id);
		} else {
			return savingsService.findAll();
		}
	}

	@RequestMapping("/{id}")
	public Savings getSavingsById(@PathVariable("id") Long id) {
		return savingsService.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Savings processAddNewSavingsForm(@RequestBody Savings savingsToBeAdded) {

		try {
			savingsService.save(savingsToBeAdded);
		} catch (Exception up) {
			System.out.println("transaction Failed!!!");

		}

		return null;

	}

	@RequestMapping(value = "/income", method = RequestMethod.POST)
	public Savings processIncome(@RequestBody Transaction tran) {
		Savings s = null;
		try {
			s = savingsService.incrementBalance(tran);

		} catch (Exception up) {
			System.out.println("Income transaction Failed!!!");

		}

		return s;

	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public Savings processWithdraw(@RequestBody Transaction tran) {
		Savings s = null;
		try {
			s = savingsService.decrementBalance(tran);

		} catch (Exception up) {
			System.out.println("Withdraw transaction Failed!!!");

		}

		return s;

	}

	@RequestMapping(value = "/close", method = RequestMethod.POST)
	public Savings processClose(@RequestBody Savings savings) {
		Savings s = null;
		try {
			s = savingsService.closeSavings(savings.getId());

		} catch (Exception up) {
			System.out.println("Close transaction Failed!!!");

		}

		return s;

	}

	@RequestMapping(value = "/open", method = RequestMethod.POST)
	public Savings processOpen(@RequestBody Savings savings) {
		Savings s = null;
		try {
			s = savingsService.openSavings(savings.getId());

		} catch (Exception up) {
			System.out.println("Open transaction Failed!!!");

		}

		return s;

	}

	// www.something.com/customers/
	// www.something.com/customers?age=5
	// www.something.com/customers/5

	// www.something.com/savings?customerId=5
	// www.something.com/savings/5

	// www.something.com//

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Transaction listTranByAccount(@PathVariable("id") Long id) {
		Transaction s = null;
		try {
			// s = savingsService

		} catch (Exception up) {
			System.out.println("listTranByAccount transaction Failed!!!");

		}

		return s;

	}

}
