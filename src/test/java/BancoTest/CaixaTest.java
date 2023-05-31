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

class CaixaTest {

	List<Conta> contaBD = new ArrayList<Conta>();
	
	@BeforeEach
	public void init() {
		contaBD.clear();
		Conta conta0 = new Conta(200, 3287, "Vinicius", 3500.0);
		Conta conta1 = new ContaUniversitaria(321, 9090, "Paulinha", 1500.0);
		Conta conta2 = new ContaEspecial(145, 5050, "João", 5.000, 2500.0);
		contaBD.add(conta0);
		contaBD.add(conta1);
		contaBD.add(conta2);
	}
	
	@Test
	@DisplayName("Teste depósito ok")
	void testDepositoOk() {
		contaBD.get(0).deposito(5000.0);
		contaBD.get(1).deposito(499.0);
		contaBD.get(2).deposito(1.0);
		assertEquals(8500.0, contaBD.get(0).getSaldo());
		assertEquals(1999.0, contaBD.get(1).getSaldo());
		assertEquals(2501.0, contaBD.get(2).getSaldo());
	}
	
	//@Test
	//@DisplayName("Teste depósito erro ")
	//void testDepositoO() {
		//contaBD.get(0).deposito(5.000);
		//assertEquals(8.500, contaBD.get(0).getSaldo());
	//}
	
	
	
	
	
	
	

}
