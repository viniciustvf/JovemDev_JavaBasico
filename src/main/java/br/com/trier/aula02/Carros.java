package br.com.trier.aula02;

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Cores getCor() {
		return cor;
	}

	public void setCor(Cores cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "MARCA: " + marca + ", ANO: " + ano + ", COR: " + cor 
				+ "\n";
	}
	
}
