package br.com.trier.aula05.farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

	private boolean receitaMedica;
	
	public Medicamento(String nome, Integer estoque, Double valor, boolean precisaReceita) {
		super(nome, estoque, valor);
		this.receitaMedica = precisaReceita;
	}

	public boolean vender(Integer quantidade, Cliente cliente) {
		if ( receitaMedica ) {
			super.vender(quantidade, cliente);
			return true;
		} else {
			super.vender(quantidade, cliente);
			return false;
		}
	}
}
