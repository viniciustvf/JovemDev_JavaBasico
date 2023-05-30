package br.com.trier.aula04.medicamento.models;

import java.util.ArrayList;

import br.com.trier.aula04.medicamento.enums.EnumAdministracao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

	@NonNull
	private String nome;
	@NonNull
	private EnumAdministracao administracao;
	ArrayList<String> alergias = new ArrayList<String>();
	ArrayList<String> indicacoes = new ArrayList<String>();
	
	
}
