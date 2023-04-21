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
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long message_id;
	@Column(name = "content")
	private String content;
	@Column(name = "date") // formato: 2020-10-10
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "party_id")
	private Party party;

	public Message() {

	}
	
	public Message(Long id_message, String content, Date date, Account account, Party party) {
		super();
		this.message_id = id_message;
		this.content = content;
		this.date = date;
		this.account = account;
		this.party = party;
	}

	public Long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	//No hace falta JSONIgnore ya que al ser manytoone solo se encuentra 1 account
	public Account getAccount() {
		return account;
	}

	public Party getParty() {
		return party;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setParty(Party party) {
		this.party = party;
	}
	
	
	
	
}
