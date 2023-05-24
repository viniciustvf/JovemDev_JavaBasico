package br.com.trier.aula02;

import java.time.Year;
import java.util.ArrayList;

public class Util {

	public static void menu() {
		System.out.println("**********************************************");
		System.out.println("1 - Cadastrar Carro");
		System.out.println("2 - Listar os carros por período de fabricação");
		System.out.println("3 - Listar carros por marca");
		System.out.println("4 - Listar carros por cor");
		System.out.println("5 - Sair");
		System.out.println("**********************************************");
	}
	
	public static Cores selecionaCor(int numeroCor) {
		Cores corSelecionada = null;
        
        //Passando os enums para um vetor, para serem selecionados.			
        Cores[] cores = Cores.values();
        
        if ( numeroCor >= 1 && numeroCor <= cores.length ) {
            corSelecionada = cores[numeroCor - 1];
            return corSelecionada;
        }
		return null;
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
	
	public static void listarCarroPorMarca(int marcaSelecionada, ArrayList<Carros> list) {
		ArrayList<String> listMarca = new ArrayList<String>();
		for (Carros carros : list) {
			listMarca.add(carros.getMarca());
		}
		
		
		
		for ( String marca : listMarca) {
			if (marca.equalsIgnoreCase(marcaSelecionada)) {
				System.out.println(carro);
			}
		}
	}
	
	public static void listarCarroPorCor(int numeroCor, ArrayList<Carros> list) {
		Cores corASerListada = Util.selecionaCor(numeroCor);
		for (Carros carros : list) {
			if ( carros.getCor().equals(corASerListada) ) {
				System.out.println(carros);
			}
		}	
	}
	
	public static Double porcentagemRelacionadaAoTotal() {
		
		
		return null;
	}
	
}
