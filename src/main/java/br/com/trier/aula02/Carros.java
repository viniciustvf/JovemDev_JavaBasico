package br.com.trier.aula02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carros {
	
	private String marca;
	private Integer ano;
	private Cores cor;
	
	public Carros(String marca, Integer ano, Cores cor) {
		super();
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "MARCA: " + marca + ", ANO: " + ano + ", COR: " + cor 
				+ "\n";
	}
	
}
