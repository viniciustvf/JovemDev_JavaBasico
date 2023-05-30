package tests;

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

class DisciplinaBDtest {

	private ArrayList<Aluno> alunoDADOS = new ArrayList<Aluno>();
	private ArrayList<Disciplina> disciplinaDADOS = new ArrayList<Disciplina>();
	private ArrayList<Professor> professorDADOS = new ArrayList<Professor>();
	
	@BeforeEach
	void init() {
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Teste cadastro disciplina")
	void testCadastroDisciplina() {
		ArrayList<Double> notas = new ArrayList<Double>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(8.0);
		ProfessorBD professorBD = new ProfessorBD();
		Professor professor = professorBD.cadastraProfessor("Clavison", EnumFormacao.GRADUACAO);
		
		DisciplinaBD disciplinaBD = new DisciplinaBD();
		Disciplina disciplina = disciplinaBD.cadastraDisciplina("Matematica", 40, professor, notas);
		
		disciplinaDADOS.add(disciplina);
		
		Assertions.assertEquals("Matematica", disciplinaDADOS.get(0).getNome());
		Assertions.assertEquals(40, disciplinaDADOS.get(0).getCargaHoraria());
		Assertions.assertEquals("Clavison", disciplinaDADOS.get(0).getProfessor().getNome());
	}
	
	@Test
	@DisplayName("Teste escolhe disciplina")
	void testEscolheDisciplina() {
		ArrayList<Double> notas = new ArrayList<Double>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(8.0);
		ProfessorBD professorBD = new ProfessorBD();
		Professor professor = professorBD.cadastraProfessor("Clavison", EnumFormacao.GRADUACAO);
		
		DisciplinaBD disciplinaBD = new DisciplinaBD();
		Disciplina disciplinaCadastrada = disciplinaBD.cadastraDisciplina("Matematica", 40, professor, notas);
		
		AlunoBD alunoBD = new AlunoBD();
		Aluno alunoCadastrado = alunoBD.cadastraAluno("Vinicius", disciplinaDADOS);
		
		ArrayList<Disciplina> disciplinasEscolhidas = disciplinaBD.escolherDisciplina(disciplinaCadastrada, alunoCadastrado);
		
		Assertions.assertEquals("Matematica", disciplinasEscolhidas.get(0).getNome());
		
	}
	
	
	
	
	
	
	

}
