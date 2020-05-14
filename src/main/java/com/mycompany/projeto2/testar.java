/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(camposLidos);*/
        
        //--------------------como ler um ficheiro--------------
        
        //criar e abrir a stream 
        FileReader inStream = new FileReader("Filmes.txt");
        BufferedReader br = new BufferedReader(inStream);
        
        //ciclo de leitura 
        String linha = br.readLine(); //le uma linha
        while(linha != null){
            System.out.println(linha);
            linha = br.readLine(); //le a linha seguinte
        }
        br.close(); // fechar o stream
        
        
        
    }
}
