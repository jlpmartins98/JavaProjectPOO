
package com.mycompany.projeto2;

/**
 *
 * @author joaomartins
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class AtoresPrincipais extends Atores
{
    private int selector;
    private ArrayList<Atores> atoresPrincipais;
    private ArrayList<Atriz> atrizesPrincipais;
    //Criar um random number que acede ao array dos atores e escolhe um, para o ator principal, o mesmo para a atriz principal
    
    //Criar outro random number que escolhe o numero de atores secundarios e escolhe ao calhas de ambos os arrays, claro que nao pode ser o mesmo que o principal
    
   public AtoresPrincipais(){
   
       atoresPrincipais = new ArrayList<Atores>();
       atrizesPrincipais = new ArrayList<Atriz>();
       
   } 

}
