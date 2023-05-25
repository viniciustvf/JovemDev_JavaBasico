package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {
	
	private String nome;
	private char sexo;
	private Integer idade;
	
	void cadastraAutor() {
			Scanner sc = new Scanner(System.in);	
			System.out.print("Informe o nome do autor:\n");
			nome = sc.next().toUpperCase();
			sc.nextLine();
			
			System.out.print("Informe o sexo do autor: (M/F)\n");
			sexo = sc.next().toUpperCase().charAt(0);
			
			try {
				System.out.print("Informe a idade do autor:\n");
				idade = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERRO: Digite a idade corretamente.");
				System.exit(0);
			}
			
			if(!validaCadastro()) {
				cadastraAutor();
			}
	}
	
	boolean validaCadastro() {
		if (nome.trim().equals("")) {
			System.out.println("NOME INVÁLIDO, DIGITE NOVAMENTE");
			return false;
		}
		if (sexo != 'M' && sexo != 'F') {
			System.out.println("SEXO INVÁLIDO, DIGITE NOVAMENTE");
			return false;
		}
		if (idade < 0) {
			System.out.println("IDADE INVÁLIDA, DIGITE NOVAMENTE");
			return false;
		}
		return true;
	}
	
	static Autor listarAutores(ArrayList<Autor> autores) {
		for (Autor autor : autores) {
			return autor;
		}
		return null;		
	}
	
	static ArrayList<Autor> escolheAutor(ArrayList<Autor> autores) {
		
		Scanner sc = new Scanner(System.in);
		Character escolha = null;
		ArrayList<Autor> ret = new ArrayList<Autor>();
		
		int op = 0;
		
		do {
			System.out.println("Escolha um autor:");
			int i = 0;
			for (Autor aut : autores) {
				System.out.println((i + 1) + " - " + aut.nome);
				i++;
			}
			op = sc.nextInt();
			ret.add(autores.get(op - 1));
			
			System.out.println("Deseja adicionar mais um autor? (S/N)");
			escolha = sc.next().toUpperCase().charAt(0);
			
		} while (escolha != 'N');
		return ret;
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "AUTOR: " + nome + ", SEXO: " + sexo + ", IDADE: " + idade;
	}
	
	
}
