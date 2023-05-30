package br.com.trier.aula04.medicamento.repository;

import java.util.ArrayList;

import br.com.trier.aula04.medicamento.models.Medicamento;

public class MedicamentoBD {

	private ArrayList<Medicamento> medicamentoDADOS = new ArrayList<Medicamento>();
	
	public void cadastrarMedicamento(Medicamento medicamento) {
		medicamentoDADOS.add(medicamento);
	}
	
	
	
	
}
