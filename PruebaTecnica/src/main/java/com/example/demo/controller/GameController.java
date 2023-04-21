package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Game;
import com.example.demo.dto.Party;
import com.example.demo.service.GameServiceImpl;
import com.example.demo.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class GameController {

	@Autowired
	GameServiceImpl GameServiceImpl;

	@GetMapping("/Games")
	public List<Game> listarGames() {
		return GameServiceImpl.listarGame();
	}

	// Añadir Game desde json
	@PostMapping("/Games")
	public Game salvarGame(@RequestBody Game Game) {

		return GameServiceImpl.guardarGame(Game);
	}

	// Get Games por id
	@GetMapping("/Games/{game_id}")
	public Game GameXID(@PathVariable(name = "game_id") Long game_id) {

		Game Game_xid = new Game();

		Game_xid = GameServiceImpl.GameXID(game_id);

		System.out.println("Game XID: " + Game_xid);

		return Game_xid;
	}


	
	
	// Añadir Game por id
	@PutMapping("/Games/{game_id}")
	public Game actualizarGame(@PathVariable(name = "game_id") Long game_id, @RequestBody Game Game) {

		Game Game_seleccionado = new Game();
		Game Game_actualizado = new Game();

		Game_seleccionado = GameServiceImpl.GameXID(game_id);

		Game_seleccionado.setDescription(Game.getDescription());
		Game_seleccionado.setGameName(Game.getGameName()); 

		Game_actualizado = GameServiceImpl.actualizarGame(Game_seleccionado);

		System.out.println("El Game actualizado es: " + Game_actualizado);

		return Game_actualizado;
	}

	@DeleteMapping("/Games/{game_id}")
	public void eleiminarGame(@PathVariable(name = "game_id") Long game_id) {
		GameServiceImpl.eliminarGame(game_id);
	}

}