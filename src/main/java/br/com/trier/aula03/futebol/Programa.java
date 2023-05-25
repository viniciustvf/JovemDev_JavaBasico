package br.com.trier.aula03.futebol;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Time time = new Time();
		ArrayList<Time> listTime = new ArrayList<Time>();
		
		int op = 0;
		
		do {
			Util.menu();
			op = sc.nextInt();
			switch(op) {
			case 1:
				time = new Time();
				time.cadastraTime();
				listTime.add(time);
				break;
			case 2:
				Time.listarTimes(listTime);
				time.listaJogadoresDoTime(listTime);
				break;
			case 3:
				Jogador artilheiro = Util.verificarArtilheiro(time.getListJogador());
				System.out.println(artilheiro);
				break;
			case 4:
				Time timeMaisGols = Util.timeComMaisGols(listTime);
				System.out.println(timeMaisGols.getNome()); 
				timeMaisGols.listarJogadores();
				System.out.println("TOTAL DE GOLS: " + timeMaisGols.quantidadeGols());
				break;
			} 	
		} while (op != 5);

		sc.close();
	}

}
