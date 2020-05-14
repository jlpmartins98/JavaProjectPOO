package com.mycompany.projeto2;

import java.util.Scanner;


public class TestarFilmesAtores {
            

    public static void main(String[] args) {
        
        
        /**
         * Teste para verificar se esta a ser criado um array de atores para um Filme
         * mostrando a informacao do filme e dos atores desse Filme
         */
        
        
        //criação de um filme
        //Filmes f = new Filmes("Scary Movie", "comedia","Steven Spielberg");
        
        //Polimorfismo criação de uma atriz/ator do tipo atores
        /*
        Atores a1 = new Atores("James Bond", 30);
        f.addAtores(a1);
        Atores a2 = new Atores("Roberto Del Niro", 40);
        f.addAtores(a2);
        Atriz a3 = new Atriz("Sandra Bullock", 25);
        f.addAtriz(a3);
        Atores a4 = new Atores("Dustin Hoffman", 41);
        f.addAtores(a4);
        Atores a5 = new Atores("George C. Scott", 38);
        f.addAtores(a5);
        Atores a6 = new Atores("Tom Hanks", 28);
        f.addAtores(a6);
        Atriz a7 = new Atriz("Angelina Jolie", 20);
        f.addAtriz(a7);
        
        
        f.addPrincipais(a1, a3);
        //mostra as informações do filme
        System.out.print(f); 
        */    
        
       Scanner scan = new Scanner(System.in);
       //String nome = scan.next();
       //String genero = scan.next();
       //String realizador = scan.next();
       
       Edicao ed = new Edicao(2020, 1);
       System.out.println("Criar Filmes");
       System.out.println("Nome do filme que pretende inserir,na linha abaixo genero e na linha abaixo o realiador");
       ed.addFilmes(new Filmes(scan.next(),scan.next(),scan.next()));
       System.out.println(ed.getFilmes());
    }
    
}
