package com.mycompany.projeto2;

import java.util.ArrayList;
//array para guardar os atores e atrizes, tal como os filmes em que cada um participa
public class FilmesAtores{
    
    private ArrayList<String> atoresFilmes;
    private String name; 
    
    public FilmesAtores(){
        name = "";
        //nomeFilme= "";
        this.atoresFilmes = new ArrayList<String>();
    }
    
    public FilmesAtores(String name){
        this.name = name;
        //this.nomeFilme = nomeFilme;
        atoresFilmes = new ArrayList<String>();
    }

    
    
    
    public String toString(){
        String info;
        info = "Nome do ator/atriz: " + getName() + "\n";
        info += "Filmes em que entra: " + atoresFilmes + "\n";
        return info;
    }
    
    //metodo para ir buscar o nome do ator
    public String getName() {
        return name;
    }
    //metodo para addicionar o nome do filme ao ator
    public void addNomeFilme(String nomeDoFilme){
        this.atoresFilmes.add(nomeDoFilme);
    }
    
     
}
