package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Party;

public interface IPartyService {
	//Metodos del CRUD
		public List<Party> listarParty(); //Listar All 
		
		
		public Party guardarParty(Party Party);	//CREATE
		
		public Party PartyXID(Long id_party); //READ
		
		public Party actualizarParty(Party Party); //UPDATE
		
		public void eliminarParty(Long id_party);//DELETE
}