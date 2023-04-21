package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Game;

public interface IGameService {
	//Metodos del CRUD
		public List<Game> listarGame(); //Listar All 
		
		
		public Game guardarGame(Game Game);	//CREATE
		
		public Game GameXID(Long id_game); //READ
		
		public Game actualizarGame(Game Game); //UPDATE
		
		public void eliminarGame(Long id_game);//DELETE
}