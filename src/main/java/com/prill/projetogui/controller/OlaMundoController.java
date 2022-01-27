package com.prill.projetogui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prill.projetogui.entities.Pessoa;

@RestController
@RequestMapping(path = "/olamundo")
public class OlaMundoController {

	@RequestMapping(method = RequestMethod.GET)
	public String olaMundo() {
		return "Olá mundo";
	}


	@PostMapping(path = "/pessoa")
	public ResponseEntity<Object> enviar(@RequestBody Pessoa pessoa){
		if (pessoa.getIdade() >= 18){
			return new ResponseEntity<>( "Nome: "+ pessoa.getNome()
					+ "\nSexo: "
					+ pessoa.getSexo()
					+ "\nIdade: "
					+ pessoa.getIdade()
					+ "\nUsuario maior de idade!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Nome: "+ pessoa.getNome()
					+ "\nSexo: "
					+ pessoa.getSexo()
					+ "\nIdade: "
					+ pessoa.getIdade()
					+ "\nUsuario menor de idade!", HttpStatus.OK);
		}
	}
}
