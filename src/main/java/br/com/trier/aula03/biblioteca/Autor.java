package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {

    private String nome;
    private EnumSexo sexo;
    private Integer idade;

    public void cadastraAutor() {
        Scanner sc = new Scanner( System.in );

        System.out.print( "Informe o nome do autor: " );
        nome = sc.nextLine().toUpperCase().trim();
        
        while(!nome.contains( " " )) {
            System.out.println( "ERRO: Informe nome e sobrenome do autor." );
            nome = sc.nextLine().toUpperCase().trim();
        }

        System.out.println( "Informe o sexo do autor: " );
        sexo = EnumSexo.escolherSexo();

        try {
            System.out.print( "Informe a idade do autor: " );
            idade = sc.nextInt();
        } catch ( InputMismatchException e ) {
            System.out.println( "ERRO: Digite a idade corretamente." );
            System.exit(0);
        }

        if ( !validarNome() ) {
            cadastraAutor();
        }
        if ( !validarIdade() ) {
            cadastraAutor();
        }
    }

    boolean validarNome() {
        if ( nome.trim().equals("") ) {
            System.out.println( "ERRO: Nome inválido." );
            return false;
        }
        return true;
    }

    boolean validarIdade() {
        if ( idade < 0 ) {
            System.out.println( "ERRO: Idade inválida." );
            return false;
        }
        return true;
    }

    static ArrayList<Autor> escolheAutor( ArrayList<Autor> autores ) {
        Scanner sc = new Scanner( System.in );
        char escolha;
        ArrayList<Autor> ret = new ArrayList<Autor>();
        boolean autoresCheio =  false;
        do {
                        
        	System.out.print( Util.listarAutorComIndice(autores) );
			int opcao = sc.nextInt();
			ret.add(autores.get( opcao - 1 ));
			if ( ret.size() == 4 ) {
				System.out.println( "Limite de autores cadastrados atingido!" );
				break;
			}
              
            System.out.println( "Deseja adicionar mais um autor? (S/N)" );
            System.out.println( "Autores cadastrados: " + ret.size() );
            escolha = sc.next().toUpperCase().charAt(0);
        } while ( escolha != 'N' );

        return ret;
    }

    @Override
    public String toString() {
        return "AUTOR: " + nome + ", SEXO: " + sexo + ", IDADE: " + idade + " ANOS\n";
    }
}
