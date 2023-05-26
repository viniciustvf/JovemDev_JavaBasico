package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

	
	private String titulo;
	private Double preco;
	private ArrayList<Autor> listAutor = new ArrayList<Autor>();
	
	
	
	public Livro(ArrayList<Autor> autoresDisponiveis) {
		this.listAutor = Autor.escolheAutor( autoresDisponiveis );
	}
	
	
	
	void cadastraLivro() {
		
		boolean livroCadastrado = false;
		
		while(!livroCadastrado) {
			Scanner sc = new Scanner(System.in);
			System.out.print( "Informe o titulo do livro:\n" );
			titulo = sc.nextLine().toLowerCase();
			
			try {
				System.out.print("Informe o preço:\n");
				preco = sc.nextDouble();
			} catch ( InputMismatchException e ) {
				System.out.print("ERRO: Digite o preço corretamente.");
				System.exit(0);
			}
			
			if ( validaTitulo() && validaPreco() ) {
				livroCadastrado = true;
			}
			
			System.out.println(Livro.this);
		}
	
	}

	
	
	boolean validaTitulo() {
		if ( titulo.trim().equals("") ) {
			System.out.println( "TITULO INVÁLIDO, DIGITE NOVAMENTE" );
			return false;
		}
		return true;
	}
	
	boolean validaPreco() {	
		if ( preco <= 0.0 ) {
			System.out.println( "PRECO INVÁLIDO, DIGITE NOVAMENTE" );
			return false;
		}
		return true;
	}
	
	
	
	static String listarAutores( ArrayList<Autor> listAutor ) {
		String ret = "";
		for ( Autor autor : listAutor ) {
			ret += "\n" + autor;
		}
		return ret;
	}
	
	
	
	static String listarLivros( ArrayList< Livro > listLivro ) {
		String retLivros = "";

		for (Livro livro : listLivro) {
			retLivros += livro;
		}
		return retLivros;
	}
	
	
	boolean contemAutor(String autorNome) {
		for (Autor autor : this.listAutor) {
			if(autor.getNome().equalsIgnoreCase(autorNome)) {
				return true;
			}
		}
		return false;
	}
	
	boolean contemAutorMenorIdade(ArrayList<Autor> autorList) {
		for (Autor autor : autorList) {
			if(autor.getIdade() <= 12){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "-----------------------------\n"
				+ "TÍTULO: " 
				+ titulo 
				+ ", PRECO: R$" 
				+ String.format("%.2f", preco)
				+ "\nAUTORES\n" 
				+ listarAutores(listAutor);
	}	
}
