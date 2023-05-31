package br.com.trier.aula05.banco.models;

public class ContaEspecial extends Conta {

	private Double limiteSaque = 0.0;
	
	@Override
	public void Deposito(final Double deposito) {
		this.saldo += deposito;
	}
	
	@Override
	public void Saque(final Double saque) {
		if( temSaldo() && saque < this.saldo && saque < limiteSaque) {
			this.saldo -= saque;
		}	
	}
	
	@Override
	public void Transferencia(final Double transferencia) {
		if( temSaldo() && transferencia < this.saldo && transferencia < limiteSaque) {
			this.saldo -= transferencia;
		}
	}
	
	@Override
	public boolean temSaldo() {
		if(this.saldo != 0.0) {
			return true;
		}
		return false;
	}
	
	public void cadastrarLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
}
