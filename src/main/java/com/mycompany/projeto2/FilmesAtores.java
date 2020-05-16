
package com.mycompany.projeto2;

import java.util.ArrayList;

public class FilmesAtores extends Atores{
    
    private ArrayList<String> atoresFilmes; 
    
    private String name; 
    private String nomeFilme;
    
    public FilmesAtores(){
        name = "";
        //nomeFilme= "";
        this.atoresFilmes = new ArrayList<String>();
    }
    
    public FilmesAtores(String nome){
        this.name = name;
        //this.nomeFilme = nomeFilme;
        atoresFilmes = new ArrayList<String>();
    }

    
    //metodo para addicionar o nome do filme ao ator
    public void addNomeFilme(String nomeDoFilme){
        this.atoresFilmes.add(nomeDoFilme);
    }
    
    
    
    
    
}
