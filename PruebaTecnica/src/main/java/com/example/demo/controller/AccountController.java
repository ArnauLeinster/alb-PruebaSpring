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

import com.example.demo.dto.Account;
import com.example.demo.service.AccountServiceImpl;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	AccountServiceImpl AccountServiceImpl;

	// Muestra lista Users
	@GetMapping("/Accounts")
	public List<Account> listarUsers() {
		return AccountServiceImpl.listarAccount();
	}

	// Añadir User desde json
	@PostMapping("Accouns")
	public Account salvarUser(@RequestBody Account Account) {

		return AccountServiceImpl.guardarAccount(Account);
	}

	// Get Users por id
	@GetMapping("/Users/{acc_id}")
	public Account AccountXID(@PathVariable(name = "acc_id") Long acc_id) {

		Account Account_xid = new Account();

		Account_xid = AccountServiceImpl.accountXID(acc_id);

		System.out.println("Account XID: " + Account_xid);

		return Account_xid;
	}

	// Añadir User por id
	@PutMapping("/Accounts/{acc_id}")
	public Account actualizarUser(@PathVariable(name = "acc_id") Long acc_id, @RequestBody Account Account) {

		Account Account_seleccionado = new Account();
		Account Account_actualizado = new Account();

		Account_seleccionado = AccountServiceImpl.accountXID(acc_id);

		Account_seleccionado.setUsername(Account.getUsername());
		Account_seleccionado.setPassword(Account.getPassword());
		Account_seleccionado.setEmail(Account.getEmail());

		Account_actualizado = AccountServiceImpl.actualizarAccount(Account_seleccionado);

		System.out.println("La cuenta actualizada es: " + Account_actualizado);

		return Account_actualizado;
	}

	@DeleteMapping("/Users/{acc_id}")
	public void eleiminarAccount(@PathVariable(name = "acc_id") Long acc_id) {
		AccountServiceImpl.eliminarAccount(acc_id);
	}

}