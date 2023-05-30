package medicamentoTests;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula04.medicamento.enums.EnumAdministracao;
import br.com.trier.aula04.medicamento.models.Medicamento;
import br.com.trier.aula04.medicamento.repository.MedicamentoBD;

public class MedicamentoBDtest {

	ArrayList<Medicamento> medicamentoBD = new ArrayList<Medicamento>();	
	
	@BeforeEach
	void init() {
		Medicamento medicamento1 = new Medicamento("Lozartana", EnumAdministracao.ORAL, null, null);
		Medicamento medicamento2 = new Medicamento("Dorflex", EnumAdministracao.ORAL, null, null);
		Medicamento medicamento3 = new Medicamento("Insulina", EnumAdministracao.INJETAVEL, null, null);
		medicamentoBD.add(medicamento1);
		medicamentoBD.add(medicamento2);
		medicamentoBD.add(medicamento3);

	}
	
	@Test
	@DisplayName("Teste cadastro medicamento")
	public void testaCadastroMedicamento() {
		MedicamentoBD medicamentoBD = new MedicamentoBD() {
			
			
		}
	}
}
