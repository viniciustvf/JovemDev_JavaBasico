package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	static String menu() {
		String menu = "——————————————————————————————————————————————————————\n" + "1 - Cadastra autor\n"
				+ "2 - Cadastra livros\n" + "3 - Listar livros\n" + "4 - Pesquisar por autor\n"
				+ "5 - Pesquisar por faixa de preço\n" + "6 - Listar livros de autores infantis (menores de 12)\n"
				+ "7 - Listar livro por sexo\n" + "8 - Sair\n"
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

		for (Livro livro : listLivro) {
			if (livro.contemAutor(autorNome)) {
				livroPorAutor.add(livro);
			}
		}

		for (Livro livro : livroPorAutor) {
			return ret += livro;
		}
		return null;
	}

	static String pesquisarPorPreco(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {

		ArrayList<Livro> livroPorPreco = new ArrayList<Livro>();
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o preço inicial: ");
		Double precoI = sc.nextDouble();

		System.out.print("Digite o preço final: ");
		Double precoF = sc.nextDouble();

		for (Livro livro : listLivro) {
			if (livro.getPreco() > precoI && livro.getPreco() < precoF) {
				livroPorPreco.add(livro);
			}
		}
		return livroPorPreco.toString();
	}

	static String pesquisarPorIdade(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {

		ArrayList<Livro> livroPorIdade = new ArrayList<Livro>();
		Scanner sc = new Scanner(System.in);

		for (Livro livro : listLivro) {
			if (livro.contemAutorMenorIdade()) {
				livroPorIdade.add(livro);
			}
		}
		return livroPorIdade.toString();
	}

	
	static String pesquisarPorSexo(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {

		ArrayList<Livro> livroPorSexo = new ArrayList<Livro>();
		EnumSexo sexo = EnumSexo.escolherSexo();
		
		
		for (Livro livro : listLivro) {
			if (livro.contemAutorPorSexo(sexo)) {
				livroPorSexo.add(livro);
			}
		}
		return livroPorSexo.toString();
	}
}
