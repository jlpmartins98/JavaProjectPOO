/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joaomartins
 */
public class testar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
       
        Scanner scan = new Scanner(System.in);
        System.out.println("ESCREVA NUMA LINHA O NOME E IDADE" + " separado por virgulas");
        System.out.print("Aqui->");
        String linha = scan.nextLine();
        System.out.println("linha lida: " + linha);
        
        //usando o split 
        String[] campos = linha.split(",");
        System.out.println("Numeros de campos encontrados: " + campos.length);
        //guardar num arrayList
        ArrayList<String> camposLidos = new ArrayList<>();
        for(String s : campos)
            camposLidos.add(s.trim());
        System.out.println("As strings sao: ");
        for(String s : campos)
            System.out.println("-" + s.trim() + "-"); //trim()serve para nao guardar os espaços
        //System.out.println(camposLidos);
        System.out.println(camposLidos);
        */
        
        //--------------------como ler um ficheiro--------------
        /*
        //criar e abrir a stream 
        FileReader inStreamm = new FileReader("Filmes.txt");
        //buffer é uma porção de memoria usada para armezenar dados temporariamente
        //enquantos estao a ler lidos/escritos
        //aumenta a eficienca, reduzindo o tempo de acesso a ficheiros 
        //PrintWriter pode ser associada para escrever a informação, pois tem mais metodos para manipular os dados 
        //do que a fileWriter
        BufferedReader br = new BufferedReader(inStreamm);
        
        
        //ciclo de leitura 
        String linha = br.readLine(); //le uma linha
        while(linha != null){
            System.out.println(linha);
            linha = br.readLine(); //le a linha seguinte
        }
        br.close(); // fechar o stream
       
        
        
        
        */
        /*
        //-----------------------------------------
        //Classe FIle, representa p ficheiro e não o conteudo 
        File ficheiro = new File("Filmes.txt");
        
        if(ficheiro.exists()){
            System.out.println("Nome: " + ficheiro.getName());
            System.out.println("Diretorio: " + ficheiro.getParent());
            System.out.println("Caminho: " + ficheiro.getPath());
            System.out.println("Caminho completo: " + ficheiro.getAbsolutePath());
            
        }
        else
            System.out.println("o ficheiro nao existe!");
        */
        //--------------------------------------
        //tratamento de exceções 
        
            //ESCRITA
            //FileWriter outStream = new FileWriter("String.txt");
            //BufferedWriter bW = new BufferedWriter(outStream);
            
            //ciclo de escrita
            //for(int i = 1; i<6; i++){
              //  bW.write(i + "linha");
              //  bW.newLine();//separador de linha
           // }
            //bW.close();
            
            //leitura
            //cria a stream


        FileReader inStream = new FileReader("Filmes.txt");
        BufferedReader bR = new BufferedReader(inStream);
         //Scanner fileScan = new Scanner(inStream);
        //ciclo de leitura e impressão no ecra
        String a,b,c;
        ArrayList<Filmes> lista = new ArrayList<Filmes>();
        try{
            String line = bR.readLine();
            while(line!=null){
                
                System.out.println(line);
                
                a = line;
                //line = bR.readLine();
                b = line;
                //line = bR.readLine();
                c = line;
                //line = bR.readLine();
                
                Filmes f = new Filmes(a,b,c);
                f.addFilmes(f);
  
            }

            bR.close();
         
        }   
        catch(IOException ioe){
            System.out.println("Ocorreu um erro!");
            ioe.getMessage();

        }
        System.out.println(lista);
   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva numa linha o nome, idade e email"+ "separados por virgulas");
        System.out.println("Aqui -> ");
        String linha = teclado.nextLine();
        System.out.println("Linha Lida: " + linha);
        //usando o split 
        String[] campos = linha.split(",");
        System.out.println("Nr de campos encontrados: " + campos.length);
        //Guardar num ArrayList
        ArrayList<String> camposLidos = new ArrayList<>();      
        for(String s : campos)
            camposLidos.add(s.trim());
        System.out.println("As strings são");
        for(String s: camposLidos)
            System.out.println("-" + s.trim() + "-"); //devolve sem os espaços inicias ou finais
        System.out.println(camposLidos);
        */
    }

}