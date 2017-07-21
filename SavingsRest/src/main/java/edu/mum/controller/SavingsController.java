package edu.mum.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.amqp.TransactionMessageService;
import edu.mum.domain.Balance;
import edu.mum.domain.Customer;
import edu.mum.domain.Savings;
import edu.mum.domain.Transaction;
import edu.mum.service.CustomerService;
import edu.mum.service.SavingsService;

@RestController
@RequestMapping({ "/savings" })
public class SavingsController {

	@Autowired
	private SavingsService savingsService;

	@Autowired
	private TransactionMessageService messageService;

	@Autowired
	private RabbitTemplate customerMessageTemplate;

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public List<Savings> listSavings(Model model, @RequestParam(value = "customerId", required = false) Long id) {
		if (id != null) {
			return savingsService.findByCustomer(id);
		} else {
			return savingsService.findAll();
		}
	}

	@RequestMapping("/{id}")
	public Savings findOne(@PathVariable("id") Long id) {
		return savingsService.findOne(id);
	}

	@RequestMapping(value = "/addSavings", method = RequestMethod.POST)
	public Savings processAddNewSavingsForm(@RequestBody Savings savingsToBeAdded) {

		try {
			savingsService.createSavings(savingsToBeAdded);
		} catch (Exception up) {
			System.out.println("processAddNewSavingsForm Failed!!!");
			System.out.println("processAddNewSavingsForm: " + up.getMessage());

		}

		return null;

	}

	@RequestMapping(value = "/income", method = RequestMethod.POST)
	public Transaction processIncome(@RequestBody Transaction tran) {
		Transaction t = null;
		try {
			t = savingsService.incrementBalance(tran);
			Customer customer = customerService.findOne(t.getSavings().getCustomerId());

			messageService.publish(customerMessageTemplate, t, customer.getFullName());
			return t;
		} catch (Exception up) {
			System.out.println("Income transaction Failed!!!");
			System.out.println("processIncome: " + up.getMessage());

		}
		return t;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public Transaction processWithdraw(@RequestBody Transaction tran) {
		Transaction t = null;
		try {
			t = savingsService.decrementBalance(tran);
			Customer customer = customerService.findOne(t.getSavings().getCustomerId());

			messageService.publish(customerMessageTemplate, t, customer.getFullName());
			return t;
		} catch (Exception up) {
			System.out.println("Withdraw transaction Failed!!!");
			System.out.println("processWithdraw: " + up.getMessage());
		}
		return t;
	}

	@RequestMapping(value = "/transaction")
	public List<Transaction> listTranByAccount(Model model, @RequestParam(value = "accountId") Long id) {

		return savingsService.listTransaction(id);

	}

	@RequestMapping(value = "/balance")
	public Balance getActiveBalance(Model model, @RequestParam(value = "accountId") Long id) {

		return savingsService.getActiveBalance(id);

	}

}
