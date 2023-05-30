

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula04.medicamento.models.Medicamento;
import br.com.trier.aula04.medicamento.models.Pessoa;
import br.com.trier.aula04.medicamento.utils.Util;

class UtilsTeste {
	
	private Util util = new Util();
	
	@BeforeEach
	public void init() {
		
		util.getMedicamentos().clear();
		util.getPessoas().clear();
		
		util.getMedicamentos().clear();
		util.getPessoas().clear();
		
		Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
		p1.addCondicaoSaude("Dengue");
		p1.addCondicaoSaude("Diabetes");
		
		Pessoa p2 = new Pessoa("Pessoa 2", "Dor");
		util.cadastraPessoa(p1);
		util.cadastraPessoa(p2);
		
		Medicamento m1 = new Medicamento("Med 1");
		m1.addIndicacao("Dor");
		m1.addContraIndicacao("Pressão alta");
		
		Medicamento m2 = new Medicamento("Med 2");
		m2.addIndicacao("Gripe");
		m2.addIndicacao("Febre");
		m2.addContraIndicacao("Dengue");
		
		Medicamento m3 = new Medicamento("Med 3");
		m3.addIndicacao("Gripe");
		
		Medicamento m4 = new Medicamento("Med 4");
		m4.addIndicacao("Cólica");
		
		util.cadastraMedicamento(m1);
		util.cadastraMedicamento(m2);
		util.cadastraMedicamento(m3);
		
	}

	@Test
	@DisplayName("Prescrever medicamentos ok")
	void prescreverOk() {
		Pessoa p = util.getPessoas().get(0);
		Medicamento m = util.getMedicamentos().get(2);
		boolean prescrito = util.prescreveMedicamento(p, m);
		assertEquals(true, prescrito);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Med 3", p.getMedicamentos().get(0).getNome());
	}
	
	@Test
	@DisplayName("Prescrever medicamentos com falha na indicação")
	void prescreverFalhaIndicacao() {
		Pessoa p = util.getPessoas().get(0);
		Medicamento m = util.getMedicamentos().get(0);
		boolean prescrito = util.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Prescrever medicamentos com falha na contra indicação")
	void prescreverFalhaContraIndicacao() {
		Pessoa p = util.getPessoas().get(0);
		Medicamento m = util.getMedicamentos().get(1);
		boolean prescrito = util.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	@DisplayName("Existe medicamento ok")
	void existeMedicamento() {
		Medicamento m = util.getMedicamentos().get(1);
		boolean existe = util.existeMedicamento(m);
		assertEquals(true, existe);
	}
	
	@Test
	@DisplayName("Testa se existe medicamento fora da lista")
	void existeMedicamentoFalha() {
		Medicamento m = new Medicamento("Med 5");
		boolean existe = util.existeMedicamento(m);
		assertEquals(false, existe);
	}
	
	@Test
	@DisplayName("Existe pessoa ok")
	void existePessoa() {
		Pessoa p = util.getPessoas().get(0);
		boolean existe = util.existePessoa(p);
		assertEquals(true, existe);
	}
	
	@Test
	@DisplayName("Testa se existe pessoa fora da lista")
	void existePessoaFalha() {
		Pessoa p = new Pessoa("Pessoa 3", "Cólica");
		boolean existe = util.existePessoa(p);
		assertEquals(false, existe);
	}
	
	
	

}