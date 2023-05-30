package br.com.trier.aula04.medicamento.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumAdministracao {

	INJETAVEL(1, "Injetável"),
	TOPICO(2, "Tópico"),
	ORAL(3, "Oral"),
	SUPOSITÓRIO(4, "Supositório");
	
	private int id;
	private String descricao;
	
}
