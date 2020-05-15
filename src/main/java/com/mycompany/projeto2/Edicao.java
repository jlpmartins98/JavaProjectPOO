package com.mycompany.projeto2;

import java.util.ArrayList;
import java.util.Scanner;


public class Edicao {
    //variaveis de instancia 
    private int ano; 
    private int numEdicao;
    
    //array de Filmes
    private ArrayList<Filmes> filmes;
    
 
    //construtores Edicao 
    public Edicao(){
        ano = 0;
        numEdicao = 0;
        this.filmes = new ArrayList<Filmes>();
    }
    
    public Edicao(int ano, int numEdicao){
        this.ano = ano;
        this.numEdicao = numEdicao;
        this.filmes = new ArrayList<Filmes>();
    }
    
    
    //metodos modificadores e seletores 
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public ArrayList<Filmes> getFilmes() {
        return this.filmes;
    }

    public void setFilmes(ArrayList<Filmes> filmes) {
        this.filmes = filmes;
    }
    
    //informação sobre uma Edição 
    public String toString(){
        String info; 
        info = "Número de Edição: " + numEdicao + "\n";
        info += "Ano da Edição: " + ano;
        return info;
    }
    
    //metodo para adicionar filmes a uma edicao 
    public void addFilmes(Filmes movie){
        this.filmes.add(movie);
        
    }
    
    public boolean contemFilme(Filmes movie){
        for(int i=0;i < this.filmes.size(); i++){
            if(this.getFilmes().get(i).getNomeFilme().equals(movie.getNomeFilme())){
                return true;
            }
        }
        return false;
    }
}
