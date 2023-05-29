package br.com.trier.aula04.notas;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Professor {

	private String nome;
	private EnumFormacao formacao;
	
	void Professor(String nome, EnumFormacao formacao) {
		Professor professor = new Professor(nome, formacao);
		listProfessor.add(professor);
	}
}
