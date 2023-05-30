package br.com.trier.aula04.notas.util;

import java.util.ArrayList;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;

public class AlunoBD {

	private ArrayList<Aluno> alunoBD = new ArrayList<Aluno>();
	
	public Aluno cadastraAluno(Aluno aluno) {
		Aluno aluno = new Aluno();
		alunoBD.add(aluno);
		return aluno;
	}
	
	
	
}
