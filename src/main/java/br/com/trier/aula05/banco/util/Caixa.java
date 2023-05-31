package br.com.trier.aula05.banco.util;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula05.banco.models.Conta;
import br.com.trier.aula05.banco.models.ContaEspecial;


public class Caixa {

	List<Conta> contasBD = new ArrayList<Conta>();

	void cadastrarConta(Conta conta) {
		contasBD.add(conta);
	}
	
	boolean existeConta(Conta conta) {
		if (contasBD.contains(conta)) {
			return true;
		}
		return false;
	}
	
	public boolean realizarDeposito(Conta conta, Double valor) {
		if (existeConta(conta)) {
			conta.Deposito(valor);
			return true;
		}
		return false;
	}
	
	public boolean realizarSaque(Conta conta, Double valor) {
		if (existeConta(conta)) {
			conta.Saque(valor);
			return true;
		}
		return false;
	}
	
	public boolean realizarTransferencia(Conta conta, Double valor) {
		if (existeConta(conta)) {
			conta.Transferencia(valor);
			return true;
		}
		return false;
	}
	
	public boolean cadastrarLimite(ContaEspecial conta, Double valor) {
		if (existeConta(conta)) {
			conta.cadastrarLimiteSaque(valor);
			return true;
		}
		return false;
	}
	
}
