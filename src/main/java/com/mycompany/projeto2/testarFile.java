/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author joaomartins
 */
public class testarFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
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
                                    int numDeEdicao = Integer.parseInt(line);
                                    //cria edição
                                    Festival fest = new Festival();
                                    Edicao edi = new Edicao(ano, numDeEdicao);
                                    fest.addEdicoes(edi);
                                    
                                }
                            }       break;
                        }
                //substituir isto por readobject e tal
                //criar um ciclo para ler os atores, neste ciclo temos a condiçao de paragem que é caso o proximo character seja ponto e virgula
                //esta condiçao pode ser caso o string da linha seja ; q devolve uma booleana
                //começamos a escrever os atores
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
                                    ed.getFilmes().get(ed.getFilmes().size() - 1).addAtores(actor1);
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
                                    ed.getFilmes().get(ed.getFilmes().size() - 1).addAtriz(atriz1);
                                }
                                
                            }       break;
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
        System.out.println(ed.getFilmes());
   
        
        
        
        
        
        
        
        
        
        
    }
    
}
