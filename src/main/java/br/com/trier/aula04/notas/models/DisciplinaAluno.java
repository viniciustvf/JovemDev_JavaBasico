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
	private ArrayList<Double> notas = new ArrayList<Double>();
	
	public boolean temAluno(Aluno aluno) {
		if (this.aluno.equals(aluno)) {
			return true;
		}
		return false;
	}
	
	
	public Double getMedia() {
		Double soma = notas.get(0);
		soma += notas.get(1);
		soma += notas.get(2);
		return soma / notas.size();
	}
	
	
	
	
}