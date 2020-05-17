package com.mycompany.projeto2;

import java.util.ArrayList;

public class FilmesAtrizes {
    
    private ArrayList<String> atrizesFilmes; 
    
    private String name; 
    private String nomeFilme;
    
    public FilmesAtrizes(){
        name = "";
        //nomeFilme= "";
        this.atrizesFilmes = new ArrayList<String>();
    }
    
    public FilmesAtrizes(String name){
        this.name = name;
        //this.nomeFilme = nomeFilme;
        atrizesFilmes = new ArrayList<String>();
    }

    
    //metodo para addicionar o nome do filme ao ator
    public void addNomeFilme(String nomeDoFilme){
        this.atrizesFilmes.add(nomeDoFilme);
    }
    
    public String toString(){
        String info;
        info = "Nome da atriz: " + name + "\n";
        info += "Filmes em que entra: " + atrizesFilmes + "\n";
        return info;
    }

    
}
