package br.com.trier.aula05.banco.models;

import lombok.Getter;

@Getter
public class ContaEspecial extends Conta {

	private Double limiteSaque = 0.0;
	
	public ContaEspecial(Integer numero, Integer agencia, String nomeCorrentista, Double saldo, Double valor) {
		super(numero, agencia, nomeCorrentista, saldo);
		this.limiteSaque = cadastrarLimiteSaque(valor);
	}

	@Override
	public boolean saque(Double saque) {
		if( temSaldo() && saque < getSaldo() && saque < limiteSaque ) {
			return super.saque(saque);
		}	
		return false;
	}
	
	public Double cadastrarLimiteSaque(Double limiteSaque) {
		return this.limiteSaque = limiteSaque;
	}



	
	
}
