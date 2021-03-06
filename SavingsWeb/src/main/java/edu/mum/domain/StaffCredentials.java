package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "AUTHENTICATION") // Authentication
public class StaffCredentials {

	@Id
	@Column(name = "USER_NAME", nullable = false, unique = true, length = 127)
	String userName;
	@Column(name = "PASSWORD", nullable = true, length = 32)
	String password;
	@Column(name = "VERIFY_PASSWORD", nullable = true, length = 32)
	String verifyPassword;
	@Column(name = "ENABLED")
	Boolean enabled;

	@OneToOne(mappedBy = "userCredentials", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference
	private Staff user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "CREDENTIAL_AUTHORITY", joinColumns = {
			@JoinColumn(name = "CREDENTIAL_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", unique = true) })
	List<Authority> authority = new ArrayList<Authority>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Staff getUser() {
		return user;
	}

	public void setUser(Staff user) {
		this.user = user;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

}
