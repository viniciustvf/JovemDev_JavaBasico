package FarmaciaTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula05.farmacia.models.Cliente;
import br.com.trier.aula05.farmacia.models.EqMedico;
import br.com.trier.aula05.farmacia.models.Medicamento;
import br.com.trier.aula05.farmacia.models.Perfumaria;
import br.com.trier.aula05.farmacia.models.Produto;
import br.com.trier.aula05.farmacia.models.Venda;
import br.com.trier.aula05.farmacia.utils.Farmacia;

class FarmaciaTest {

	private List<Produto> produtoBD = new ArrayList<Produto>();
	private List<Cliente> clienteBD = new ArrayList<Cliente>();
	private List<Venda> vendaBD = new ArrayList<Venda>();
	
	@BeforeEach
	public void init() {
		produtoBD.clear();
		clienteBD.clear();
		Cliente cliente0 = new Cliente("Vinicius", 250.0);
		Cliente cliente1 = new Cliente("Joao", 850.0);
		clienteBD.add(cliente0);
		clienteBD.add(cliente1);
		Produto produto0 = new Medicamento("Lozartana", 20, 150.0, true);
		Produto produto1 = new Medicamento("Metiolate", 15, 19.90, false);
		Produto produto2 = new EqMedico("Seringa", 0, 25.0);
		Produto produto3 = new EqMedico("Band-aid", 15, 8.0);
		Produto produto4 = new Perfumaria("212 black", 5, 290.0);
		produtoBD.add(produto0);
		produtoBD.add(produto1);
		produtoBD.add(produto2);
		produtoBD.add(produto3);
		produtoBD.add(produto4);
	}
	
	@Test
	@DisplayName("Teste cadastro cliente ok")
	void testCadastroClienteOk() {
		Farmacia farmacia = new Farmacia();
		farmacia.cadastrarCliente(clienteBD.get(0));
		farmacia.cadastrarCliente(clienteBD.get(1));
		Assertions.assertEquals(clienteBD.get(0), farmacia.getClienteBD().get(0));
		Assertions.assertEquals(clienteBD.get(1), farmacia.getClienteBD().get(1));
	}
	
	@Test
	@DisplayName("Teste cadastro cliente nulo")
	void testCadastroClienteNulo() {
		Farmacia farmacia = new Farmacia();
		farmacia.cadastrarCliente(null);
		Assertions.assertEquals(null, farmacia.getClienteBD().get(0));
	}
	
	@Test
	@DisplayName("Teste cadastro produto")
	void testCadastroProdutoOk() {
		Farmacia farmacia = new Farmacia();
		farmacia.cadastrarProduto(produtoBD.get(0));
		farmacia.cadastrarProduto(produtoBD.get(1));
		Assertions.assertEquals(produtoBD.get(0), farmacia.getProdutoBD().get(0));
		Assertions.assertEquals(produtoBD.get(1), farmacia.getProdutoBD().get(1));
	}
	
	@Test
	@DisplayName("Teste cadastro produto nulo")
	void testCadastroProdutoNulo() {
		Farmacia farmacia = new Farmacia();
		farmacia.cadastrarProduto(null);
		Assertions.assertEquals(null, farmacia.getProdutoBD().get(0));
	}
	
	@Test
	@DisplayName("Teste venda ok")
	void testVendaOk() {
		Farmacia farmacia = new Farmacia();
		
		Venda venda1 = farmacia.realizarVenda(5, clienteBD.get(0), (Medicamento) produtoBD.get(0), "Dr. Marcos");
		Venda venda2 = farmacia.realizarVenda(5, clienteBD.get(1),produtoBD.get(3));
		Venda venda3 = farmacia.realizarVenda(1, clienteBD.get(1),produtoBD.get(4));
		Venda venda4 = farmacia.realizarVenda(1, clienteBD.get(0),produtoBD.get(3));
		Venda venda5 = farmacia.realizarVenda(1, clienteBD.get(1),produtoBD.get(1));
		vendaBD.add(venda1);
		vendaBD.add(venda2);
		vendaBD.add(venda3); 
		vendaBD.add(venda4); 
		vendaBD.add(venda5); 
		
		Double divida = clienteBD.get(1).getDividas();
		int estoque = produtoBD.get(0).getEstoque();
		
		Assertions.assertEquals(null, vendaBD.get(4).getNomeDoMedico());
		Assertions.assertEquals(venda4, vendaBD.get(3));
		Assertions.assertEquals(venda3, vendaBD.get(2));
		Assertions.assertEquals(15, estoque);
		Assertions.assertEquals(vendaBD.get(0), venda1);
		Assertions.assertEquals(909.9, divida); 
	}
	
	@Test
	@DisplayName("Teste venda perfumaria se tiver devendo mais que R$300.00")
	void testVendaComDivida() {
		Farmacia farmacia = new Farmacia();
		
		Venda venda1 = farmacia.realizarVenda(1, clienteBD.get(1), produtoBD.get(4));
		vendaBD.add(venda1);

		Assertions.assertEquals(850.0, vendaBD.get(0).getCliente().getDividas()); 
	}
	
	@Test
	@DisplayName("Teste listar produto por preço")
	void testListarProdutoPorPreco() {
		Farmacia farmacia = new Farmacia();
		
		List<Produto> produtosListados = farmacia.listarProdutoPreco(140.0, 300.0, produtoBD);
		List<Produto> p = new ArrayList<Produto>();
		p.add(produtoBD.get(0));
		p.add(produtoBD.get(4));
		
		Assertions.assertEquals(p, produtosListados); 
	} 
	
	@Test
	@DisplayName("Teste cliente paga divida")
	void testPagaDivida() {
		Farmacia farmacia = new Farmacia();
		
		farmacia.cobraConta(200.0, clienteBD.get(1));
		Assertions.assertEquals(650.0, clienteBD.get(1).getDividas());
	} 
}
