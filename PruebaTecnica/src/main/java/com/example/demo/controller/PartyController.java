package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Party;
import com.example.demo.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {

	@Autowired
	PartyServiceImpl PartyServiceImpl;

	// Muestra lista Partys
	@GetMapping("/Party")
	public List<Party> listarParty() {
		return PartyServiceImpl.listarParty();
	}

	// Añadir Party desde json
	@PostMapping("/Party")
	public Party salvarParty(@RequestBody Party Party) {

		return PartyServiceImpl.guardarParty(Party);
	}
	

	// Get Partys por id
	@GetMapping("/Party/{party_id}")
	public Party PartyXID(@PathVariable(name = "party_id") Long party_id) {

		Party Party_xid = new Party();

		Party_xid = PartyServiceImpl.PartyXID(party_id);

		System.out.println("Party XID: " + Party_xid);

		return Party_xid;
	}

	// Añadir Party por id
	@PutMapping("/Party/{party_id}")
	public Party actualizarParty(@PathVariable(name = "party_id") Long party_id, @RequestBody Party Party) {

		Party Party_seleccionado = new Party();
		Party Party_actualizado = new Party();

		Party_seleccionado = PartyServiceImpl.PartyXID(party_id);

		Party_seleccionado.setPartyName(Party.getPartyName());

		Party_actualizado = PartyServiceImpl.actualizarParty(Party_seleccionado);

		System.out.println("El Party actualizado es: " + Party_actualizado);

		return Party_actualizado;
	}

	@DeleteMapping("/Party/{party_id}")
	public void eleiminarParty(@PathVariable(name = "party_id") Long party_id) {
		PartyServiceImpl.eliminarParty(party_id);
	}
	


}