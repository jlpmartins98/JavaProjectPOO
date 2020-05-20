/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author joaomartins
 */
public class FicheiroTeste{
        /*
        FileReader inStream = new FileReader("Filmes.txt");
        //FileOutputStream fileInput = new FileOutputStream("Filmes.txt");
       // ObjectOutputStream input = new ObjectOutputStream(fileInput);
        BufferedReader bR = new BufferedReader(inStream);
        Scanner fileScan = new Scanner(inStream);
        
        //ciclo de leitura e impressão no ecra
        String a,b,c,line;
        String nome;
        //ArrayList<Filmes> lista = new ArrayList<Filmes>();
        Edicao ed = new Edicao();
        Festival fest = new Festival();
        
        /**
        * Ter atenção à ordem colocada no ficheiro de texto 
        *os atores e as atrizes tem que vir antes das principais
        * as edições tem de estar seguidas dos seus filmes 
        *os filmes tem de estar seguidos dos seus atores, atrizes, atores principal e atrizes  principais
        */
                
    
        /*
        try{
            line = bR.readLine();
            while(line!=null){
                //falta o ano e numero da ediçao,arranjar um simbolo para esta
                //para fazer as atrizes e atores principais basta fazer igual aos atores mas mudando o simbolo
                //System.out.println(line);
                switch (line.charAt(0)) {
                    case '-':
                        {
                            boolean stop = false;
                            //enquanto for verdade
                            while(!stop){
                                line = bR.readLine();
                                if(line.charAt(0) == '-'){
                                    line = bR.readLine();
                                    break;
                                }
                                else{
                                    int ano = Integer.parseInt(line);
                                    line = bR.readLine();
                                    int numDeEdicao = Integer.parseInt(line);
                                    //cria edição, a instanciaçao do festival nao tem q estar fora do ciclo?

                                    ed = new Edicao(ano, numDeEdicao);
                                    if(fest.contemEdicao(ed)){
                                        System.out.println("Ocorreu um erro!" + "\nEste festival já contém esta edição: " + "\n" + ed);
                                        System.out.println();
                                    }
                                    else{
                                    fest.addEdicoes(ed);
                                    //System.out.println(fest.getE());
                                    }
                                }
                            }       break;
                        }
                    //Introduz os atores nos filmes 
                    case ';':
                        {
                            boolean stop = false;
                            while(!stop){
                                //cena de escrever os atores
                                //le o nome do ator
                                line = bR.readLine();
                                if(line.charAt(0) == ';'){
                                    line = bR.readLine();
                                    break;
                                }
                                else{
                                    nome = line;
                                    line = bR.readLine();
                                    //le os anos de carreira do ator
                                    int anosCarreira = Integer.parseInt(line);
                                    //line = bR.readLine();
                                    Atores actor1 = new Atores(nome,anosCarreira);
                                    //estas variaveis sao apenas apra nao escrever aqela parede de texto
                                    //cada vez que qeremos o filme/edicao que estamos a usar
                                    Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                    Edicao edicaoAtual = fest.getE().get(fest.getE().size() - 1);
                                    //adicionar as exeçoes do ator ja estar em 2 filmes nesta ediçao ou o caso de ja estar neste filme
                                    if(!edicaoAtual.maximoAtoresFilmes(actor1)){
                                        if(!filmeAtual.atoresRepetidosNoFilme(actor1)) {
                                            filmeAtual.addAtores(actor1);
                                        }
                                        else{
                                            System.out.println(actor1);
                                            System.out.println("Este ator já participa neste filme!");
                                            System.out.println();
                                        }
                                    }
                                    //alterar estes prints para demonstrar o filme em q nao entrou etc
                                    //provavelmente dividir o if anterior em dois diferentes
                                    else{
                                        System.out.println(actor1);
                                        System.out.println("Este ator já participou em 2 filmes nesta edição");
                                        System.out.println();
                                    }
                                }
                            }
                            //quando acabar, passamos as atrizes e depois temos os dois principais
                            break;
                        }
                    case ':':
                        {
                            boolean stop = false;
                            while(!stop){
                                //cena de escrever os atores
                                //le o nome do ator
                                line = bR.readLine();
                                if(line.charAt(0) == ':'){
                                    line = bR.readLine();
                                    break;
                                }
                                else{
                                    nome = line;
                                    line = bR.readLine();
                                    //le os anos de carreira do ator
                                    int anosCarreira = Integer.parseInt(line);
                                    //line = bR.readLine();
                                    Atriz atriz1 = new Atriz(nome,anosCarreira);
                                    Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                    Edicao edicaoAtual = fest.getE().get(fest.getE().size() - 1);
                                    if(!edicaoAtual.maximoAtrizesFilmes(atriz1)){
                                        if(!filmeAtual.atrizesRepetidosNoFilme(atriz1)){
                                            filmeAtual.addAtriz(atriz1);
                                        }
                                    }
                                    else{
                                        System.out.println("Esta atriz não podes participar neste filme!");
                                    }
                                }
                            
                            }       
                        break;
                        }
                    case '/' :
                    {
                         boolean stop3 = false;
                        while(!stop3){
                        //em vez de termos o codigo todo do caso no teste,por numa funçao e chamar aqi
                        line = bR.readLine();
                            if(line.charAt(0) == '/'){
                                line = bR.readLine();
                                break;
                            }
                            else{
                                nome = line;
                                line = bR.readLine();
                                //le os anos de carreira do ator
                                int anosCarreira = Integer.parseInt(line);
                                //line = bR.readLine();
                                Atores actor1 = new Atores(nome,anosCarreira);
                                //caso nao tenha atores principais
                                Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                Edicao edicaoAtual = fest.getE().get(fest.getE().size() - 1);
                                if(filmeAtual.getPrincipaisMale().isEmpty()){
                                    filmeAtual.addPrincipalMale(actor1);
                                }
                                else{
                                    System.out.print("Ocorreu um erro! No filme: ");
                                    System.out.println(filmeAtual.getNomeFilme());
                                    System.out.println("Este filme já tem um ator principal");
                                    System.out.println();
                                }
                            }
                        } 
                        break;
                    }
                    case '+' :
                    {
                        boolean stop3 = false;
                        while(!stop3){
                        //em vez de termos o codigo todo do caso no teste,por numa funçao e chamar aqi
                            line = bR.readLine();
                            if(line.charAt(0) == '+'){
                                line = bR.readLine();
                                break;
                            }
                            else{
                                nome = line;
                                line = bR.readLine();
                                //le os anos de carreira do ator
                                int anosCarreira = Integer.parseInt(line);
                                //line = bR.readLine();
                                Atriz actress = new Atriz(nome,anosCarreira);
                                Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                Edicao edicaoAtual = fest.getE().get(fest.getE().size() - 1);
                                //caso nao tenha atrizes principais
                                if(filmeAtual.getPrincipaisFemale().isEmpty()){
                                    filmeAtual.addPrincipalFemale(actress);
                                }
                                else{
                                    System.out.println("este filme ja tem um ator principal");
                                }
                            }
                        } 
                        break;
                    }
                    
                    default:
                        a = line;
                        line = bR.readLine();
                        b = line;
                        line = bR.readLine();
                        c = line;
                        line = bR.readLine();
                        Filmes f = new Filmes(a,b,c);
                        ed.addFilmes(f);
                        break;
                }
                
            }
            bR.close();
        }   
        catch(IOException ioe){
            System.out.println("Ocorreu um erro!");
            ioe.getMessage();
        }
        catch(NullPointerException e){
            System.out.println("Ocorreu um erro do tipo NullPointerExeption");
            e.getMessage();
        }
        
        //percorre o array das edições
        for (int i = 0; i < fest.getE().size(); i++) {
            //for (int j = 0; j < fest.getE().get(i).getFilmes().size(); j++) {
            Edicao varEdicaoAtual= fest.getE().get(i);
            System.out.println(varEdicaoAtual);
            System.out.println();
            System.out.println(varEdicaoAtual.getFilmes());
            System.out.println();
                

        }*/

    }
    

