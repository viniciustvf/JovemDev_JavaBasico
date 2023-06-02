package FarmaciaTest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula05.farmacia.models.Cliente;
import br.com.trier.aula05.farmacia.models.EqMedico;
import br.com.trier.aula05.farmacia.models.Medicamento;
import br.com.trier.aula05.farmacia.models.Perfumaria;
import br.com.trier.aula05.farmacia.models.Venda;
import br.com.trier.aula05.farmacia.utils.Farmacia;


class FarmaciaTest {

	private Farmacia farmacia = new Farmacia();
	private Cliente c = null;
	private Medicamento m1 = null;
	private Medicamento m2 = null;
	private Perfumaria p1 = null; 
	private EqMedico e1 = null; 
	
	@BeforeEach
	public void init() {
		farmacia.getVendas().clear();
		c = new Cliente("Vinicius", 0.0);
		m1 = new Medicamento("Lozartana", 10, 10.0, true);
		m2 = new Medicamento("Metiolate", 10, 10.0, false);
		p1 = new Perfumaria("212", 10, 10.0);
		e1 = new EqMedico("Seringa", 0, 10.0);
	}

	@Test
	@DisplayName("Teste venda medicamento com receita sem informar medico")
	public void testeVendaMedicamentoReceita() {
		farmacia.vender(c, m1, 1, null);
		Assertions.assertEquals(10, m2.getEstoque());
		Assertions.assertEquals(0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste venda medicamento com receita informando o medico")
	public void testeVendaMedicamentoReceitaMedico() {
		farmacia.vender(c, m1, 1, "Dr. Marcos");
		Assertions.assertEquals(9, m1.getEstoque());
		Assertions.assertEquals(10.0, c.getDividas());
		Assertions.assertEquals("Dr. Marcos", farmacia.getVendas().get(0).getMedico());
	}
	
	@Test
	@DisplayName("Teste venda perfumaria com cliente devendo acima de 300")
	public void testeVendaPerfumariaClienteDevendo() {
		Cliente c2 = new Cliente("Vinicius", 350.0);
		farmacia.vender(c2, p1, 1, null);
		Assertions.assertEquals(10, p1.getEstoque());
		Assertions.assertEquals(350.0, c2.getDividas());
	}
	
	@Test
	@DisplayName("Teste venda perfumaria com cliente sem divida")
	public void testeVendaPerfumariaClienteSemDivida() {
		farmacia.vender(c, p1, 1, null);
		Assertions.assertEquals(9, p1.getEstoque());
		Assertions.assertEquals(10.0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste venda equipamento medico sem estoque")
	public void testeVendaEquipamentoMedicoSemEstoque() {
		farmacia.vender(c, e1, 1, null);
		Assertions.assertEquals(-1, e1.getEstoque());
		Assertions.assertEquals(10.0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste listar vendas por cliente")
	public void testeListarVendasPorCliente() {
		Cliente c2 = new Cliente("Joao", 100.0);
		farmacia.vender(c, e1, 1, null);
		farmacia.vender(c, m2, 1, null);
		farmacia.vender(c2, e1, 2, null);
		List<Venda> vendasPorCliente = farmacia.vendasPorCliente(c);
		
		Assertions.assertEquals(2, vendasPorCliente.size());
		Assertions.assertEquals(20.0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste pagar divida ok")
	public void testePagarDividaOk() {
		farmacia.vender(c, e1, 5, null);
		c.pagarConta(30.0);
		Assertions.assertEquals(20.0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste pagar divida sem divida")
	public void testePagarDividaSemDivida() {
		c.pagarConta(30.0);
		Assertions.assertEquals(0, c.getDividas());
	}
	
	@Test
	@DisplayName("Teste venda sem estoque")
	public void testeVendaSemEstoque() {
		farmacia.vender(c, m2, 11, null);
		Assertions.assertEquals(0, c.getDividas());
		Assertions.assertEquals(10, m2.getEstoque());
	}
}
