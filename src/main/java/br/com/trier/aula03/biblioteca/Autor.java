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
	private EnumSexo sexo;
	private Integer idade;

	
	void cadastraAutor() {
			Scanner sc = new Scanner(System.in);	
			System.out.print("Informe o nome do autor:\n");
			nome = sc.next().toUpperCase();
			sc.nextLine();
			
			System.out.print("Informe o sexo do autor:\n");
			sexo = EnumSexo.escolherSexo();
			
			try {
				System.out.print("Informe a idade do autor:\n");
				idade = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERRO: Digite a idade corretamente.");
				System.exit(0);
			}
			
			if(!validarNome()) {
				cadastraAutor();
			}
			if(!validarIdade()) {
				cadastraAutor();
			}

	}
	
	boolean validarNome() {
		if (nome.trim().equals("")) {
			System.out.println("NOME INVÁLIDO, DIGITE NOVAMENTE");
			return false;
		}
		return true;
	}		
		
	
	boolean validarIdade() {
		if (idade < 0) {
			System.out.println("IDADE INVÁLIDA, DIGITE NOVAMENTE");
			return false;
		}
		return true;
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
		return "AUTOR: " + nome + ", SEXO: " + sexo + ", IDADE: " + idade + "\n";
	}
	
}
