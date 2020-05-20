/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author joaomartins
 */
public class Festival {
    //array para as edições 
    private ArrayList<Edicao> e;
    private ArrayList<FilmesAtores> filmesDosAtores;
    private ArrayList<String> categorias;
    private ArrayList<String> filmesDoFestival;
    private ArrayList<Atores> atoresPrincipais;
    private ArrayList<String> realizadoresFestival;
    private ArrayList<Atriz> atrizesPrincipais;
    private ArrayList<Atores> actors;
    private ArrayList<Atriz> actress;
    
    private ArrayList<String> atoresPremioCarreira;
    private ArrayList<String> atrizesPremioCarreira;
    private ArrayList<String> premioCarreira;
    
    
    private ArrayList<Atores> quatroAtores;
    private ArrayList<Atriz> quatroAtrizes;
    private ArrayList<String> quatroFilmes;
    private ArrayList<String> quatroAtoresPrincipais;
    private ArrayList<String> quatroAtrizesPrincipais;
    
    public Festival(){
        e = new ArrayList<Edicao>();
        filmesDosAtores = new ArrayList<FilmesAtores>();
        
    }

    //metodo para adicionar filmes a uma edicao 
    public void addEdicoes(Edicao edicao){
        e.add(edicao);
    }
    
    //metodo modificador para as edições 
    public ArrayList<Edicao> getE() {
        return e;
    }
    
    
    /**
     * verifica se ja contem um edição criada
     * pelo numero de edição
     */
    public boolean contemEdicao(Edicao edi){
        for(int i=0;i < this.e.size(); i++){                                 
        //percorre o array das edições 
            if(this.getE().get(i).getNumEdicao()==(edi.getNumEdicao())){     
            //compara o numero edição que encontrou no array com o da edição inserida
                return true;                                                    
                //caso encontre devolve true, ou seja, já existe essa edição criada
            }
        }
        return false;
    }
    
    //adiciona uma instancia de filmes atores 
    public void addFilmesAtores(FilmesAtores fa){
        getFilmesDosAtores().add(fa);
    }

    public ArrayList<FilmesAtores> getFilmesDosAtores() {
        return filmesDosAtores;
    }
    
    public boolean atorExistente(String nome){
        //percorre o array onde tem os atores e os filmes em que participam
        for(int i=0;i < this.getFilmesDosAtores().size();i++){
            //caso se este ator ja esta em algum filme
            if(this.getFilmesDosAtores().get(i).getName().equals(nome)){
                return true;
            }
        }
        return false;
    }
    
    public int posicaoAtorExistente(String nome){
        //percorre o array onde tem os atores e os filmes em que participam
        for(int i=0; i < this.getFilmesDosAtores().size();i++){
            //quando encontra o ator, devolve a sua posiçao no array
            if(this.getFilmesDosAtores().get(i).getName().equals(nome)){
                return i;
            }
        }
        return 50;
    }
    
    //QUAL O PREMIO EM QUE ENVOLVE AS CATEGORIAS, MELHOR FILME DA CATEGORIA?
    //funcao para guardar todos os generos de filme, depois sera usada para a pontuaçao
    public void categoriasFestival(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                categorias.add(filme.getGenero());
            }
        }
    }
    //funcao para colocar todos os filmes do festival num array, sera utilizada para atribuir premios
    public void filmesFestival(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                getFilmesDoFestival().add(filme.getNomeFilme());
            }
        }
    }
    
    //funcao para guardar todos os realizadores participantes no festival num array
    public void realizadoresFestival(){
         //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                getRealizadoresFestival().add(filme.getRealizador());
            }
        }
    }
    
    //funcao para colocar todos os atores principais num array, sera usada para atribuir premios
    //a funcao guarda tambem os anos de carreira, o que sera util para o premio de carreira
    public void atoresPrincipais(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //acede ao array dos atores Principais do filme
                for(int k=0; k < filme.getPrincipaisMale().size();k++){
                    Atores actPrincipal = filme.getPrincipaisMale().get(k);
                    getAtoresPrincipais().add(actPrincipal);
                    //guarda esse ator para o premio carreira caso tenha mais de 20 anos de carreira
                    if(actPrincipal.getAnosCarreira()>20){
                        //caso ainda nao tenha esse ator 
                        if(!getAtoresPremioCarreira().contains(actPrincipal.getNome())){
                            //entao adiciona o
                            getAtoresPremioCarreira().add(actPrincipal.getNome());
                        }    
                    }
                }
            }
        }
    }
    //guarda todos os atores 
    public void atores(){
        //percorre as edições
        int numEdicoes = this.getE().size();
        for (int i = 0; i < numEdicoes; i++) {
            //percorre os filmes da edição
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for (int j = 0; j < numeroFilmesNaEdicao; j++) {
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //percorre o array dos atores do filme
                for (int k = 0; k < filme.getAtores().size(); k++) {
                    Atores actor = filme.getAtores().get(k);
                    getActors().add(actor);
                    //guarda esse ator para o premio carreira caso tenha mais de 20 anos de carreira
                    if(actor.getAnosCarreira()>20){
                        //caso ainda não tenha essa ator
                        if(!getAtoresPremioCarreira().contains(actor.getNome())){
                            //adiciona o
                            getAtoresPremioCarreira().add(actor.getNome()); 
                        }
                        
                    }
                    
                }
                
            }
        }
    }
    
    public void atrizesPrincipais(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //acede ao array dos atores Principais do filme
                for(int k=0; k < filme.getPrincipaisMale().size();k++){
                    Atriz actressPrincipal = filme.getPrincipaisFemale().get(k);
                    getAtrizesPrincipais().add(actressPrincipal);
                    //guarda essa atriz para o premio carreira caso tenha mais de 20 anos de carreira
                    if(actressPrincipal.getAnosCarreira()>20){
                        //caso ainda nao tenha essa atriz 
                        if(!getAtrizesPremioCarreira().contains(actressPrincipal.getNome())){
                            //adiciona a 
                            getAtrizesPremioCarreira().add(actressPrincipal.getNome());
                        }
                    }
                }
            }
        }
    }
    
    //guarda todos os atores 
    public void atrizes(){
        //percorre as edições
        int numEdicoes = this.getE().size();
        for (int i = 0; i < numEdicoes; i++) {
            //percorre os filmes da edição
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for (int j = 0; j < numeroFilmesNaEdicao; j++) {
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //percorre o array dos atores do filme
                for (int k = 0; k < filme.getAtores().size(); k++) {
                    Atriz actriz = filme.getAtriz().get(k);
                    getActress().add(actriz);
                    //guarda essa atriz para o premio carreira caso tenha mais de 20 anos de carreira      
                    if(actriz.getAnosCarreira()>20){
                        //caso ainda nao tenha essa atriz 
                        if(!getAtrizesPremioCarreira().contains(actriz.getNome())){
                            //adiciona a 
                            getAtrizesPremioCarreira().add(actriz.getNome());
                        }
                        
                    }
                    
                }
                
            }
        }
    }
    
    /**
     * ---------------------------------Candidatos aos premios---------------------------------------------
     * Escolhe 4 de categoria!
     */
    //escolhe os quatro filmes 
    public void candidatosFilmes(){
        int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(candidatos != 4){
            //percorre o array onde está guardado os filmes a premiar
            for (int i = 0; i < filmesDoFestival.size(); i++) {
                Random random = new Random();
                // obter um numero aleatorio para obter um filme aletorio
                int numero = random.nextInt(filmesDoFestival.size());
                //obtem o filme de escolha aleatória
                String filmeEscolhidoPremio = filmesDoFestival.get(numero);
                //se o array ainda nao contem esse filme
                if(!quatroFilmes.contains(filmeEscolhidoPremio)){
                    //adiciona ao array que vai guardar os 4 filmes a ser premiados
                    getQuatroFilmes().add(filmeEscolhidoPremio);
                    candidatos++;
                }
            }
        }
    }
    //escolhe os quatro atores
    public void candidatosAtor(){
        int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(candidatos != 4){
            //percorre o array onde está guardado os candidatos a premiar
            for (int i = 0; i < actors.size(); i++) {
                Random random = new Random();
                //obter um numero aleatorio para obter um candidato aletorio
                int numero = random.nextInt(actors.size());
                //obtem o candidato de escolha aleatória
                Atores atoresEscolhidoACandidato = actors.get(numero);
                //se o array ainda nao contem esse filme
                if(!quatroAtores.contains(atoresEscolhidoACandidato)){
                    //adiciona ao array que vai guardar os candidatos a ser premiados
                    getQuatroAtores().add(atoresEscolhidoACandidato);
                    candidatos++;
                }
            }
        }
        
    }
    
    //escolhe as  quatro atrizes
    public void candidatosAtriz(){
        int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(candidatos != 4){
            //percorre o array onde está guardado os candidatos a premiar
            for (int i = 0; i < actress.size(); i++) {
                Random random = new Random();
                //obter um numero aleatorio para obter um candidato aletorio
                int numero = random.nextInt(actress.size());
                //obtem o candidato de escolha aleatória
                Atriz atrizEscolhidaCandidato = actress.get(numero);
                //se o array ainda nao contem esse filme
                if(!quatroAtrizes.contains(atrizEscolhidaCandidato)){
                    //adiciona ao array que vai guardar os candidatos a ser premiados
                    getQuatroAtrizes().add(atrizEscolhidaCandidato);
                    candidatos++;
                }
            } 
        }
        
    }
    
    //escolhe as  quatro atrizes
    public void candidatosAtrizPrincipal(){
        int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(candidatos != 4){
            //percorre o array onde está guardado os candidatos a premiar
            for (int i = 0; i < getAtrizesPrincipais().size(); i++) {
                Random random = new Random();
                //obter um numero aleatorio para obter um candidato aletorio
                int numero = random.nextInt(getAtrizesPrincipais().size());
                //obtem o candidato de escolha aleatória
                String atrizPrincipalEscolhida = getAtrizesPrincipais().get(numero).getNome();
                //se o array ainda nao contem esse filme
                if(!quatroAtrizesPrincipais.contains(atrizPrincipalEscolhida)){
                    //adiciona ao array que vai guardar os candidatos a ser premiados
                    getQuatroAtrizesPrincipais().add(atrizPrincipalEscolhida);
                    candidatos++;
                }
            } 
        }  
    }
    
    
    
    public void candidatosPremioCarreira(){
        //É preciso concatenar os arrays pois os atores e atrizes estao separados 
        //concatenar os arrays dos premios
        //para ser escolhido 4 atores(tanto ator como atriz)
        premioCarreira.addAll(atoresPremioCarreira);
        premioCarreira.addAll(atrizesPremioCarreira);
        int candidato = 0; 
        if(candidato != 4){
            //percorre o array onde esta os atores para o premio carreira
            for (int i = 0; i < premioCarreira.size(); i++) {
                Random aleatorio = new Random();
                //obter um numero aleatorio para obter um candidato aleatorio 
                int numero = aleatorio.nextInt(premioCarreira.size());
                //obtem o candidato aleatorio 
                String candidatoCarreiraEscolhido = premioCarreira.get(numero);
                if(!premioCarreira.contains(candidatoCarreiraEscolhido)){
                    premioCarreira.add(candidatoCarreiraEscolhido);
                    candidato++;
                }
            }
        }
    }
    
        
    
    
    
     
    //metodos seletores para os arrays que serao chamados para os premios
    public ArrayList<String> getFilmesDoFestival() {
        return filmesDoFestival;
    }

    public ArrayList<String> getRealizadoresFestival() {
        return realizadoresFestival;
    }

    public ArrayList<Atores> getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public ArrayList<Atriz> getAtrizesPrincipais() {
        return atrizesPrincipais;
    }

    public ArrayList<Atores> getActors() {
        return actors;
    }

    public ArrayList<Atriz> getActress() {
        return actress;
    }



    public ArrayList<String> getQuatroFilmes() {
        return quatroFilmes;
    }

    public ArrayList<Atriz> getQuatroAtrizes() {
        return quatroAtrizes;
    }

    public ArrayList<String> getAtoresPremioCarreira() {
        return atoresPremioCarreira;
    }

    public ArrayList<String> getAtrizesPremioCarreira() {
        return atrizesPremioCarreira;
    }

    public ArrayList<String> getPremioCarreira() {
        return premioCarreira;
    }

    public ArrayList<Atores> getQuatroAtores() {
        return quatroAtores;
    }

    public ArrayList<String> getQuatroAtoresPrincipais() {
        return quatroAtoresPrincipais;
    }

    public ArrayList<String> getQuatroAtrizesPrincipais() {
        return quatroAtrizesPrincipais;
    }



    
}
