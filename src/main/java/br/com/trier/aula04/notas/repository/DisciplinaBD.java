package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;
import br.com.trier.aula04.notas.models.Professor;


public class DisciplinaBD {
	
	private ArrayList<Disciplina> disciplinaBD = new ArrayList<Disciplina>();
	
	public Disciplina adicionaDisciplina (Disciplina disciplina) {
		disciplina.setId(disciplinaBD.size()+1);
		disciplinaBD.add(disciplina);
		return disciplina;
	}
	
	public void cadastraDisciplina(Disciplina disciplina, Professor professor) {
		adicionaDisciplina(disciplina);
		disciplinaBD.stream()
					.filter(d -> d.getId().equals(disciplina.getId()))
					.findFirst()
					.ifPresent(d -> d.setProfessor(professor));
	}
		
	public ArrayList<Disciplina> buscaPorAluno(Aluno aluno) {
		ArrayList<Disciplina> disciplinasMatriculadas = new ArrayList<Disciplina>();
		disciplinaBD.stream()
					.filter(aluno.getDisciplinas()::contains)
					.collect(Collectors.toCollection(ArrayList::new));
		return disciplinasMatriculadas;				
	}
	
	public ArrayList<Disciplina> escolherDisciplina(final Integer id, Aluno aluno) {
		ArrayList<Disciplina> disciplinasDoAluno = buscaPorAluno(aluno);
		 return (ArrayList<Disciplina>) disciplinasDoAluno.stream()
		            .filter(disciplina -> disciplina.getId().equals(id))
		            .collect(Collectors.toList());
	}
	
	public ArrayList<Disciplina> notasPorDisciplina(final Integer id, Aluno aluno) {
		ArrayList<Disciplina> disciplinas = escolherDisciplina(id,aluno);
		disciplinas.stream()
					.filter(disciplina -> disciplina.getId().equals(aluno.getId()))
					.findFirst()
					.orElse(null);
		return notasDoAluno;		
	}
	
	
	
	
	
}