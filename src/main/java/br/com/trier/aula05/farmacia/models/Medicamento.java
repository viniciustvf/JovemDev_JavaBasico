package br.com.trier.aula05.farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

	private boolean receitaMedica;
	
	public Medicamento(String nome, Integer estoque, Double valor, boolean precisaReceita) {
		super(nome, estoque, valor);
		this.receitaMedica = precisaReceita;
	}

	public boolean venderComReceita(Integer quantidade, Cliente cliente, String nome) {
		if ( receitaMedica ) {
			super.vender(quantidade, cliente);
			String nomeMedico = nome;
			return true;
		} else {
			super.vender(quantidade, cliente);
			return false;
		}
	}
	

	

	
}
