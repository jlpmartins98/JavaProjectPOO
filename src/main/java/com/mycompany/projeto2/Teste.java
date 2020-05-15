
package com.mycompany.projeto2;

import java.io.*;
import java.util.Scanner;

//import javafx.geometry.Side;
/**
 *
 * @author joaomartins
 */

public class Teste {


    
    public static void main(String[] args) throws IOException {
        int opcao;

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Edicao ed = new Edicao();
        Filmes f = new Filmes();
        Festival festival = new Festival();
        
        //ciclo para apresentar menu 
        do {
            apresentarMenu();
            opcao = scan.nextInt();
            
            switch(opcao){
                case 1:
                    //Criar ediçao
                    
                    System.out.println("A criar uma nova edição");
                    System.out.println("Escreva o ano e o número da edição, separados por espaços");
                    Edicao ed1 = new Edicao(scan.nextInt(),scan.nextInt());
                    if(festival.getE().contains(ed1)){
                        System.out.println("Essa edição já existe!");
                    }
                    else{
                        festival.addEdicoes(ed1);
                        System.out.println("Edição criada!");
                    }
                    break;
                case 2:
                    //associar os filmes às ediçoes criadas 
                    System.out.println(festival.getE());                                                                                                    //mostra as edições
                    System.out.println("Escolha a edição onde deseja colocar o filme, introduzindo a posição desejada, começando por 0");
                    int ediEscolhida = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                    ed = festival.getE().get(ediEscolhida);                                                                                                 //obtem a edição, que está no array 
                    System.out.println(ed);                                                                                                                 //mostra a edição escolhida
                    //criar Filmes 
                    System.out.println("Criar Filmes");
                    System.out.println("Insira o nome do filme que pretende inserir na edição escolhida,na linha abaixo o género e na proxima linha abaixo o realiador");
                    //ed.addFilmes(new Filmes(br.readLine(),br.readLine(),br.readLine()));                                                                    //Cria um filme e adiciona o filme à edição 
                    Filmes f1 = new Filmes(br.readLine(),br.readLine(),br.readLine());
                    if(ed.getFilmes().contains(f1)){
                        System.out.println("Este filme já existe!");
                    }
                    else{
                        ed.addFilmes(f1);
                        System.out.println(ed.getFilmes());                                                                                                     //mostra os filmes 
                        System.out.println("Filme criado!");                      
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println(festival.getE());                                                                                                    //mostra as edições
                    System.out.println("Escolha a edição onde deseja colocar o filme, introduzindo a posição desejada, começando por 0");
                    int ediEscolhida2 = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                    ed = festival.getE().get(ediEscolhida2);        //obtem a edição 
                    System.out.println(ed.getFilmes());                                                                                                     
                    System.out.println("Escolha o filme onde deseja colocar o ator, introduzindo a posição desejada, começando por 0");         
                    int filmeEscolha = scan.nextInt();                                                                                                      
                    f = ed.getFilmes().get(filmeEscolha);
                    System.out.println(f);
                    //Criar atores
                    System.out.println("A criar atores");
                    System.out.println("Introduza o nome do ator,e na linha abaixo introduza os seus anos de carreira");
                    f.addAtores(new Atores(br.readLine(),scan.nextInt()));                                                                                  
                    System.out.println("Atores neste filme: " + f.getAtores());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("A criar atrizes");
                    System.out.println("Introduza o nome da atriz e na linha abaixo introduza os seus anos de carreira");
                    f.addAtriz(new Atriz(br.readLine(),scan.nextInt()));
                    System.out.println("Atrizes neste filme: " + f.getAtriz()); 
                    break;
                case 5:
                    //escolher as pessoas para os papeis principais
                    System.out.println("Escolha um ator para o papel principal");
                    //O utilizador escolhe um ator dos previamente introduzidos para tomar o papel principal
                    //Ainda nao sei bem como fazer esta parte, ou seja como deixar o utilizador aceder ao array de atores e selecionar um
                    //Mostra todos os atores disponiveis ou seja o array de atores
                    System.out.println(f.getAtores());
                    //O utilizador escreve o nome do ator que deseja ter no papel principal e este é guardado numa variavel que depois no fim é usada no addPrincipais
                    System.out.println("Escolha a posicao do ator desejado, começando no 0");
                    //Falta aqi os casos de o utilizador inserir um index invalido, ou nao inserir um inteiro
                    //Basicamente os try e catch com os erros apropriados
                    f.addPrincipalMale(f.getAtores().get(scan.nextInt()));
                    System.out.println("Escolha uma atriz para o papel principal");
                    //Mostra o array das atrizes disponiveis
                    System.out.println(f.getAtriz());
                    System.out.println("Escolha a posicao da atriz desejada,começando no 0");
                    f.addPrincipalFemale(f.getAtriz().get(scan.nextInt()));
                    System.out.println("Ator Principal neste Filme :" + f.getPrincipaisMale());
                    System.out.println("Atriz principal neste filme:" + f.getPrincipaisFemale());
                    System.out.println();
                    break;
                case 6:
                    //escolher as pessoas para os papeis secundarios
                    //Esta parte é possivelmente desnecessaria como apos escolher os principais obrigatoriamente os outros serao todos secundarios
                    System.out.println();
                    break;
                case 7:
                    System.out.println(festival.getE());
                    System.out.println("Escolha a posicao da edição desejada,começando no 0");
                    ed = festival.getE().get(scan.nextInt());
                    System.out.println(ed);
                    System.out.println("Filmes dessa edição: ");
                    System.out.println(ed.getFilmes());
                    break; 
                case 8: 
                    System.out.println("Saindo da aplicação!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
     
            }
            
        } while (opcao!=8);
         
 
    }
    //metodo para apresentar o menu menu
    public static void apresentarMenu(){
        
            System.out.println("Escolha uma opção");
            System.out.println("1- Criar uma nova Edição");
            System.out.println("2- Criar Filmes");
            System.out.println("3- Criar atores");
            System.out.println("4- Criar atrizes");
            System.out.println("5- Atribuir papel principal");
            System.out.println("6- Atribuir Papel secundário");
            System.out.println("7- Ver edições");
            System.out.println("8- Sair");
            
    }


}