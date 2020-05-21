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
import java.util.Random;
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
    //array para guardar as pontuaçoes dos finalistas
    private ArrayList<Winners> pontuacoesPremioCarreira;
    private ArrayList<Winners> pontuacoesPremioAtorSecundario;
    private ArrayList<Winners> pontuacoesPremioAtorPrincipal;
    private ArrayList<Winners> pontuacoesPremioAtrizSecundaria;
    private ArrayList<Winners> pontuacoesPremioAtrizPrincipal;
    private ArrayList<Winners> pontuacoesPremioFilme;
    
    private String nome;
    private double pontuacao;
    
    Random random = new Random();
    //Existe alguma maneira de fazer com q este random so possa ir ate o numeroPeritos*10?
    //gera um random para a pontuacao de 0 a 101
    int  numeroPeritos = random.nextInt(10) + 1;
    Festival festival = new Festival();
    
    //construtores para os vencedores
    public Winners(){
        nome = "";
        pontuacao = 0.0;
        this.pontuacoesPremioCarreira = new ArrayList<Winners>();
        this.pontuacoesPremioAtorSecundario = new ArrayList<Winners>();
        this.pontuacoesPremioAtorPrincipal = new ArrayList<Winners>();
        this.pontuacoesPremioAtrizPrincipal = new ArrayList<Winners>();
        this.pontuacoesPremioAtrizSecundaria = new ArrayList<Winners>();
        this.pontuacoesPremioFilme = new ArrayList<Winners>();
    }
    
    public Winners(String nome,double pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.pontuacoesPremioCarreira = new ArrayList<Winners>();
        this.pontuacoesPremioAtorSecundario = new ArrayList<Winners>();
        this.pontuacoesPremioAtorPrincipal = new ArrayList<Winners>();
        this.pontuacoesPremioAtrizPrincipal = new ArrayList<Winners>();
        this.pontuacoesPremioAtrizSecundaria = new ArrayList<Winners>();
        this.pontuacoesPremioFilme = new ArrayList<Winners>();
    }
    
    
    
    
    
    public void addPontuacoesPremioCarreira(Winners winner){
        this.pontuacoesPremioCarreira.add(winner);
    }
    
    public void atribuiPontuacoesPremioCarreira(){
        //ciclo para percorrer o array dos finalistasPremioCarreira
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getFinalistasPremioCarreira().get(i);
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);  
           this.addPontuacoesPremioCarreira(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtorSecundario(Winners winner){
        this.getPontuacoesPremioAtorSecundario().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtorSecundario(){
        //ciclo para percorrer o array dos atores secundarios escolhidos
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getQuatroAtores().get(i).getNome();
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);  
           this.addPontuacoesPremioAtorSecundario(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtorPrincipal(Winners winner){
        this.getPontuacoesPremioAtorPrincipal().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtorPrincipal(){
        //ciclo para percorrer o array dos atores principais escolhidos
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getQuatroAtoresPrincipais().get(i);
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtorPrincipal(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtrizSecundaria(Winners winner){
        this.getPontuacoesPremioAtrizSecundaria().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtrizSecundaria(){
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getQuatroAtrizes().get(i).getNome();
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtorSecundario(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioAtrizPrincipal(Winners winner){
        this.getPontuacoesPremioAtrizPrincipal().add(winner);
    }
    
    public void atribuiPontuacoesPremioAtrizPrincipal(){
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getQuatroAtrizesPrincipais().get(i);
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtorSecundario(winnerCarreira);
        }
    }
    
    public void addPontuacoesPremioFilmes(Winners winner){
        this.getPontuacoesPremioFilme().add(winner);
    }
    
    public void atribuiPontuacoesPremioFilmes(){
        for (int i = 0; i < 4; i++) {
           int pontuacaoTotal = random.nextInt(numeroPeritos*10);
           String nomeWinnerCarreira = festival.getQuatroFilmes().get(i);
           double pontuacaoFinal = (pontuacaoTotal / numeroPeritos);
           Winners winnerCarreira = new Winners(nomeWinnerCarreira,pontuacaoFinal);
           this.addPontuacoesPremioAtorSecundario(winnerCarreira);
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
    public double getPontuacao() {
        return pontuacao;
    }
    public int compareTo(Winners winner) {
        double compareage =((Winners)winner).getPontuacao();
        /* For Ascending order*/
        return this.pontuacao-compareage;

        // For Descending order do like this /
        //return compareage-this.studentage;
    }
    
    public void ordenaPorPontuacao(ArrayList<Winners> finalistas){
        
    }
    
    
}
