package br.com.trier.aula04.notas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disciplina {

	private String nome;
	private Integer cargaHoraria;
	private Professor professor;

	
	
}
