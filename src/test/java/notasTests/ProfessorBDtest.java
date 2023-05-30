package notasTests;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula04.notas.enums.EnumFormacao;
import br.com.trier.aula04.notas.models.Professor;
import br.com.trier.aula04.notas.repository.ProfessorBD;

class ProfessorBDtest {

	private ArrayList<Professor> professorDADOS = new ArrayList<Professor>();
	
	@BeforeEach
	void init() {
		ProfessorBD professorBD = new ProfessorBD();
		professorDADOS.add(professorBD.cadastraProfessor("Roberto", EnumFormacao.GRADUACAO));
	}

	@Test
	@DisplayName("Teste cadastro professor")
	void testCadastroProfessor() {
		Assertions.assertEquals("Roberto", professorDADOS.get(0).getNome());
		Assertions.assertEquals(EnumFormacao.GRADUACAO, professorDADOS.get(0).getFormacao());
	}
	
	
	
	
	
	
	
}
