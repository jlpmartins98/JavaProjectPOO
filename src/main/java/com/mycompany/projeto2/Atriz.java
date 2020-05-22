package com.mycompany.projeto2;

public class Atriz extends Filmes{
    
    //variaveis de instancia 
    private String nome;
    private int anosCarreira; 
    
    //Construtores para as atrizes 
    public Atriz(){ 
        nome = "";
        anosCarreira = 0; 
    }
    
    public Atriz(String nome, int anosCarreira){
        this.nome = nome;
        this.anosCarreira = anosCarreira;
    }
    
    //set e get para atrizes
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnosCarreira() {
        return anosCarreira;
    }

    public void setAnosCarreira(int anosCarreira) {
        this.anosCarreira = anosCarreira;
    }
    
    //informação dos atrizes 
    public String toString(){
        String info;
        //info = super.toString();
        info = "Nome da atriz: " + nome + "\n";
        info += "Anos de carreira: " + anosCarreira + "\n";
        return info;
    }
}
