package com.prill.projetogui.entities;

import lombok.*;

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
