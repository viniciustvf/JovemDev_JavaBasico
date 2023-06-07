package polimorfismoTeste;

import static org.junit.jupiter.api.Assertions.fail;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula05.exemplopolimorfismo.Circulo;
import br.com.trier.aula05.exemplopolimorfismo.Cone;
import br.com.trier.aula05.exemplopolimorfismo.Forma;
import br.com.trier.aula05.exemplopolimorfismo.Quadrado;
import br.com.trier.aula05.exemplopolimorfismo.Triangulo;

class PolimorfismoTest {

	private List<Forma> lista = new ArrayList<Forma>();	
	
	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
	}
	
	@Test
	@DisplayName("Teste desenhar circulo")
	public void desenharCirculoTest() {
		String s = lista.get(0).desenhar();
		Assert.assertEquals("Desenhando um: Circulo", s);
	}
	
	@Test
	@DisplayName("Teste area circulo")
	public void areaCirculoTest() {
		Circulo c = (Circulo) lista.get(0);
		Double area = c.calculaArea();
		DecimalFormat df = new DecimalFormat("##.00");
		Assert.assertEquals("28,27", df.format(area));
	}
	
	@Test
	@DisplayName("Teste desenhar cone")
	public void desenharConeTest() {
		Cone c = (Cone) lista.get(1);
		
		
		
		//Assert.assertEquals("28,27", df.format(area));
	}
	
	
	

}
