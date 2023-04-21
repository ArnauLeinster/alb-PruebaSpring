package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Message;

public interface IMessageService {
	//Metodos del CRUD
		public List<Message> listarMessage(); //Listar All 
		
		
		public Message guardarMessage(Message message);	//CREATE
		
		public Message messageXID(Long id_message); //READ
		
		public Message actualizarMessage(Message message); //UPDATE
		
		public void eliminarMessage(Long id_message);//DELETE
}