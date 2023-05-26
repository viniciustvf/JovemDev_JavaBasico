package br.com.trier.aula03.biblioteca;

import java.util.Scanner;

public enum EnumSexo {

	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int id;
	private String descricao;
	
	EnumSexo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	static EnumSexo buscaPorCodigo(int codigo){
		for (EnumSexo sexo : EnumSexo.values()) {
			if( sexo.id == codigo ) {
				return sexo;
			}
		}
		return null;
	}
	
	
	static EnumSexo escolherSexo() {
		Scanner sc = new Scanner(System.in);
		for (EnumSexo sexo : EnumSexo.values()) {
			System.out.println(sexo.id + " - " + sexo.descricao);
		}
		
		int escolha = sc.nextInt();
		while ( escolha != 1 && escolha != 2) {
			System.out.println("SEXO INVÁLIDO, DIGITE NOVAMENTE!");
			escolha = sc.nextInt();
		}
		
		return buscaPorCodigo(escolha);
	}

}
