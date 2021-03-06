package com.mycompany.projeto2;

import java.util.ArrayList;


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
    
    //metodo para verificar se a ediçao ja contem o filme que qeremos adicionar
    public boolean contemFilme(Filmes movie){
        //percorre o array de filmes da ediçao
        for(int i=0;i < this.filmes.size(); i++){
            if(this.getFilmes().get(i).getNomeFilme().equals(movie.getNomeFilme())){
                return true;
            }
        }
        return false;
    }
    

    
    //verifica se o ator ja participou em dois filmes nesta ediçao
    public int maximoAtoresFilmes(Atores act){
        int contador = 0; 

               //percorre o array dos filmes 
            for (int i = 0; i < this.filmes.size(); i++) 
            {
                //percorre o array dos atores do filme na posiçao i
                for (int j = 0; j < this.getFilmes().get(i).getAtores().size(); j++)
                {
                    //caso ja tenha aparecido em dois filmes
                    if(contador == 2){
                        return contador;
                    }
                    //verifica se o ator ja apareceu em algum filme
                    else if(this.getFilmes().get(i).getAtores().get(j).getNome().equals(act.getNome())){
                        //caso tenha incrementa o contador    
                        contador++;
                        }
 
                }
            }
            return contador;
    }
    
    //verifica se a atriz ja participou em dois filmes nesta ediçao
    public int maximoAtrizesFilmes(Atriz act){
        int contador = 0; 

            //percorre o array dos filmes 
            for (int i = 0; i < this.filmes.size(); i++) 
            {
                //percorre o array das atrizes do filme na posiçao i
                for (int j = 0; j < this.getFilmes().get(i).getAtriz().size(); j++)
                {
                    //caso ja tenha aparecido em dois filmes
                    if(contador == 2){
                        return contador;
                    }
                    //verifica se a atriz ja apareceu em algum filme    
                    else if(this.getFilmes().get(i).getAtriz().get(j).getNome().equals(act.getNome())){
                        //caso tenha incrementa o contador    
                        contador++;
                        }
   
                }
            }
        return contador;
    }
    
    
    

}
