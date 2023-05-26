package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	static String menu() {
		String menu =     "——————————————————————————————————————————————————————\n"
						+ "1 - Cadastra autor\n"
						+ "2 - Cadastra livros\n"
						+ "3 - Listar livros\n"
						+ "4 - Pesquisar por autor\n"
						+ "5 - Pesquisar por faixa de preço\n"
						+ "6 - Listar livros de autores infantis (menores de 12)\n"
						+ "7 - Listar livro por sexo\n"
						+ "8 - Sair\n"
						+ "——————————————————————————————————————————————————————\n";
		return menu;
	}
	
	
	static String pesquisarPorAutor(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {
		
		String ret = "";
		System.out.println(Livro.listarAutores(listAutor));
		ArrayList<Livro> livroPorAutor = new ArrayList<Livro>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do autor: ");
		String autorNome = sc.next();
		
		for ( Livro livro : listLivro ) {
			if (livro.contemAutor(autorNome)) {
				livroPorAutor.add(livro);
			}
		}
		
		for ( Livro livro : livroPorAutor ) {
			return ret += livro;
		}
		return null;
	}
	
	
	
	
}


