package br.com.trier.aula05.farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Venda {

	Produto produto;
	Cliente cliente;
	Integer quantidade;
	String nomeDoMedico = "Sem receita médica";
	
	
	
	
}
