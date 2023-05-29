package br.com.trier.aula04.notas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {
	
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	
	
	
	
	
}
