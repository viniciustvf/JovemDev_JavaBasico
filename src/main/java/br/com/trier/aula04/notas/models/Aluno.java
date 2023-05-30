package br.com.trier.aula04.notas.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Aluno {
	
	@NonNull
	private String nome;
	private ArrayList<DisciplinaAluno> disciplinaAluno = new ArrayList<DisciplinaAluno>();
	
	public void addDisciplina(Disciplina disciplina, ArrayList<Double> notas) {
		
	}
	
	
}
