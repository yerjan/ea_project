package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends Person implements Serializable {

	@Version
	private int version = 0;

}