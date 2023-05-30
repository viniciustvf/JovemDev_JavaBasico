package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;

public class AlunoBD {

	private ArrayList<Aluno> alunoBD = new ArrayList<Aluno>();
	
	public Aluno cadastraAluno(String nome, ArrayList<Disciplina> disciplinas) {
		Aluno aluno = new Aluno(nome, disciplinas);
		alunoBD.add(aluno);
		return aluno;
	}
	
	
	
}
