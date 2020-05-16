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
    
    public Festival(){
        e = new ArrayList<Edicao>();
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

}
