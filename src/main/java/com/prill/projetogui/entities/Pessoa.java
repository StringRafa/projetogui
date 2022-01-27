package com.prill.projetogui.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

	private long id;
	private String nome;
	private int idade;
	private String sexo;

}
