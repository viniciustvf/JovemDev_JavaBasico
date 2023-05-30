package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;

import br.com.trier.aula04.notas.enums.EnumFormacao;
import br.com.trier.aula04.notas.models.Professor;

public class ProfessorBD {

	private ArrayList<Professor> professorBD = new ArrayList<Professor>();
	
	public Professor cadastraProfessor (String nome, EnumFormacao formacao) {
		Professor professor = new Professor(nome, formacao);
		professorBD.add(professor);
		return professor;
	}
	
	
	

	
}
