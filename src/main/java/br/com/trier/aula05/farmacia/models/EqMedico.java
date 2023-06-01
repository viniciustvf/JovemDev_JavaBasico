package br.com.trier.aula05.farmacia.models;

import lombok.Getter;

@Getter 
public class EqMedico extends Produto {

	public EqMedico(String nome, Integer estoque, Double valor) {
		super(nome, estoque, valor);
	}
}
