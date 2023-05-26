package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        ArrayList<Livro> listLivro = new ArrayList<Livro>();
        ArrayList<Autor> listAutor = new ArrayList<Autor>();

        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.print(Util.menu());
            op = sc.nextInt();

            switch (op) {
                case 1:
                    // Cadastrar autor
                    Autor autor = new Autor();
                    autor.cadastraAutor();
                    listAutor.add(autor);
                    break;
                case 2:
                    // Cadastrar livro
                    Livro livro = new Livro(listAutor);
                    livro.cadastraLivro();
                    listLivro.add(livro);
                    break;
                case 3:
                    // Listar livros
                    System.out.println(Livro.listarLivros(listLivro));
                    break;
                case 4:
                    // Pesquisar por autor
                    System.out.println(Util.pesquisarPorAutor(listAutor, listLivro));
                    break;
                case 5:
                    // Pesquisar por faixa de preço
                    System.out.println(Util.pesquisarPorPreco(listAutor, listLivro));
                    break;
                case 6:
                    // Listar livros de autores infantis (menores de 12)
                    System.out.println(Util.pesquisarPorIdade(listAutor, listLivro));
                    break;
                case 7:
                    // Listar livro por sexo
                    System.out.println(Util.pesquisarPorSexo(listAutor, listLivro));
                    break;
            }
        } while (op != 8);

        sc.close();
    }
}
