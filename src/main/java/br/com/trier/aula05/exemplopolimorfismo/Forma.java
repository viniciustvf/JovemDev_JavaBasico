package br.com.trier.aula05.exemplopolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Forma {

	private String nome;
	
	public String desenhar() {
		return "Desenhando um: " + getNome();
	}
	
	
	
	
}
