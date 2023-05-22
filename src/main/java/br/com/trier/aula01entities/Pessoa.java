package br.com.trier.aula01entities;

public class Pessoa {

	private String nome;
	private String sexo;
	private Double peso;
	private Double altura;
	
	public Pessoa(String nome, String sexo, Double peso, Double altura) {
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String avaliacaoImc(Double peso, Double altura) {
		
		Double resultado = peso / Math.pow(altura, 2);
		
		if(resultado < 16.00) {
			return String.format("%.2f", resultado) + ", Baixo peso Grau III.";
		} else if (resultado >= 16.00 && resultado <= 16.99) {
			return String.format("%.2f", resultado) + ", Baixo peso Grau II.";
		} else if (resultado >= 17.00 && resultado <= 18.49) {
			return String.format("%.2f", resultado) + ", Baixo peso Grau I.";
		} else if (resultado >= 18.50 && resultado <= 24.99) {
			return String.format("%.2f", resultado) + ", Peso ideal!.";
		} else if (resultado >= 25.00 && resultado <= 29.99) {
			return String.format("%.2f", resultado) + ", Sobrepeso.";
		}  else if (resultado >= 30.00 && resultado <= 34.99) {
			return String.format("%.2f", resultado) + ", Obesidade Grau I.";
		} else if (resultado >= 35.00 && resultado <= 39.99) {
			return String.format("%.2f", resultado) + ", Obesidade Grau II.";
		} else {
			return String.format("%.2f", resultado) + ", Obesidade Grau III.";
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " 
				+ nome 
				+ " Sexo: " 
				+ sexo 
				+ " Peso: " 
				+ peso 
				+ " Altura: " 
				+ altura 
				+ " IMC: "
				+ avaliacaoImc(peso,altura);		
	}	
}
