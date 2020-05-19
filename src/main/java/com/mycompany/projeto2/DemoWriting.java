/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author joaomartins
 */
public class DemoWriting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        Edicao ed1 = new Edicao(2020,1);
        Edicao ed2 = new Edicao(2020,2);
        Edicao ed3 = new Edicao(2020,2);
        
        Edicao[] edicaoArray = new Edicao[3];
        for (int i = 0; i < edicaoArray.length; i++) {
            String outputText = edicaoArray.toString();
            
            saveToFile("FilmesTESTE.txt",  outputText);
        }
        
        

    }
    public static void saveToFile(String fileName, String text) throws IOException{
        
        //1-create a file
        File file1 = new File (fileName);
        
        //2-create a file writer
        FileWriter fw = new FileWriter(file1);
        
        //3-create a print wrtiter ter(fw);
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println(text);
        pw.close();
    }
    
}
