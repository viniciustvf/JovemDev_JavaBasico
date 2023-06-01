package br.com.trier.aula05.farmacia.models;

import lombok.Getter;

@Getter
public class Perfumaria extends Produto {

	public Perfumaria(String nome, Integer estoque, Double valor) {
		super(nome, estoque, valor);
	}

	@Override
	public boolean vender(int quantidade, Cliente cliente) {
		if ( cliente.getDividas() >= 300.0 ) {
			return false;
		}
		return super.vender(quantidade, cliente);
	}
	
	
}
