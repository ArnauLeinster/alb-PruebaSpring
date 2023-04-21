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

import com.example.demo.dto.Message;
import com.example.demo.service.MessageServiceImpl;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageServiceImpl MessageServiceImpl;

	@GetMapping("/Messages")
	public List<Message> listarMessages() {
		return MessageServiceImpl.listarMessage();
	}

	// Añadir Message desde json
	@PostMapping("/Messages")
	public Message salvarMessage(@RequestBody Message Message) {

		return MessageServiceImpl.guardarMessage(Message);
	}

	// Get Messages por id
	@GetMapping("/Messages/{message_id}")
	public Message MessageXID(@PathVariable(name = "message_id") Long message_id) {

		Message Message_xid = new Message();

		Message_xid = MessageServiceImpl.messageXID(message_id);

		System.out.println("Message XID: " + Message_xid);

		return Message_xid;
	}

	// Añadir Message por id
	@PutMapping("/Messages/{message_id}")
	public Message actualizarMessage(@PathVariable(name = "message_id") Long message_id, @RequestBody Message Message) {

		Message Message_seleccionado = new Message();
		Message Message_actualizado = new Message();

		Message_seleccionado = MessageServiceImpl.messageXID(message_id);

		Message_seleccionado.setContent(Message.getContent());

		Message_seleccionado.setDate(Message.getDate());

		Message_actualizado = MessageServiceImpl.actualizarMessage(Message_seleccionado);

		System.out.println("El Message actualizado es: " + Message_actualizado);

		return Message_actualizado;
	}

	@DeleteMapping("/Messages/{message_id}")
	public void eleiminarMessage(@PathVariable(name = "message_id") Long message_id) {
		MessageServiceImpl.eliminarMessage(message_id);
	}
	
//	@GetMapping("/Messages/chat")
//	public List<Message> charMessages() {
//		List<Message> result = null;
//		List<Message> mes = MessageServiceImpl.listarMessage();
//		Message message = new Message();
//		for (int i = 0;i<mes.size();i++) {
//			message = MessageXID(Long.valueOf(i));
//			result.add(message);
//		}
//		return result;
//	}

}