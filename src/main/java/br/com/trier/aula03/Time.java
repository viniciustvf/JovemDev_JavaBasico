package br.com.trier.aula03;


import java.util.ArrayList;
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
		System.out.println("Informe o nome do time: ");
		nome = sc.next().toUpperCase();
		
		String op = "S";

		do {
			Jogador j = new Jogador();
			j.cadastraJogador();
			listJogador.add( j );
			op = sc.next();
		} while (!( op.equalsIgnoreCase("N") ));
	}
	
	void listarJogadores() {
		for ( Jogador jogador : listJogador ) {
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
	
	static void listarTimes( ArrayList<Time> listTime ) {
		System.out.println("TIMES DISPONIVEIS: ");
		for ( Time time : listTime ) {
			System.out.println(time.getNome()); 
		}	
	}
	
	Time escolherTime(ArrayList<Time> time) {
		System.out.println("DIGITE O NOME DO TIME: ");
		String nomeTime = sc.next();;
		
		for (Time times : time) {
			if ( nomeTime.trim().equals("") ) {
				System.out.println("DIGITE UM NOME!");
			} else 	if (nomeTime.equalsIgnoreCase( times.getNome() )) {
				return times;											
			}
		}
		return null;
	}
	
	void listaJogadoresDoTime(ArrayList<Time> time) {
		Time timeEscolhido = escolherTime(time);
		timeEscolhido.listarJogadores();
	}
	

	@Override
	public String toString() {
		return "TIME: " + nome + "\nJOGADORES:\n "
				+ listJogador;
	}

}
