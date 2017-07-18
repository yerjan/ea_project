package edu.mum.domain;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Version
	private int version = 0;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "STATUS", nullable = false)
	private String status;

	@Column(name = "CURRENCY", nullable = false)
	private String currency;

	@Column(name = "INTEREST_RATE", nullable = false)
	private Double interestRate;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false)
	private Double startDate;

	@Future
	@Column(name = "END_DATE", nullable = false)
	private Double endDate;

	@Column(name = "CUSTOMER_ID", nullable = false)
	private Long customerId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "savings")
	@JsonIgnore
	private Set<Balance> balances = new HashSet<Balance>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "savings")
	@JsonIgnore
	private Set<Transaction> transactions = new HashSet<Transaction>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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