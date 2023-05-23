package br.com.trier.aula02;

import java.time.Year;
import java.util.ArrayList;

public class Util {

	public static void menu() {
		System.out.println("");
		System.out.println("1 - Cadastrar Carro");
		System.out.println("2 - Listar os carros por período de fabricação");
		System.out.println("3 - Listar carros por marca");
		System.out.println("4 - Listar carros por cor");
		System.out.println("5 - Sair");
	}
	
	public static int obterAnoInteiro(String anoString) {
		Year anoFormatado = Year.parse(anoString);
		return anoFormatado.getValue();
	}
	
	public static void listaCarroPeriodoFabricacao(int anoInicial, int anoFinal, ArrayList<Carros> list) {
		for (Carros carro : list) {
			if(carro.getAno() > anoInicial && carro.getAno() < anoFinal) {
				System.out.println(carro);
			}
		}
	}
	
	public static void listarCarroPorMarca(ArrayList<Carros> list) {
		for (Carros carro : list) {
			System.out.print(carro.getMarca().toUpperCase() + ", ");
		}
	}
	
	
}
