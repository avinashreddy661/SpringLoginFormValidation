package com.schimatic.Login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.xpath.operations.String;



@Entity
@Table(name="Register")

public class Register implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2160706775612310439L;

	@Column(name="firstname")
	 private String firstName;
	 
	 @Column(name="lastname")
	 private String lastName;
	 
	 @Column(name="email")
	 private String email;
	 
	 @Column(name="mobile")
	 private String mobile;
	 @Id
	 @Column(name="username")
	 private String userName;
	 
	 @Column(name="password")
	 private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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

}
