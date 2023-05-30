package br.com.trier.aula04.medicamento.models;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Pessoa {

	private String nome;
	private String unicoSintoma;
	private ArrayList<String> alergias = new ArrayList<String>();
	
}
