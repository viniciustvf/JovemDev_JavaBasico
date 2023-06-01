package BancoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula05.banco.models.Conta;
import br.com.trier.aula05.banco.models.ContaEspecial;
import br.com.trier.aula05.banco.models.ContaUniversitaria;
import br.com.trier.aula05.banco.util.Caixa;

class CaixaTest {

	List<Conta> contaBD = new ArrayList<Conta>();
	
	@BeforeEach
	public void init() {
		contaBD.clear();
		Conta conta0 = new Conta(200, 3287, "Vinicius", 3500.0);
		Conta conta1 = new ContaUniversitaria(321, 9090, "Paulinha", 1500.0);
		Conta conta2 = new ContaEspecial(145, 5050, "João", 5000.0, 2500.0);
		contaBD.add(conta0);
		contaBD.add(conta1);
		contaBD.add(conta2);
	}
	
	@Test
	@DisplayName("Teste depósito ok")
	void testDepositoOk() {
		Caixa caixa = new Caixa();
		
		caixa.realizarDeposito(contaBD.get(0), 5000.0);
		caixa.realizarDeposito(contaBD.get(1),499.0);
		caixa.realizarDeposito(contaBD.get(2), 1.0); 
		assertEquals(8500.0, contaBD.get(0).getSaldo());
		assertEquals(1999.0, contaBD.get(1).getSaldo());
		assertEquals(5001.0, contaBD.get(2).getSaldo());
	}
	
	@Test
	@DisplayName("Teste saque ok")
	void testSaqueOk() {
		Caixa caixa = new Caixa();
		
		caixa.realizarSaque(contaBD.get(0), 500.0);
		caixa.realizarSaque(contaBD.get(1), 200.0);
		caixa.realizarSaque(contaBD.get(2), 1000.0); 
		assertEquals(3000.0, contaBD.get(0).getSaldo());
		assertEquals(1300.0, contaBD.get(1).getSaldo());
		assertEquals(1500.0, contaBD.get(2).getSaldo());
	}
	
	
	
	
	
	
	

}
