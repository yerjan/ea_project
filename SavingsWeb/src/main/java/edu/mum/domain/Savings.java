package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.mum.validation.EmptyOrSize;

@Entity
@Table(name = "SAVINGS")
public class Savings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private Long id = null;

	@EmptyOrSize(min = 4, max = 19, message = "{EmptyOrSize}")
	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	private String status = "NEW";

	@NotEmpty
	@Column(name = "CURRENCY", nullable = false)
	private String currency;

	@NotNull
	@Column(name = "INTEREST_RATE", nullable = false)
	private Double interestRate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Future

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "END_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@NotNull
	@Column(name = "CUSTOMER_ID", nullable = false)
	private Long customerId;

	// @JsonIgnore
	// @JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "savings")
	private Set<Balance> balances = new HashSet<Balance>();

	// @JsonIgnore
	// @JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "savings")
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<Balance> getBalances() {
		return balances;
	}

	public void setBalances(Set<Balance> balances) {
		this.balances = balances;
	}

}