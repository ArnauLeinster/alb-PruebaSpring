package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Account;
import com.example.demo.dto.Message;

public interface IAccountDAO extends JpaRepository<Account, Long>{

}