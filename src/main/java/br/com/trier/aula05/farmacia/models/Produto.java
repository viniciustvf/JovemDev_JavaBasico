package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Produto {

	protected String nome;
	protected int estoque;
	protected Double valor;
	
	public boolean vender(int quantidade, Cliente cliente) {
		if ( temEstoque() ) {
			cliente.setDividas( cliente.getDividas() + (valor * quantidade) );
			estoque -= quantidade;
			return true;
		}
		return false;
	}
	
	public boolean temEstoque() {
		if ( estoque != 0 ) {
			return true;
		}
		return false;
	}
}
