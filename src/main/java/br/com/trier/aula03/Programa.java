package br.com.trier.aula03;

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
				time.cadastraTime();
				listTime.add(time);
				break;
			case 2:
				time.listarJogadoresTime();
				break;
			case 3:
				Util.verificarArtilheiro(time.getListJogador());
				break;
			case 4:
				Time timeMaisGols = Util.timeComMaisGols(listTime);
				System.out.println(timeMaisGols);
				break;
			} 	
		} while (op != 5);

		sc.close();
	}

}
