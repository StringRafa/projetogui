package com.prill.projetogui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/olamundo")
public class OlaMundoController {

	@RequestMapping(method = RequestMethod.GET)
	public String olaMundo() {
		return "Olá mundo";
	}
}
