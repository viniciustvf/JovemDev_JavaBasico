package br.com.trier.aula04.notas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EnumFormacao {

	GRADUACAO(1, "Graduação"),
	ESPECIALIZACAO(2, "Especialização"),
	POS_GRADUACAO(3, "Pós-graduação");
	
	private int id;
	private String descricao;
	
}
