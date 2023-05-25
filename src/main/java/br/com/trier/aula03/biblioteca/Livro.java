package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {

	private String titulo;
	private Double preco;
	private ArrayList<Autor> listAutor = new ArrayList<Autor>();
	
	
	
	
	
}
