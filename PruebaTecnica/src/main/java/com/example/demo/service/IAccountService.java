package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Account;

public interface IAccountService {
	//Metodos del CRUD
	public List<Account> listarAccount(); //Listar All 
	
	public Account guardarAccount(Account account);	// CREATE
	
	public Account accountXID(Long acc_id); // READ
	
	public Account actualizarAccount(Account account); // UPDATE
	
	public void eliminarAccount(Long acc_id);// DELETE
	
}