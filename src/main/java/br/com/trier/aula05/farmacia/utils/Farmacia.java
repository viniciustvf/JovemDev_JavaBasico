package br.com.trier.aula05.farmacia.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula05.farmacia.models.Cliente;
import br.com.trier.aula05.farmacia.models.Medicamento;
import br.com.trier.aula05.farmacia.models.Produto;
import br.com.trier.aula05.farmacia.models.Venda;
import lombok.Getter;
@Getter
public class Farmacia {

	protected List<Produto> produtoBD = new ArrayList<Produto>();
	protected List<Cliente> clienteBD = new ArrayList<Cliente>();
	protected List<Venda> vendaBD = new ArrayList<Venda>();
	
	
	public Cliente cadastrarCliente(Cliente cliente) {
		clienteBD.add(cliente);
		return cliente;
	}
	
	public Produto cadastrarProduto(Produto produto) {
		produtoBD.add(produto);
		return produto;
	}
	
	public Venda realizarVenda(Integer quantidade, Cliente cliente, Produto produto) {
		produto.vender(quantidade, cliente);
		Venda venda = new Venda(produto, cliente, quantidade, null);
		vendaBD.add(venda);
		return venda;
	}
	
	public Venda realizarVenda(int quantidade, Cliente cliente, Medicamento medicamento, String nomeMedico) {
		Venda venda = null;
		if ( medicamento.isReceitaMedica() ) { 
			medicamento.vender(quantidade, cliente);
			venda = new Venda(medicamento, cliente, quantidade, nomeMedico);
			vendaBD.add(venda);
		} else {
			return realizarVenda(quantidade, cliente, medicamento);
		}
		return null;
	}
	
	public boolean cobraConta(Double valor, Cliente cliente) {
		cliente.pagarConta(valor);
		return true;
	}
	
	public List<Produto> listarProdutoPreco (Double valorI, Double valorF, List<Produto> produto) {
		List<Produto> produtoRet = new ArrayList<Produto>();
		for (Produto p : produto) {
			if ( p.getValor() >= valorI && p.getValor() <= valorF ) {
				produtoRet.add(p);
			}
		}
		return produtoRet;
	}
	
	public List<Cliente> listarClientes() {
		return clienteBD;
	}
}
