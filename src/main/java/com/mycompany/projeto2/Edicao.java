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
    
    
    
    
    //verifica se tem mais de 2 atores nos filmes, em cada edição
    public boolean maximoAtoresFilmes(Filmes movie, Atores act,Edicao edicao){
        int contador = 0; 

       
            for (int i = 0; i < this.filmes.size(); i++) {     //percorre o array dos filmes 

                if(contador <= 2 ){  //enquanto tiver menos de duas instancias de ator 
                    if(this.filmes.get(i).){             
                        contador++;                            //incrementa o contador 
                        movie.addAtores(act);                  //e adiciona o ator a esse filme 
                    }
                }
                else{
                    System.out.println("O ator só pode estar no máximo em dois filmes diferentes!");
                    return true;
                }
            }
          
        return false;
    }
    
    //metodo para mostrar os atores secundarios
    public void mostraAtores(){
        for (int i = 0; i < this.filmes.size(); i++) {
            
        }
    }
}
