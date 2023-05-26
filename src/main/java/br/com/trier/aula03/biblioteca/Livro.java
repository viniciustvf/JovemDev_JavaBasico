package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {


    private String titulo;
    private Double preco;
    private ArrayList<Autor> listAutor = new ArrayList<Autor>();

    public Livro(ArrayList<Autor> autoresDisponiveis) {
        this.listAutor = Autor.escolheAutor(autoresDisponiveis);
    }

    void cadastraLivro() {
        boolean livroCadastrado = false;

        while (!livroCadastrado) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Informe o título do livro: ");
            titulo = sc.nextLine().toLowerCase();

            try {
                System.out.print("Informe o preço: ");
                preco = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Digite o preço corretamente.");
                System.exit(0);
            }

            if (validaTitulo() && validaPreco()) {
                livroCadastrado = true;
            }

            System.out.println(this);
        }
    }

    boolean validaTitulo() {
        if (titulo.trim().equals("")) {
            System.out.println("TÍTULO INVÁLIDO, DIGITE NOVAMENTE");
            return false;
        }
        return true;
    }

    boolean validaPreco() {
        if (preco <= 0.0) {
            System.out.println("PREÇO INVÁLIDO, DIGITE NOVAMENTE");
            return false;
        }
        return true;
    }

    static String listarAutores(ArrayList<Autor> listAutor) {
        StringBuilder ret = new StringBuilder();
        for (Autor autor : listAutor) {
            ret.append("\n").append(autor);
        }
        return ret.toString();
    }

    static String listarLivros(ArrayList<Livro> listLivro) {
        StringBuilder retLivros = new StringBuilder();

        for (Livro livro : listLivro) {
            retLivros.append(livro);
        }
        return retLivros.toString();
    }

    boolean contemAutor(String autorNome) {
        for (Autor autor : this.listAutor) {
            if (autor.getNome().equalsIgnoreCase(autorNome)) {
                return true;
            }
        }
        return false;
    }

    boolean contemAutorMenorIdade() {
        for (Autor autor : this.listAutor) {
            if (autor.getIdade() <= 12) {
                return true;
            }
        }
        return false;
    }

    boolean contemAutorPorSexo(EnumSexo sexo) {
        for (Autor autor : this.listAutor) {
            if (autor.getSexo().equals(sexo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "-----------------------------\n"
                + "TÍTULO: " + titulo
                + ", PREÇO: R$" + String.format("%.2f", preco)
                + "\nAUTORES\n" + listarAutores(listAutor);
    }
}
