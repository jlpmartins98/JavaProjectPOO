/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author joaomartins
 */
public class Festival {
    private ArrayList<Winners> pontuacoesPremioCarreira;
    private ArrayList<Winners> pontuacoesPremioAtorSecundario;
    private ArrayList<Winners> pontuacoesPremioAtorPrincipal;
    private ArrayList<Winners> pontuacoesPremioAtrizSecundaria;
    private ArrayList<Winners> pontuacoesPremioAtrizPrincipal;
    private ArrayList<Winners> pontuacoesPremioFilme;
    private ArrayList<Winners> pontuacoesPremioRealizador;
    
    private String nome;
    private int pontuacao;
    
    Random random = new Random();
    //Existe alguma maneira de fazer com q este random so possa ir ate o numeroPeritos*10?
    //gera um random para a pontuacao de 0 a 101
    int  numeroPeritos = random.nextInt(10) + 1;

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
    
    //private ArrayList<String> atoresPremioCarreira;
    //private ArrayList<String> atrizesPremioCarreira;
    private ArrayList<String> candidatosPremioCarreira;
    private ArrayList<String> finalistasPremioCarreira;
    
    private ArrayList<Atores> quatroAtores;
    private ArrayList<Atriz> quatroAtrizes;
    private ArrayList<String> quatroFilmes;
    private ArrayList<String> quatroAtoresPrincipais;
    private ArrayList<String> quatroAtrizesPrincipais;
    private ArrayList<String> quatroRealizadores;
    
    public Festival(){
        e = new ArrayList<Edicao>();
        filmesDosAtores = new ArrayList<FilmesAtores>();
        categorias = new ArrayList<String>();
        realizadoresFestival = new ArrayList<String>();
        atoresPrincipais = new ArrayList<Atores>();
        atrizesPrincipais = new ArrayList<Atriz>();
        filmesDoFestival = new ArrayList<String>();
        actors = new ArrayList<Atores>();
        actress = new ArrayList<Atriz>();
        //atoresPremioCarreira = new ArrayList<String>();
        //atrizesPremioCarreira = new ArrayList<String>();
        candidatosPremioCarreira = new ArrayList<String>();
        finalistasPremioCarreira = new ArrayList<String>();
        quatroAtores = new ArrayList<Atores>();
        quatroAtrizes = new ArrayList<Atriz>();
        quatroFilmes = new ArrayList<String>();
        quatroAtoresPrincipais = new ArrayList<String>();
        quatroAtrizesPrincipais = new ArrayList<String>();
        
        pontuacoesPremioCarreira = new ArrayList<Winners>();
        pontuacoesPremioAtorSecundario = new ArrayList<Winners>();
        pontuacoesPremioAtorPrincipal = new ArrayList<Winners>();
        pontuacoesPremioAtrizPrincipal = new ArrayList<Winners>();
        pontuacoesPremioAtrizSecundaria = new ArrayList<Winners>();
        pontuacoesPremioFilme = new ArrayList<Winners>();
        pontuacoesPremioRealizador = new ArrayList<Winners>();
    
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
    
    //funcao para verificar se o ator ja participa em algum filme
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
    
    /**
     * esta funcao é usada para criar o array dos atores e os filmes em que participam
     * usamos esta funcao quando sabemos que o ator ja participou num filme e queremos
     * adicionar outro filme ao seu array de filmes em que participou
    */
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
    
    
    //funcao para guardar todos os generos de filme, depois sera usada para a pontuaçao
    public void categoriasFestival(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                if(getRealizadoresFestival().size() > 0){
                    if(!getRealizadoresFestival().contains(filme.getGenero())){
                        categorias.add(filme.getGenero());
                    }
                }
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
                if(!getFilmesDoFestival().contains(filme.getNomeFilme()))
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
                if(!getRealizadoresFestival().contains(filme.getRealizador()))
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
                    if(!getAtoresPrincipais().contains(actPrincipal)){
                        getAtoresPrincipais().add(actPrincipal);
                        //guarda esse ator para o premio carreira caso tenha mais de 20 anos de carreira
                        if(actPrincipal.getAnosCarreira()>20){
                            //caso ainda nao tenha esse ator 
                            if(!getCandidatosPremioCarreira().contains(actPrincipal.getNome())){
                                //entao adiciona o
                                getCandidatosPremioCarreira().add(actPrincipal.getNome());
                            }    
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
                    if(!getActors().contains(actor)){
                        getActors().add(actor);
                        //guarda esse ator para o premio carreira caso tenha mais de 20 anos de carreira
                        if(actor.getAnosCarreira()>20){
                            //caso ainda não tenha essa ator
                            if(!getCandidatosPremioCarreira().contains(actor.getNome())){
                                //adiciona o
                                getCandidatosPremioCarreira().add(actor.getNome()); 
                            }

                        }
                    }
                    
                }
                
            }
        }
    }
    //guarda todas as atrizesPrincipais
    public void atrizesPrincipais(){
        //percorre as ediçoes
        int numeroEdicoes = this.getE().size();
        for(int i = 0; i < numeroEdicoes; i++){
            //pecorre os filmes da ediçao
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for(int j = 0; j < numeroFilmesNaEdicao; j++){
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //acede ao array dos atores Principais do filme
                for(int k=0; k < filme.getPrincipaisFemale().size();k++){
                    Atriz actressPrincipal = filme.getPrincipaisFemale().get(k);
                    if(!getAtrizesPrincipais().contains(actressPrincipal)){
                        getAtrizesPrincipais().add(actressPrincipal);
                        //guarda essa atriz para o premio carreira caso tenha mais de 20 anos de carreira
                        if(actressPrincipal.getAnosCarreira()>20){
                            //caso ainda nao tenha essa atriz 
                            if(!getCandidatosPremioCarreira().contains(actressPrincipal.getNome())){
                                //adiciona a 
                                getCandidatosPremioCarreira().add(actressPrincipal.getNome());
                            }
                        }
                    }
                }
            }
        }
    }
    
    //guarda todos as atrizes 
    public void atrizes(){
        //percorre as edições
        int numEdicoes = this.getE().size();
        for (int i = 0; i < numEdicoes; i++) {
            //percorre os filmes da edição
            int numeroFilmesNaEdicao = this.getE().get(i).getFilmes().size();
            for (int j = 0; j < numeroFilmesNaEdicao; j++) {
                Filmes filme = this.getE().get(i).getFilmes().get(j);
                //percorre o array dos atores do filme
                for (int k = 0; k < filme.getAtriz().size(); k++) {
                    Atriz actriz = filme.getAtriz().get(k);
                    if(!getActress().contains(actriz)){
                        getActress().add(actriz);
                        //guarda essa atriz para o premio carreira caso tenha mais de 20 anos de carreira      
                        if(actriz.getAnosCarreira()>20){
                            //caso ainda nao tenha essa atriz 
                            if(!getCandidatosPremioCarreira().contains(actriz.getNome())){
                                //adiciona a 
                                getCandidatosPremioCarreira().add(actriz.getNome());
                            }

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
        //int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(getQuatroFilmes().size() <= 4){
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
                    //candidatos++;
                }
            }
        }
    }
    //escolhe os quatro atores
    public void candidatosAtor(){
        //int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(getQuatroAtores().size() <= 4){
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
                    //candidatos++;
                }
            }
        }
        
    }
    
    //escolhe as  quatro atrizes
    public void candidatosAtriz(){
        //int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(getQuatroAtrizes().size() <= 4){
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
                   // candidatos++;
                }
            } 
        }
        
    }
    
    //escolhe as  quatro 
    public void candidatosAtorPrincipal(){
        //int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(getQuatroAtoresPrincipais().size() <= 4){
            //percorre o array onde está guardado os candidatos a premiar
            for (int i = 0; i < getAtoresPrincipais().size(); i++) {
                Random random = new Random();
                //obter um numero aleatorio para obter um candidato aletorio
                int numero = random.nextInt(getAtoresPrincipais().size());
                //obtem o candidato de escolha aleatória
                String atorPrincipalEscolhida = getAtoresPrincipais().get(numero).getNome();
                //se o array ainda nao contem esse filme
                if(!getQuatroAtoresPrincipais().contains(atorPrincipalEscolhida)){
                    //adiciona ao array que vai guardar os candidatos a ser premiados
                    getQuatroAtoresPrincipais().add(atorPrincipalEscolhida);
                    //candidatos++;
                }
            } 
        }  
    }
    
        //escolhe as  quatro atrizes
    public void candidatosAtrizPrincipal(){
        //int candidatos = 0;
        //enquanto nao tiver os 4 candidatos
        if(getQuatroAtrizesPrincipais().size() <= 4){
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
                    //candidatos++;
                }
            } 
        }  
    }
    
    
    //escolher os quatro realizadores 
    public void candidatosRealizador(){
        //enquanto nao tiver os 4 realizadores
        if(getQuatroRealizadores().size() <= 4){
            //percorre o array onde está guardado os candidatos a realizador 
            for (int i = 0; i < getRealizadoresFestival().size(); i++) {
                Random random = new Random();
                //obtem um numero aleatorio para obter um candidato aleatorio
                int numero = random.nextInt(getRealizadoresFestival().size());
                //otem o candidato de escolha aleatória 
                String realizadorEscolhido = getRealizadoresFestival().get(numero);
                //caso ainda nao contenha esse realizador 
                if(!quatroRealizadores.contains(realizadorEscolhido)){
                    //adiciona o 
                    quatroRealizadores.add(realizadorEscolhido);
                }
                
            }
        }
    }
   
        
    
    
    
    public void candidatosPremioCarreira(){
        //É preciso concatenar os arrays pois os atores e atrizes estao separados 
        //concatenar os arrays dos premios
        //para ser escolhido 4 atores(tanto ator como atriz)
        //candidatosPremioCarreira.addAll(atoresPremioCarreira);
        //candidatosPremioCarreira.addAll(atrizesPremioCarreira);
        //int candidato = 0; 
        if(getFinalistasPremioCarreira().size() <= 4){
            
            //percorre o array onde esta os atores para o premio carreira
            for (int i = 0; i < candidatosPremioCarreira.size(); i++) {
                Random aleatorio = new Random();
                //obter um numero aleatorio para obter um candidato aleatorio 
                int numero = aleatorio.nextInt(candidatosPremioCarreira.size());
                //obtem o candidato aleatorio 
                String candidatoCarreiraEscolhido = candidatosPremioCarreira.get(numero);
                //if(!candidatosPremioCarreira.contains(candidatoCarreiraEscolhido)){
                  //  candidatosPremioCarreira.add(candidatoCarreiraEscolhido);
                    //candidato++;
                if(!getFinalistasPremioCarreira().contains(candidatoCarreiraEscolhido)){
                    getFinalistasPremioCarreira().add(candidatoCarreiraEscolhido);
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

   // public ArrayList<String> getAtoresPremioCarreira() {
     //   return atoresPremioCarreira;
    //}

    //public ArrayList<String> getAtrizesPremioCarreira() {
    //    return atrizesPremioCarreira;
    //}

    public ArrayList<String> getCandidatosPremioCarreira() {
        return candidatosPremioCarreira;
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

    public ArrayList<String> getFinalistasPremioCarreira(){
        return finalistasPremioCarreira;
    }
    
    public ArrayList<String> getQuatroRealizadores(){
        return quatroRealizadores;
    }
    
    //------------------------------------------------------------------
    
      
    
    public void addPontuacoesPremioCarreira(Winners winner){
        pontuacoesPremioCarreira.add(winner);
    }
    
    public void atribuiPontuacoesPremioCarreira(){
        //ciclo para percorrer o array dos finalistasPremioCarreira
        for (int i = 0; i < getFinalistasPremioCarreira().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = getFinalistasPremioCarreira().get(i);
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);  
           addPontuacoesPremioCarreira(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtorSecundario(Winners winner){
        getPontuacoesPremioAtorSecundario().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtorSecundario(){
        //ciclo para percorrer o array dos atores secundarios escolhidos
        for (int i = 0; i < getQuatroAtores().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerAtorSecundario= getQuatroAtores().get(i).getNome();
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerAtorSecundario,pontuacaoFinal);  
           addPontuacoesPremioAtorSecundario(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtorPrincipal(Winners winner){
        this.getPontuacoesPremioAtorPrincipal().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtorPrincipal(){
        //ciclo para percorrer o array dos atores principais escolhidos
        for (int i = 0; i < getQuatroAtoresPrincipais().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = getQuatroAtoresPrincipais().get(i);
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtorPrincipal(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtrizSecundaria(Winners winner){
        this.getPontuacoesPremioAtrizSecundaria().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtrizSecundaria(){
        for (int i = 0; i < getQuatroAtrizes().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = getQuatroAtrizes().get(i).getNome();
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtrizSecundaria(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtrizPrincipal(Winners winner){
        this.getPontuacoesPremioAtrizPrincipal().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtrizPrincipal(){
        for (int i = 0; i < getQuatroAtrizesPrincipais().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = getQuatroAtrizesPrincipais().get(i);
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtrizPrincipal(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioFilmes(Winners winner){
        this.getPontuacoesPremioFilme().add(winner);
    }
    
    public void atribuiPontuacoesPremioFilmes(){
        for (int i = 0; i < getQuatroFilmes().size(); i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = getQuatroFilmes().get(i);
           int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioFilmes(winnerCarreira);
        }
    } 
    
    //adiciona pontuacao
    public void addPontuacoesPremioRealizador(Winners winner){
        this.getPontuacoesPremioRealizador().add(winner);
    }
    //atribui a pontucao
    public void atribuiPontuacoesRealizador(){
        //percorre o array que está os candidatos a melhor realizador 
        for (int i = 0; i < getQuatroRealizadores().size(); i++) {
            int pontuacaoTotal = random.nextInt(numeroPeritos*10);
            String nomeWinnerRealizador = getQuatroRealizadores().get(i);
            int pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
            //instancia um novo winner, que é realizador, com o nome e pontucao 
            Winners winnerRealizador= new Winners(nomeWinnerRealizador,pontuacaoFinal);
            this.addPontuacoesPremioRealizador(winnerRealizador);
        }
    }

    public ArrayList<Winners> getPontuacoesPremioAtorSecundario() {
        return pontuacoesPremioAtorSecundario;
    }

    public ArrayList<Winners> getPontuacoesPremioAtorPrincipal() {
        return pontuacoesPremioAtorPrincipal;
    }

    public ArrayList<Winners> getPontuacoesPremioAtrizSecundaria() {
        return pontuacoesPremioAtrizSecundaria;
    }

    public ArrayList<Winners> getPontuacoesPremioAtrizPrincipal() {
        return pontuacoesPremioAtrizPrincipal;
    }

    public ArrayList<Winners> getPontuacoesPremioFilme() {
        return pontuacoesPremioFilme;
    }
    public ArrayList<Winners> getPontuacoesPremioCarreira(){
        return pontuacoesPremioCarreira;
    }
    public ArrayList<Winners> getPontuacoesPremioRealizador(){
        return pontuacoesPremioRealizador;
    }

    
    public void ordenaPorPontuacao(ArrayList<Winners> finalistas){
        
        Collections.sort(finalistas,new Comparator<Winners>()
        {
           public int compare(Winners w1,Winners w2)
           {
               return Integer.valueOf(w2.getPontuacao()).compareTo(w1.getPontuacao());
           } 
        });
    }

  
}
