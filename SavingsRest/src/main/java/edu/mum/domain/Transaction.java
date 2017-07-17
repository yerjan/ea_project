package edu.mum.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	public Double getTranDate() {
		return tranDate;
	}

	public void setTranDate(Double tranDate) {
		this.tranDate = tranDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRAN_ID")
	private Long id = null;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Savings savings;

	@Column(name = "CURRENCY", nullable = false)
	private String currency;

	@Column(name = "TYPE", nullable = false)
	private String type;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TRAN_DATE", nullable = false)
	private Double tranDate;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public Transaction() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Savings getSavings() {
		return savings;
	}

	public void setSavings(Savings savings) {
		this.savings = savings;
	}

}
