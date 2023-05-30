package br.com.trier.aula04.notas.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {
	
	private Integer id;
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Double> notas;

	
}
