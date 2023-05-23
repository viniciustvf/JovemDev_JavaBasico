package br.com.trier.aula02;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	
	static ArrayList<Carros> list = new ArrayList<Carros>();
	
	public static void main(String[] args) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy");
		Scanner sc = new Scanner(System.in);
		
		Util.menu();
		
		int op;
		
		do {
			
			op = sc.nextInt();
			switch(op) {

			case 1:
				System.out.print( "Marca: " );
				String marca = sc.next();
				
				System.out.print( "Ano: " );
				String anoString = sc.next();
				Year ano = Year.parse( anoString );
				int anoInteiro = ano.getValue();
				
				System.out.println( "Selecione uma cor: " );
				int i = 1;
				
				for ( Cores cor : Cores.values() ) {
					System.out.println(i + " " + cor);
					i++;
				}
				
				System.out.print("Digite o número correspondente à cor: ");
		        int numeroCor = sc.nextInt();
		        Cores corSelecionada = null;
		        
		        //Passando os enums para um vetor, para serem selecionados.			
		        Cores[] cores = Cores.values();
		        
		        if ( numeroCor >= 1 && numeroCor <= cores.length ) {
		            corSelecionada = cores[numeroCor - 1];
		            System.out.println( "Cor selecionada: " + corSelecionada );
		        } else {
		            System.out.println( "Número inválido" );
		        }
				
				list.add(new Carros( marca,anoInteiro,corSelecionada ) );
				
				Util.menu();
				break;
			
			case 2:
				System.out.print("Digite o ano inicial de fabricação (yyyy): ");
				String anoInicialString = sc.next();
				int anoInicialInteiro = Util.obterAnoInteiro(anoInicialString);
				
				System.out.print("Digite o ano final de fabricação (yyyy): ");
				String anoFinalString = sc.next();
				int anoFinalInteiro = Util.obterAnoInteiro(anoFinalString);
				
				System.out.println("");
				Util.listaCarroPeriodoFabricacao(anoInicialInteiro, anoFinalInteiro, list);
				
			case 3: 
				Util.listarCarroPorMarca(list);
				
			case 4:
				//Util.listarCarroPorCor(list); TO-DO: CASE4 E DIMINUIR CASE1.
			}

		} while (op != 5);
	
		sc.close();
	}
	
}
	
	
	

