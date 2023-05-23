/**
 * @author VINICIUS COSTA
 * 
 */

package br.com.trier.aula01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Pessoa> list = new ArrayList<Pessoa>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas irão fazer a avaliação?: ");
		int quantidadeDePessoas = sc.nextInt();
		
		try {	
			for (int i = 0; i < quantidadeDePessoas; i++) {
				System.out.println("Pessoa " + (i+1) + " digite seu nome: ");
				String nome = sc.next();
				System.out.println("Digite seu sexo (MASCULINO/FEMININO): ");
				String sexo = sc.next();
				System.out.println("Digite seu peso: ");
				Double peso = sc.nextDouble();
				System.out.println("Digite sua altura: ");
				Double altura = sc.nextDouble();
				
				list.add(new Pessoa(nome,sexo,peso,altura));
			
			}
		}
		catch(Exception e) {
			System.out.println("ERRO: Digite corretamente.");
		}
		
		for (Pessoa pessoa : list) {
			System.out.println(pessoa);
		}
	}
}
