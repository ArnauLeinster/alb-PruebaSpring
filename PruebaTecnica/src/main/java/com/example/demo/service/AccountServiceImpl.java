package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAccountDAO;
import com.example.demo.dto.Account;

// implements IUserService
@Service
public class AccountServiceImpl implements IAccountService{
	
	//Utilizamos los metodos de la interface IUserDAO
	@Autowired
	IAccountDAO IAccountDAO;
	
	@Override
	public List<Account> listarAccount() {
		
		return IAccountDAO.findAll();
	}

	@Override
	public Account guardarAccount(Account Account) {
		
		return IAccountDAO.save(Account);
	}

	@Override
	public Account accountXID(Long acc_id) {
		
		return IAccountDAO.findById(acc_id).get();
	}

	@Override
	public Account actualizarAccount(Account Account) {
		
		return IAccountDAO.save(Account);
	}

	@Override
	public void eliminarAccount(Long acc_id) {
		
		IAccountDAO.deleteById(acc_id);
		
	}

}