package br.com.trier.aula03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {

	Scanner sc = new Scanner(System.in);
	
	private String nome;
	private ArrayList<Jogador> listJogador = new ArrayList<Jogador>();

	
	
	void cadastraTime() {
		System.out.print("Informe o nome do time: ");
		nome = sc.nextLine();
		
		String op = "Sim";

		do {
			Jogador j = new Jogador();
			j.cadastraJogador();
			listJogador.add(j);
			op = sc.next();
		} while (!(op.equalsIgnoreCase("N")));
	}
	
	void listarJogadoresTime() {
		for (Jogador jogador : listJogador) {
			System.out.println(jogador);
		}
	}
	
	Integer quantidadeGols(){
		Integer totalGols = 0;
		for (Jogador jogador : listJogador) {
			totalGols += jogador.getQtdGolMarcado();
		}
		return totalGols;
	}
	
	
	
	

	
	@Override
	public String toString() {
		return "TIME: " + nome + "JOGADORES:\n "
				+ listJogador;
	}

}
