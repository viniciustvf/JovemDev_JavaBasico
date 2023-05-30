package br.com.trier.aula04.medicamento.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class Pessoa {

	@NonNull
	private String nome;
	@NonNull
	private String sintoma;
	private ArrayList<String> condicaoSaude = new ArrayList<String>();
	private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	public void addCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude.add(condicaoSaude);
	}
	
	public boolean addMedicamento(Medicamento medicamento) {
		if (medicamento.isIndicado(sintoma) && !medicamento.isContraIndicado(condicaoSaude)) {
			medicamentos.add(medicamento);
			return true;
		}
		return false;
	}
}
