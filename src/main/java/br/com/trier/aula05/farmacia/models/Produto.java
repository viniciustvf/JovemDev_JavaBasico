package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Produto {

	private String nome;
	private int estoque;
	private double valor;
	
	public boolean vender(Venda v) {
		estoque = getEstoque() - v.getQuantidade();
		v.getCliente().adicionaValor(v.getQuantidade()*getValor());
		return true;
	}
}
