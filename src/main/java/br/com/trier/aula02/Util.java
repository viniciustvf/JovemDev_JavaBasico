package br.com.trier.aula02;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Util {
	
	public static void menu() {
		System.out.println("----------------------------------------------");
		System.out.println("1 - Cadastrar Carro");
		System.out.println("2 - Listar os carros por período de fabricação");
		System.out.println("3 - Listar carros por marca");
		System.out.println("4 - Listar carros por cor");
		System.out.println("5 - Sair");
		System.out.println("----------------------------------------------");
	}

	public static Cores selecionaCor(int numeroCor) {
		Cores corSelecionada = null;

		//Passando os enums para um vetor, para serem selecionados.
		Cores[] cores = Cores.values();

		if ( numeroCor >= 1 && numeroCor <= cores.length ) {
			corSelecionada = cores[numeroCor - 1];
			return corSelecionada;
		} else {
			System.out.println("Digite um numero válido.");
		}
		return null;
	}

	public static int obterAnoInteiro(String anoString) {
		try {
			Integer valida = Integer.parseInt(anoString);
			Year anoFormatado = Year.parse(anoString);
			return anoFormatado.getValue();
		}
		catch (Exception e) {
			System.out.println("ERRO: Ano inválido, por favor, insira um ano válido.");
			System.exit(0);
		}
		return -1;
	}

	public static void listaCarroPeriodoFabricacao(int anoInicial, int anoFinal, ArrayList<Carros> list) {
		int numeroListado = 0;
		for (Carros carro : list) {
			if (carro.getAno() > anoInicial && carro.getAno() < anoFinal) {
				System.out.println(carro);
				numeroListado++;
			}
		}
		Double porcentagem = porcentagemRelacionadaAoTotal(numeroListado, list);
		System.out.println("Esses carros representam " + String.format("%.2f", porcentagem) + "% dos carros cadastrados.");
	}

	public static void listarCarroPorMarca(String marcaSelecionada, ArrayList<Carros> list) {
		int numeroListado = 0;
		boolean marcaEncontrada = false;
		for (Carros carro : list) {
			if (carro.getMarca().equalsIgnoreCase(marcaSelecionada)) {
				System.out.println(carro);
				marcaEncontrada = true;
				numeroListado++;
			}
		}
		if(!marcaEncontrada) {
			System.out.println("Marca não encontrada, tente novamente.");
		}
		Double porcentagem = porcentagemRelacionadaAoTotal(numeroListado, list);
		System.out.println("Esses carros representam " + String.format("%.2f", porcentagem) + "% dos carros cadastrados.");
	}

	public static void listarCarroPorCor(int numeroCor, ArrayList<Carros> list) {
		int numeroListado = 0;
		Cores corASerListada = Util.selecionaCor(numeroCor);
		for (Carros carros : list) {
			if (carros.getCor().equals(corASerListada)) {
				System.out.println(carros);
				numeroListado++;
			}
		}
		Double porcentagem = porcentagemRelacionadaAoTotal(numeroListado, list);
		System.out.println("Esses carros representam " + String.format("%.2f", porcentagem) + "% dos carros cadastrados.");
	}

	public static Double porcentagemRelacionadaAoTotal(int numeroListado, ArrayList<Carros> list) {
		Double calculo = (double) ( numeroListado * 100.0 ) / list.size();
		return calculo;
	}

}
