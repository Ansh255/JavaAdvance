package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="SpringForiegnKey_Table_one")
public class RegVO 
{
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LirstName")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "login_id")
	private LoginVO loginvo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public LoginVO getLoginvo() {
		return loginvo;
	}

	public void setLoginvo(LoginVO loginvo) {
		this.loginvo = loginvo;
	}

	
}
