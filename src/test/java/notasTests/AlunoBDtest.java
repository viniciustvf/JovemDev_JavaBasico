package notasTests;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula04.notas.enums.EnumFormacao;
import br.com.trier.aula04.notas.models.Aluno;
import br.com.trier.aula04.notas.models.Disciplina;
import br.com.trier.aula04.notas.models.Professor;
import br.com.trier.aula04.notas.repository.AlunoBD;
import br.com.trier.aula04.notas.repository.DisciplinaBD;
import br.com.trier.aula04.notas.repository.ProfessorBD;

class AlunoBDtest {

	private ArrayList<Aluno> alunoDADOS = new ArrayList<Aluno>();
	private ArrayList<Disciplina> disciplinaDADOS = new ArrayList<Disciplina>();
	private ArrayList<Professor> professorDADOS = new ArrayList<Professor>();
	
	@BeforeEach
	void init() {
		ArrayList<Double> notas = new ArrayList<Double>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		
		
		notas.add(10.0);
		notas.add(9.0);
		notas.add(8.0);
		AlunoBD alunoBD = new AlunoBD();
	    ProfessorBD professorBD = new ProfessorBD(); 
	    DisciplinaBD disciplinaBD = new DisciplinaBD();
	    
	    Professor professorCadastrado = professorBD.cadastraProfessor("Clavison", EnumFormacao.GRADUACAO);
		Disciplina disciplina1 = disciplinaBD.cadastraDisciplina("Matematica", 40, professorCadastrado, notas);
		disciplinas.add(disciplina1);
		
		Aluno alunoCadastrado = alunoBD.cadastraAluno("Vinicius", disciplinas);

	    alunoDADOS.add(alunoCadastrado);
		
	}

	@Test
	@DisplayName("Teste cadastro aluno")
	void testCadastroAluno() {
		Assertions.assertEquals("Vinicius", alunoDADOS.get(0).getNome());
		Assertions.assertEquals(40, alunoDADOS.get(0).getDisciplina().get(0).getCargaHoraria());
	}
	
	
	
	
	
	
	
	
	

}
