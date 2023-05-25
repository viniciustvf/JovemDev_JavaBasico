package br.com.trier.aula03;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {
	
	Scanner sc = new Scanner(System.in);
	
	private String nome;
	private Integer numeroCamisa;
	private Integer qtdGolMarcado;

	void cadastraJogador() {

		System.out.print("Informe o nome do jogador:\n");
		nome = sc.nextLine().toUpperCase();
		
		System.out.print("Informe o numero da camisa:\n");
		numeroCamisa = sc.nextInt();
		
		System.out.print("Informe a quantidade de gols marcados:\n");
		qtdGolMarcado = sc.nextInt();
		System.out.print("Cadastrar mais um jogador? (S/N):");
	}
	
	@Override
	public String toString() {
		return "JOGADOR: " + nome + " NUMERO CAMISA: " + numeroCamisa + " QUANTIDADE DE GOLS: " + qtdGolMarcado;
	}

}
