package br.com.trier.aula05.farmacia.models;

import lombok.Getter;

@Getter
public class Medicamento extends Produto {

	private boolean ehReceita;

	public Medicamento(String nome, int estoque, double valor, boolean ehReceita) {
		super(nome, estoque, valor);
		this.ehReceita = ehReceita;
	}

	@Override
	public boolean vender(Venda v) {
		if(ehReceita && v.getMedico()==null) {
			return false;
		}else {
			if (getEstoque() >= v.getQuantidade()) {
				return super.vender(v);
			}
			return false;
		}
	}
}
