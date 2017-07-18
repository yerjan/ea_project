package edu.mum.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;	
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person implements Serializable {

	@Column
	private String status;
	
	@Column
	private int creditScore;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
	private List<Savings> savings;


	public List<Savings> getSavings() {
		return savings;
	}

	public void setSavings(List<Savings> savings) {
		this.savings = savings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	
}