package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Game;
import com.example.demo.dto.Message;

public interface IGameDAO extends JpaRepository<Game, Long>{

}