package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

	Scanner sc = new Scanner(System.in);
	
	private String titulo;
	private Double preco;
	private ArrayList<Autor> listAutor = new ArrayList<Autor>();
	private ArrayList<Autor> autoresDisponiveis = new ArrayList<Autor>(); //A FAZER!
	
	
	void cadastraLivro() {
		
		listAutor.addAll(Autor.escolheAutor(autoresDisponiveis)); //A FAZER!
		
		System.out.print("Informe o nome do livro:\n");
		titulo = sc.nextLine().toLowerCase();
		
		try {
			System.out.print("Informe o preço:\n");
			preco = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.print("ERRO: Digite o preço corretamente.");
			System.exit(0);
		}
		
		if(!validaCadastro()) {
			cadastraLivro();
		}
	}

	boolean validaCadastro() {
		if (titulo.trim().equals("")) {
			System.out.println("TITULO INVÁLIDO, DIGITE NOVAMENTE");
			return false;
		}
		if (preco <= 0.0) {
			System.out.println("PRECO INVÁLIDO, DIGITE NOVAMENTE");
			return false;
		}
		return true;
	}
	
	static void autoresDisponiveis(ArrayList<Autor> autores) {
		AautoresDisponiveis = autores;							//A FAZER!
	}
	
	static String listarAutores(ArrayList<Autor> listAutor){
		for (Autor autor : listAutor) {
			return "-----------------------------\n"
					+ autor;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "LIVRO: " + titulo + ", PRECO: " + String.format("%.2f", preco)
				+ "\nAUTORES\n" + listarAutores(listAutor);
	}	
}
