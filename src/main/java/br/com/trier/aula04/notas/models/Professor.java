package br.com.trier.aula04.notas.models;


import br.com.trier.aula04.notas.enums.EnumFormacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

	private Integer id;
	private String nome;
	private EnumFormacao formacao;

}
