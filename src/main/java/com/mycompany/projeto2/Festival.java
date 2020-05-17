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
    private ArrayList<FilmesAtrizes> filmesDasAtrizes;
    
    public Festival(){
        e = new ArrayList<Edicao>();
        filmesDosAtores = new ArrayList<FilmesAtores>();
        filmesDasAtrizes = new ArrayList<FilmesAtrizes>();
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
    
    //adiciona uma instancia de filmes atrizes 
    public void addFilmesAtrizes(FilmesAtrizes faz){
        getFilmesDasAtrizes().add(faz);
    }

    public ArrayList<FilmesAtrizes> getFilmesDasAtrizes() {
        return filmesDasAtrizes;
    }

}
