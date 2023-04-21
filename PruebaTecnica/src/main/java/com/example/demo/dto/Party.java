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
@Table(name = "parties")
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long party_id;
	
	@Column(name = "party_name")
	private String partyName;
	
	
	//manytomany
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	@OneToMany
	@JoinColumn(name = "message_id")
	private List<Message> message;
	
	//manytomany
	@ManyToOne
	@JoinColumn(name = "acc_id")
	private Account account;
	
	
	public Party() {

	}

	public Party(Long party_id, String partyName, Game game, Account account) {
		super();
		this.party_id = party_id;
		this.partyName = partyName;
		this.game = game;
		this.account = account;
	}

	public Long getParty_id() {
		return party_id;
	}

	public void setParty_id(Long party_id) {
		this.party_id = party_id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Message")
	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	
	public Account getAccount() {
		return account;
	}

	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
