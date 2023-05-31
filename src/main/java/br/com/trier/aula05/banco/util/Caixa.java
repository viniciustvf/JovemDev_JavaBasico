package br.com.trier.aula05.banco.util;

import br.com.trier.aula05.banco.models.Conta;

public class Caixa {
	
	public boolean realizarDeposito(Conta conta, Double valor) {
		conta.deposito(valor);
		return true;
	}
	
	public boolean realizarSaque(Conta conta, Double valor) {
		conta.saque(valor);
		return true;
	}
	
	public boolean realizarTransferencia(Double valor, Conta origem, Conta destino) {
		origem.transferencia(valor, destino);
		return true;
	}
	
}
