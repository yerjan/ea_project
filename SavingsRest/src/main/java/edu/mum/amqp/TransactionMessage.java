package edu.mum.amqp;


import java.io.Serializable;

public class TransactionMessage implements Serializable {

	private String content;

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public TransactionMessage() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
