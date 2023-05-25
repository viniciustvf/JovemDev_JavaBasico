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
				Livro.autoresDisponiveis(listAutor);
				break;
			case 2:
				Livro livro = new Livro();
				livro.cadastraLivro();
				listLivro.add(livro);
				System.out.println(livro);
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			} 	
		} while (op != 8);
	}
}
