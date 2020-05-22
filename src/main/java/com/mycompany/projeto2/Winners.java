/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.function.ToDoubleFunction;
/**
 *
 * @author Rodrigo
 */

    //vai ser preciso uma funçao que cria um ciclo para atribuir pontuaçoes
    //esta funcao tera um random q é o numero de peritos, e as pontuaçoes serao de 0 a (random*10)+1
    //cada vez que uma pontuaçao é gerada esta é atribuida a posiçao i do array, começando pelo primeiro ator, na posiçao 0
    //o numero de peritos so afeta o quao alta a  pontuaçao pode ser, mas sao sempre geradas apenas 4 pontuaçoes pois so temos quatro finalistas por premio
    //no fim o vencedor com a pontuaçao mais alta ganha o premio
    
    //sera preciso uma funçao para percorrer o array das pontuaçoes, e devolver a posiçao da pontuaçao mais alta
    //atençao que cada posiçao no array das pontuaçoes corresponde a pontuaçao do finalista na mesma posiçao (a pontuaçao na posiçao 0, é a pontuaçao do filme na posiçao 0 do array dos filmes finalistas)
    //iremos voltar a gerar o array das pontuaçoes sempre que quisermos escolher um vencedor, logo devemos ter uma funçao para dar reset ao array

public class Winners {
  
    
    private String nome;
    private int pontuacao;
    
    
    //Existe alguma maneira de fazer com q este random so possa ir ate o numeroPeritos*10?
    //gera um random para a pontuacao de 0 a 101
    
    
    //construtores para os vencedores
    public Winners(){
        nome = "";
        pontuacao = 0;

    }
    
    public Winners(String nome,int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public String toString(){
        String info;
        info = "Nome: " + this.nome;
        info += "  Pontuação: " + this.pontuacao;
        return info;
    }

    
}
