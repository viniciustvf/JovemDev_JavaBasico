package br.com.trier.aula03.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {

    public static String menu() {
        return "--------------------------------------------------\n" +
                "1 - Cadastrar autor\n" +
                "2 - Cadastrar livro\n" +
                "3 - Listar livros\n" +
                "4 - Pesquisar por autor\n" +
                "5 - Pesquisar por faixa de preço\n" +
                "6 - Listar livros de autores infantis (menores de 12 anos)\n" +
                "7 - Listar livros por sexo\n" +
                "8 - Sair\n" +
                "--------------------------------------------------\n";
    }

    public static String pesquisarPorAutor(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do autor: ");
        String autorNome = sc.nextLine().trim();

        ArrayList<Livro> livroPorAutor = new ArrayList<Livro>();

        for (Livro livro : listLivro) {
            if (livro.contemAutor(autorNome)) {
                livroPorAutor.add(livro);
            }
        }

        if (!livroPorAutor.isEmpty()) {
            StringBuilder ret = new StringBuilder();
            for (Livro livro : livroPorAutor) {
                ret.append(livro).append("\n");
            }
            return ret.toString();
        } else {
            return "Nenhum livro encontrado para o autor informado.";
        }
    }

    public static String pesquisarPorPreco(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o preço inicial: ");
        double precoI = sc.nextDouble();
        System.out.print("Digite o preço final: ");
        double precoF = sc.nextDouble();

        ArrayList<Livro> livroPorPreco = new ArrayList<Livro>();

        for (Livro livro : listLivro) {
            if (livro.getPreco() > precoI && livro.getPreco() < precoF) {
                livroPorPreco.add(livro);
            }
        }

        if (!livroPorPreco.isEmpty()) {
            StringBuilder ret = new StringBuilder();
            for (Livro livro : livroPorPreco) {
                ret.append(livro).append("\n");
            }
            return ret.toString();
        } else {
            return "Nenhum livro encontrado na faixa de preço informada.";
        }
    }

    public static String pesquisarPorIdade(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {
        ArrayList<Livro> livroPorIdade = new ArrayList<Livro>();

        for (Livro livro : listLivro) {
            if (livro.contemAutorMenorIdade()) {
                livroPorIdade.add(livro);
            }
        }

        if (!livroPorIdade.isEmpty()) {
            StringBuilder ret = new StringBuilder();
            for (Livro livro : livroPorIdade) {
                ret.append(livro).append("\n");
            }
            return ret.toString();
        } else {
            return "Nenhum livro encontrado de autores menores de 12 anos.";
        }
    }

    public static String pesquisarPorSexo(ArrayList<Autor> listAutor, ArrayList<Livro> listLivro) {
        EnumSexo sexo = EnumSexo.escolherSexo();
        ArrayList<Livro> livroPorSexo = new ArrayList<Livro>();

        for (Livro livro : listLivro) {
            if (livro.contemAutorPorSexo(sexo)) {
                livroPorSexo.add(livro);
            }
        }

        if (!livroPorSexo.isEmpty()) {
            StringBuilder ret = new StringBuilder();
            for (Livro livro : livroPorSexo) {
                ret.append(livro).append("\n");
            }
            return ret.toString();
        } else {
            return "Nenhum livro encontrado para o sexo informado.";
        }
    }
    
    
    static String listarAutores(ArrayList<Autor> listAutor) {
        StringBuilder ret = new StringBuilder();
        for (Autor autor : listAutor) {
            ret.append("\n").append(autor);
        }
        return ret.toString();
    }
}

