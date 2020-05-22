package com.mycompany.projeto2;

import java.util.ArrayList;


public class Filmes extends Edicao{

    //variaveis de instancia
    private String nomeFilme; 
    private String genero;
    private String realizador;
    
    //array para atores e atrizes
    private ArrayList<Atores> atores;
    private ArrayList<Atriz> atriz;
    //array para atores e atrizes principais
    private ArrayList<Atores> atoresPrincipais;
    private ArrayList<Atriz> atrizesPrincipais;
    
    //construtores para Filmes
    public Filmes(){
        nomeFilme = "";
        genero = "";
        realizador = "";
        atores = new ArrayList<Atores>();
        atriz = new ArrayList<Atriz>();
        atoresPrincipais = new ArrayList<Atores>();
        atrizesPrincipais = new ArrayList<Atriz>();
     }
    
    public Filmes(String nomeFilme, String genero,String realizador){
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.realizador = realizador;
        atores = new ArrayList<Atores>();
        atriz = new ArrayList<Atriz>();
        atoresPrincipais = new ArrayList<Atores>();
        atrizesPrincipais = new ArrayList<Atriz>();
    }

    
    //metodos modificadores e seletores de Filmes
    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    
    public String getRealizador() {
        return realizador;
    }


    public ArrayList<Atriz> getAtriz(){
        return atriz;
    }
    
    public void setAtriz(ArrayList<Atriz> atriz){
        this.atriz = atriz;
    }
    

    public ArrayList<Atores> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<Atores> atores) {
        this.atores = atores;
    }
    
    //adiciona atores 
    public void addAtores(Atores actor){
        atores.add(actor);
    }
    //adiciona atrizes
    public void addAtriz(Atriz actor){
        atriz.add(actor);
    }
    //adiciona atores/atrizes principais
    public void addPrincipalMale(Atores actor){
       atoresPrincipais.add(actor);
       getAtores().remove(actor);
   }
    public void addPrincipalFemale(Atriz actress){
       atrizesPrincipais.add(actress);
       getAtriz().remove(actress);
    }
   public ArrayList<Atores> getPrincipaisMale(){
       return atoresPrincipais;
   }
   public ArrayList<Atriz> getPrincipaisFemale(){
       return atrizesPrincipais;
   }

    //informação sobre os Filmes 
    public String toString(){
        String info; 
        //info = "----------------------";
        info = "\nNome do filme: " + nomeFilme + "\n"; 
        info += "Género do filme: " + genero + "\n";
        info += "Realizador: " + realizador + "\n";
        //mudar de "atores do filme" para "atores secundarios"
        info += "Atores secundarios " + atores + "\n" + atriz;
        info += "Ator principal:" + atoresPrincipais + "\nAtriz principal: " + atrizesPrincipais +"\n";
        return info;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setRealizador(String realizador) {
        this.realizador = realizador;
    }
    
    //funcao para verificar se este ator ja participa no filme
    public boolean atoresRepetidosNoFilme(Atores actor){
        //percorre o array dos atores do filme
        for(int i= 0; i< this.atores.size(); i++){
            if(this.getAtores().get(i).getNome().equals(actor.getNome()))
                return true;
        }
        return false;
    }
    //funcao para verificar se esta atriz ja participa no filme
    public boolean atrizesRepetidosNoFilme(Atriz atz){
        //percorre o array das atrizes do filme
        for(int i= 0; i< this.getAtriz().size(); i++){
            if(this.getAtriz().get(i).getNome().equals(atz.getNome()))
                return true;
        }
        return false;
    }
    

          
}
