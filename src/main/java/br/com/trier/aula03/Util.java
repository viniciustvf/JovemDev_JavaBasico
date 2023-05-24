package br.com.trier.aula03;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	static Scanner sc = new Scanner(System.in);
	
	static void menu() {
		System.out.println("------------------------------------");
		System.out.println("1 - Cadastra time e jogadores.");
		System.out.println("2 - Listar jogadores de um time.");
		System.out.println("3 - Verificar artilheiro campeonato.");
		System.out.println("4 - Verificar time com mais gols.");
		System.out.println("5 - Sair");
		System.out.println("------------------------------------");
	}
	
	
	
	static Jogador verificarArtilheiro(ArrayList<Jogador> list) {
		Integer qtdGol = 0;
		Jogador artilheiro = new Jogador();
		for (Jogador jogador : list) {
			if (jogador.getQtdGolMarcado() > qtdGol) {
				artilheiro = jogador;
			}
		}
		return artilheiro;
	}
	
	static Time timeComMaisGols(ArrayList<Time> listTime) {
		Time timeMaisGols = new Time();
		for (Time time: listTime) {
			if (time.quantidadeGols() > timeMaisGols.quantidadeGols()) {
				timeMaisGols = time;
			}
		}
		return timeMaisGols;
	}
}
