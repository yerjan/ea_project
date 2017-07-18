package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Balance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BALANCE_ID")
	private Long id = null;

	@Column(name = "PRINCIPAL")
	private BigDecimal principal;

	@Column(name = "INTEREST")
	private BigDecimal interest;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Savings savings;

	@Temporal(TemporalType.DATE)
	@Column(name = "VALUE_DATE", nullable = false)
	private Double valueDate;

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public Balance() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public Savings getSavings() {
		return savings;
	}

	public void setSavings(Savings savings) {
		this.savings = savings;
	}

	// ********************** Accessor Methods ********************** //

	// ********************** Common Methods ********************** //

	// ********************** Business Methods ********************** //

}