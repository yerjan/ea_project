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
@Table(name = "STAFF")
public class Staff extends Person implements Serializable {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "USER_ID")
	// private Long id = null;

	@Version
	private int version = 0;

	@Column(name = "RANK", nullable = true)
	private int ranking = 0;

	@Column(name = "IS_ADMIN", nullable = true)
	private boolean admin = false;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@JsonBackReference
	private StaffCredentials userCredentials;

	// @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,
	// mappedBy = "user")
	// @JsonIgnore
	// private Set<Address> addresses = new HashSet<Address>();

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public StaffCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(StaffCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
}