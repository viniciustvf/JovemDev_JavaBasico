package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
public class Cliente {

	private String nome;
	private Double dividas;
	
	public double pagarConta(double vl) {
		if(vl > 0 && getDividas() >= vl) {
			dividas = getDividas() - vl;
		}
		return getDividas();
	}
	
	public void adicionaValor(double vl) {
		dividas = getDividas() + vl;
	}

}
