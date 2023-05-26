package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		ArrayList<Livro> listLivro = new ArrayList<Livro>();
		ArrayList<Autor> listAutor = new ArrayList<Autor>();
		
		Scanner sc = new Scanner(System.in);
		
		int op = 0;
		
		do {
			
			System.out.print(Util.menu());
			
			op = sc.nextInt();

			switch(op) {
			case 1:
				Autor autor = new Autor();
				autor.cadastraAutor();
				listAutor.add(autor);
				break;
			case 2:
				Livro livro = new Livro(listAutor);
				livro.cadastraLivro();
				listLivro.add(livro);
				break;
			case 3:
				System.out.println(Livro.listarLivros(listLivro));
				break;
			case 4:
				System.out.println(Util.pesquisarPorAutor(listAutor, listLivro));
				break;
			case 5:
				System.out.println(Util.pesquisarPorPreco(listAutor, listLivro));
				break;
			case 6:
				System.out.println(Util.pesquisarPorIdade(listAutor, listLivro));
				break;
			case 7:
				System.out.println(Util.pesquisarPorSexo(listAutor, listLivro));
				break;
			} 	
		} while (op != 8);
	}
}
