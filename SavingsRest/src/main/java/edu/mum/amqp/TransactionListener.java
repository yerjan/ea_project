package edu.mum.amqp;

import edu.mum.domain.Transaction;

public class TransactionListener {

	public void listen(TransactionMessage message) {
		
		System.out.println(">>>> MESSAGE RECIEVED!");
		System.out.println(message.getContent());
	}
}
