package edu.mum.amqp;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import edu.mum.domain.Transaction;


@Component
public class TransactionMessageServiceImpl implements TransactionMessageService {
    public void publish(RabbitTemplate rabbitTemplate, Transaction transaction, String customerName) {
    	TransactionMessage message = new TransactionMessage();
    	
    	String content = 
    			"{'transaction_id':'" + transaction.getId() + "',\n"
				+ "'customer_name':" + customerName + "',\n"
				+ "'savings_name':" + transaction.getSavings().getName() + "',\n"
    	    	+ "'description':" + transaction.getDescription() + "',\n"
    			+ "'amount':" + transaction.getAmount() + "',\n"
				+ "'currency':" + transaction.getCurrency() + "'}";
    	
    	message.setContent(content);
    	rabbitTemplate.convertAndSend(message);
    }
}
