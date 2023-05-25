package br.com.trier.aula03.biblioteca;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

	Scanner sc = new Scanner(System.in);
	
	private String nome;
	private char sexo;
	private Integer idade;
	
	void cadastraAutor() {
		boolean cadastroValido = true;
		while (cadastroValido)
			System.out.print("Informe o nome do autor:\n");
			nome = sc.nextLine().toUpperCase();
			if (nome.trim().equals("")) {
				System.out.println("NOME INVÁLIDO, DIGITE NOVAMENTE");
				cadastroValido = false;
			}
			
			System.out.print("Informe o sexo do autor: (M/F) \n");
			sexo = sc.next().toUpperCase().charAt(0);
			if (sexo != 'M' || sexo != 'F') {
				System.out.println("SEXO INVÁLIDO, DIGITE NOVAMENTE");
				cadastroValido = false;
			}
			
			
			System.out.print("Informe a idade do autor:\n");
			idade = sc.nextInt();

	}
	
}
