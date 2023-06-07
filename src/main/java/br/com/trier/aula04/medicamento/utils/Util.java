package br.com.trier.aula04.medicamento.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula04.medicamento.models.Medicamento;
import br.com.trier.aula04.medicamento.models.Pessoa;
import lombok.Getter;

@Getter
public class Util {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	public void cadastraPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public void cadastraMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}
	
	public boolean existePessoa(Pessoa pessoa) {
		return pessoas.contains(pessoa);
	}
	
	public boolean existeMedicamento(Medicamento medicamento) {
		if (medicamentos.contains(medicamento)){
			return true;
		}
		return false;
	}
	
	public boolean prescreveMedicamento(Pessoa pessoa, Medicamento medicamento) {
		if (existePessoa(pessoa) && existeMedicamento(medicamento)) {
			return pessoa.addMedicamento(medicamento);
		}
		return false;
	}
	
}
