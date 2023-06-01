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
		saldo = getSaldo() + deposito;
		return true;
	}
	
	public boolean saque(final Double saque) {
		if( temSaldo() && saque < this.saldo ) {
			saldo = getSaldo() - saque;
			return true; 
		}	
		return false;
	}
	
	public boolean transferencia(final Double valor, Conta contaDestino) {
		if( saque(valor) && temSaldo() ) {
			if (contaDestino.deposito(valor)) {
				return true;
			} else {
				deposito(valor);
			}
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
