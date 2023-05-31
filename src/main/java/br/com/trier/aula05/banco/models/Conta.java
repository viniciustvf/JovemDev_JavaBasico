package br.com.trier.aula05.banco.models;

import lombok.Getter;

@Getter
public abstract class Conta {

	Integer numero;
	Integer agencia;
	String nomeCorrentista;
	Double saldo;
	
	public void Deposito(final Double valor) {
	}
	
	public void Saque(final Double valor) {
	}
	
	public void Transferencia(final Double valor) {
	}
	
	public boolean temSaldo() {
		if(this.saldo != 0.0) {
			return true;
		}
		return false;
	}
	
}
