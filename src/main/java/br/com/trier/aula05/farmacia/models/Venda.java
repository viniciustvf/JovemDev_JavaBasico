package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Venda {
	
	@NonNull
	private Cliente cliente;
	@NonNull
	private Produto produto;
	@NonNull
	private Integer quantidade;
	
	private String medico;
	
	@Override
	public String toString() {
		return cliente.getNome() + "-" + produto.getNome()+"-"+(produto.getValor() + quantidade);
	}
	
	public boolean ehCliente(Cliente c) {
		return c.getNome().equalsIgnoreCase(cliente.getNome());
	}
}
