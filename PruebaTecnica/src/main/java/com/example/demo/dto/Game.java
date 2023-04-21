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
@Table(name="games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long game_id;
	
	@Column(name = "game_name")
	private String gameName;
	
	@Column(name = "description")
	private String description;
	
	//manytomany
	@OneToMany
	@JoinColumn(name = "party_id")
	private List<Party> party;
	
	public Game () {
		
	}
	
	public Game(Long game_id, String gameName, String description) {
		super();
		this.game_id = game_id;
		this.gameName = gameName;
		this.description = description;
	
	}

	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
