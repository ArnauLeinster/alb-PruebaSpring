package com.example.demo.dto;

import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acc_id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	@OneToMany
	@JoinColumn(name = "message_id")
	private List<Message> message;
	
	//manytomany
	@OneToMany
	@JoinColumn(name = "party_id")
	private List<Party> party;

	public Account() {

	}

	public Account(Long id_user, String username, String password, String email, String steam_user) {
		super();
		this.acc_id = id_user;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String toString() {
		return "id:" + acc_id + ", username:" + username + 
				", password:" + password + ", email:" + email;
	}

	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//Para evitar bucles
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Party")
	public List<Party> getParty() {
		return party;
	}

	public void setParty(List<Party> party) {
		this.party = party;
	}
	
	

}
