package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import edu.mum.domain.Transaction;

@Component
public interface TransactionMessageService {
    public void publish(RabbitTemplate rabbitTemplate, Transaction transaction, String customerName);
}		
