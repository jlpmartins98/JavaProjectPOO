package com.mycompany.projeto2;

public class Winners {
  
    //variáveis de instância
    private String nome;
    private int pontuacao;
    
    
    //construtores para os vencedores e candidatos a cada premio
    public Winners(){
        nome = "";
        pontuacao = 0;

    }
    
    public Winners(String nome,int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    
    //metodo seletor para o winner
    public int getPontuacao() {
        return pontuacao;
    }
    
    //informação do vencedor/candidatos ao premio 
    public String toString(){
        String info;
        info = "Nome: " + this.nome;
        info += "  Pontuação: " + this.pontuacao;
        return info;
    }

    
}
