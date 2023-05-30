package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Professor;

public class AlunoBD {

	private ArrayList<Aluno> alunoBD = new ArrayList<Aluno>();
	
	public Aluno adicionaAluno (Aluno aluno) {
		aluno.setId(alunoBD.size()+1);
		alunoBD.add(aluno);
		return aluno;
	}
	
	public Aluno buscarPorId(final Integer id) {
		return alunoBD.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	}
	
	
	
	
}
