package br.com.trier.aula05.banco.models;

import lombok.Getter;

@Getter
public class ContaUniversitaria extends Conta {

	private final Double limiteSaldo = 2000.0;

	public ContaUniversitaria(Integer numero, Integer agencia, String nomeCorrentista, Double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
	}

	@Override
	public boolean deposito(Double deposito) {
		if ((deposito + getSaldo()) < limiteSaldo ) {
			return super.deposito(deposito);
		}
		return false;
	}
}
