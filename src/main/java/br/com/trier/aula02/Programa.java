package br.com.trier.aula02;
/**
 * @author VINICIUS COSTA
 * 
 */
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
	
	static ArrayList<Carros> list = new ArrayList<Carros>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Util.menu();
		
		int op;
		
		do {
			
			op = sc.nextInt();
			switch(op) {

			case 1:
				System.out.print( "Marca: " );
				String marca = sc.next().toUpperCase();
				
				System.out.print( "Ano: " );
				String anoString = sc.next();
				int anoInteiro = Util.obterAnoInteiro(anoString);
				
				System.out.println( "Selecione uma cor: " );
				
				int i = 1;
				for ( Cores cor : Cores.values() ) {
					System.out.println(i + " " + cor);
					i++;
				}
				
				System.out.print("Digite o número correspondente à cor: ");
				
				int numeroCor = sc.nextInt();
				Cores corSelecionada = Util.selecionaCor(numeroCor);
				
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
				
				Util.menu();
				break;
			case 3: 
				System.out.println("Escreva a marca que procura");
				
				Set<String> marcasDisponiveis = new LinkedHashSet<String>();

				for ( Carros carro : list ) {
					marcasDisponiveis.add(carro.getMarca());
				}
				System.out.println("Marcas disponiveis: ");
				for ( String marcaDisponivel : marcasDisponiveis ) {
					System.out.println(marcaDisponivel);
				}
				
				String marcaSelecionada = sc.next();
				Util.listarCarroPorMarca(marcaSelecionada, list);
				
				Util.menu();
				break;
				
			case 4:
				int j = 1;
				for ( Cores cor : Cores.values() ) {
					System.out.println(j + " " + cor);
					j++;
				}
				
				System.out.print("Digite o número correspondente à cor: ");
				
				int numeroEscolhido = sc.nextInt();
				System.out.println("");
				Util.listarCarroPorCor(numeroEscolhido, list) ;
				Util.menu();
				break;

			}

		} while (op != 5);
	
		sc.close();
	}
	
}
	
	
	

