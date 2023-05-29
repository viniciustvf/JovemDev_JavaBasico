package br.com.trier.aula04.notas;

import java.util.ArrayList;

import br.com.trier.aula03.biblioteca.EnumSexo;

public class Util {
	
	private ArrayList<Professor> listProfessor = new ArrayList<Professor>();
	private ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();
	private ArrayList<Disciplina> listDisciplina = new ArrayList<Disciplina>();
	
	
	
	void cadastraDisciplina(String nome, Integer cargaHoraria, Professor professor) {
		Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor);
		listDisciplina.add(disciplina);
	}
	
	
	
	
	
	
	
	void cadastraAlunos(String nome, EnumFormacao formacao) {
		Aluno aluno = new Aluno(nome, formacao);
		listAlunos.add(aluno);
	}
	
	
}
