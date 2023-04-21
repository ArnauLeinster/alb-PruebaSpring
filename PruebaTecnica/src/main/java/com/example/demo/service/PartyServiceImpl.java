package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPartyDAO;
import com.example.demo.dto.Party;

@Service
public class PartyServiceImpl implements IPartyService {

	long count = 3;

	public long getCount() {

		return count;
	}

	@Autowired
	IPartyDAO iPartyDAO; // me traigo el dao y dto en impots.

	@Override
	public List<Party> listarParty() {

		return iPartyDAO.findAll();
	}

	@Override
	public Party guardarParty(Party Party) {
		count++;
		return iPartyDAO.save(Party);
	}

	@Override
	public Party PartyXID(Long id_Party) {

		return iPartyDAO.findById(id_Party).get();
	}

	@Override
	public Party actualizarParty(Party Party) {

		return iPartyDAO.save(Party);
	}

	@Override
	public void eliminarParty(Long id_party) {
		count--;
		iPartyDAO.deleteById(id_party);

	}

	public void salirParty() {
		
	}



}