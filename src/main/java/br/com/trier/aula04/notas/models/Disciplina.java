package br.com.trier.aula04.notas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Disciplina {
	@NonNull
	private String nome;
	private Integer cargaHoraria;
	@NonNull
	private Professor professor;
	
}
