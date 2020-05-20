/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;

import java.util.ArrayList;

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
        for(int i=0;i < this.e.size(); i++){                                 //percorre o array das edições 
            if(this.getE().get(i).getNumEdicao()==(edi.getNumEdicao())){     //compara o numero edição que encontrou no array com o da edição inserida
                return true;                                                 //caso encontre devolve true, ou seja, já existe essa edição criada
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
                filmesDoFestival.add(filme.getNomeFilme());
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
                realizadoresFestival.add(filme.getRealizador());
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
                    atoresPrincipais.add(actPrincipal);
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
                    atrizesPrincipais.add(actressPrincipal);
                }
            }
        }
    }
}
