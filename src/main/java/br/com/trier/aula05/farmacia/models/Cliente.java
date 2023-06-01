package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Cliente {

	private String nome;
	private Double dividas = 0.0;
	
	public boolean pagarConta (Double valor) {
		if ( dividas >= valor ) {
			dividas -= valor;
			return true;
		}
		return false;
	}
	
	
}
