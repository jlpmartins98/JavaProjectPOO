package com.mycompany.projeto2;



public class Atores extends Filmes{
    
    //variaveis de instancia 
    private String nome;
    private int anosCarreira; 
    
    //Construtores para os atores 
    public Atores(){ 
        nome = "";
        anosCarreira = 0; 
    }
    
    public Atores(String nome, int anosCarreira){
        this.nome = nome;
        this.anosCarreira = anosCarreira;
    }
    
    //set e get para atores
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
    
    //informação dos atores 
    public String toString(){
        String info;
        //info = super.toString();
        info = "Nome do ator: " + nome + "\n";
        info += "Anos de carreira: " + anosCarreira + "\n";
        return info;
    }
}
