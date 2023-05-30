package br.com.trier.aula04.notas.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaAluno {

	private Disciplina disciplina;
	private Aluno aluno;
	ArrayList<Double> notas;
	
	

	
}