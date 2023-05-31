package br.com.trier.aula04.notas.util;

import java.util.ArrayList;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;
import br.com.trier.aula04.notas.models.DisciplinaAluno;
import br.com.trier.aula04.notas.models.Professor;

public class Util {

	ArrayList<Professor> professores = new ArrayList<Professor>();
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	ArrayList<DisciplinaAluno> disciplinasAluno = new ArrayList<DisciplinaAluno>();
	
	void cadastraProfessor(Professor professor) {
		professores.add(professor);
	}
	
	void cadastraAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	void cadastraDisciplina(Disciplina disciplina, Professor professor) {		
		disciplina.setProfessor(professor);
		disciplinas.add(disciplina);
	}
	
	void cadastraNotasAluno(Aluno aluno, Disciplina disciplina, ArrayList<Double> notas) {		
		DisciplinaAluno d = new DisciplinaAluno();
		d.setAluno(aluno);
		d.setDisciplina(disciplina);
		d.setNotas(notas);
		disciplinasAluno.add(d);
	}
	
	public ArrayList<DisciplinaAluno> listarDisciplinaAluno(Aluno aluno){
		ArrayList<DisciplinaAluno> disciplinaRet = new ArrayList<DisciplinaAluno>();
		disciplinaRet = aluno.getDisciplinaAluno();
		return disciplinaRet;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
