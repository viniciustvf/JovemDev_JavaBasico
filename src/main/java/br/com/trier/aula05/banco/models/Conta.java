package br.com.trier.aula05.banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Conta {

	private Integer numero;
	private Integer agencia;
	private String nomeCorrentista;
	protected Double saldo;
	
	public boolean deposito(final Double deposito) {
		this.saldo += deposito;
		return true;
	}
	
	public boolean saque(final Double saque) {
		if( temSaldo() && saque < this.saldo ) {
			this.saldo -= saque;
			return true;
		}	
		return false;
	}
	
	public boolean transferencia(final Double valor, Conta contaDestino) {
		if( temSaldo() && valor < this.saldo ) {
			saque(valor);
			contaDestino.deposito(valor);
			return true;
		}
		return false;
	}
	
	public boolean temSaldo() {
		if(this.saldo != 0.0) {
			return true;
		}
		return false;
	}	
}
