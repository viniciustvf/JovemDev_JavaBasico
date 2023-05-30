package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;
import br.com.trier.aula04.notas.models.Professor;


public class DisciplinaBD {
	
	private ArrayList<Disciplina> disciplinaBD = new ArrayList<Disciplina>();
	
	public Disciplina cadastraDisciplina(String nome, Integer cargaHoraria, Professor professor, ArrayList<Double> notas) {
		Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor, notas);
		disciplinaBD.add(disciplina);
		return disciplina;
	}
		
	public ArrayList<Disciplina> escolherDisciplina(Disciplina disciplina, Aluno aluno){
		ArrayList<Disciplina> disciplinasEscolhidas = new ArrayList<Disciplina>();
		if(aluno.getDisciplina().contains(disciplina)) {
			disciplinasEscolhidas = aluno.getDisciplina();
		}
		return disciplinasEscolhidas;
	}
	
	public ArrayList<Double> informarNotasDisciplina(Disciplina disciplina, Aluno aluno){
		ArrayList<Double> notas = new ArrayList<Double>();
		if(aluno.getDisciplina().equals(disciplina)) {
			notas = aluno.getDisciplina()
		}
		return notas;
	}
	
}