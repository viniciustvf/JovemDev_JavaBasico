package br.com.trier.aula03.biblioteca;

import java.util.Scanner;

public enum EnumSexo {

    MASCULINO( 1, "Masculino" ),
    FEMININO( 2, "Feminino" );

    private int id;
    private String descricao;

    EnumSexo( int id, String descricao ) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EnumSexo buscaPorCodigo( int codigo ) {
        for ( EnumSexo sexo : EnumSexo.values() ) {
            if ( sexo.getId() == codigo ) {
                return sexo;
            }
        }
        return null;
    }

    public static EnumSexo escolherSexo() {
        Scanner sc = new Scanner( System.in );

        for ( EnumSexo sexo : EnumSexo.values() ) {
            System.out.println( sexo.getId() + " - " + sexo.getDescricao() );
        }

        int escolha = sc.nextInt();
        while ( escolha != MASCULINO.getId() && escolha != FEMININO.getId() ) {
            System.out.println( "Opção inválida. Digite novamente!" );
            escolha = sc.nextInt();
        }

        return buscaPorCodigo( escolha );
    }
}
