package br.com.trier.aula04.notas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disciplina {

	private Integer id;
	private String nome;
	private Integer cargaHoraria;
	private Professor professor;
	

}
