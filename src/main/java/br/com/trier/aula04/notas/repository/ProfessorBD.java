package br.com.trier.aula04.notas.repository;

import java.util.ArrayList;

import br.com.trier.aula04.notas.models.Professor;

public class ProfessorBD {

	private ArrayList<Professor> professorBD = new ArrayList<Professor>();
	
	public Professor adicionaProfessor (Professor professor) {
		professor.setId(professorBD.size()+1);
		professorBD.add(professor);
		return professor;
	}
	
	public Professor buscarPorId(final Integer id) {
		return professorBD.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	}
	
}
