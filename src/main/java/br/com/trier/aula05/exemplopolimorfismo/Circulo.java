package br.com.trier.aula05.exemplopolimorfismo;

import lombok.Getter;

@Getter
public class Circulo extends Forma{

	private int raio;
	
	public Circulo(int raio) {
		super("Circulo");
		this.raio = raio;
	}
	
	public Double calculaArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	
}
