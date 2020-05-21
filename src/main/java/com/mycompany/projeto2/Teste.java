package com.mycompany.projeto2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws IOException {
        int opcao;

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Edicao ed = new Edicao();
        Filmes f = new Filmes();
        Festival festival = new Festival();
        Winners winner = new Winners();
        
        //ciclo para apresentar menu 
        do {
            apresentarMenu();
            opcao = scan.nextInt();
            
            switch(opcao){
                case 1:
                    //Criar ediçao
                    
                    System.out.println("A criar uma nova edição");
                    System.out.println("Escreva o ano e o número da edição, separados por espaços");
                    Edicao ed1 = new Edicao(scan.nextInt(),scan.nextInt());
                    /*
                    if(festival.getE().contains(ed1)){
                        System.out.println("Essa edição já existe!");
                    }
                    else{
                        festival.addEdicoes(ed1);
                        System.out.println("Edição criada!");
                    }*/
                    if(festival.contemEdicao(ed1)){
                        System.out.println("Esse edição já existe!");
                    }
                    else{
                        festival.addEdicoes(ed1);
                        System.out.println("Edição criada!");
                    }
                    break;

                case 2:
                    //associar os filmes às ediçoes criadas 
                    System.out.println(festival.getE());                                                                                                   //mostra as edições
                    if(festival.getE().isEmpty()){                  //verifica se ja tem edições criadas para poder criar os filmes nas edições
                        System.out.println("Crie uma edição primeiro!");
                    }
                    else{
                        //----------escolher a edicao
                        System.out.println("Escolha a edição onde deseja colocar o filme, introduzindo a posição desejada, começando por 0");
                        int ediEscolhida = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                        ed = festival.getE().get(ediEscolhida);                                                                                                 //obtem a edição, que está no array 
                        System.out.println(ed);                                                                                                                 //mostra a edição escolhida
                        //-----------criar Filmes 
                        System.out.println("Criar Filmes");
                        System.out.println("Digite o nome do filme que pretende inserir na edição escolhida,na linha abaixo o género e na proxima linha abaixo o realizador");
                        //ed.addFilmes(new Filmes(br.readLine(),br.readLine(),br.readLine()));                                                                    //Cria um filme e adiciona o filme à edição 
                        Filmes f1 = new Filmes(br.readLine(),br.readLine(),br.readLine());
                        //boolean variavel = ed.contemFilme(f1);
                        if(ed.contemFilme(f1)){
                            System.out.println("Este filme já existe!");
                        }
                        else{
                            ed.addFilmes(f1);
                            System.out.println(ed.getFilmes());                                                                                                     //mostra os filmes 
                            System.out.println("Filme criado!");                      
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    //caso de criar atores, temos de escolher primeiro a ediçao e de seguida o filme
                    System.out.println(festival.getE());
                    //caso nao tenha ediçoes
                    if(festival.getE().isEmpty()){
                        System.out.println("Crie uma edição primeiro");
                    }
                    //caso tenha pelo menos uma ediçao
                    else{
                        System.out.println("Acedendo as edições e aos filme da edição escolhida, para introduzir o ator");
                        System.out.println("Escolha a edição, introduzindo a posição desejada, começando por 0");
                        int ediEscolhida2 = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                        ed = festival.getE().get(ediEscolhida2);        //obtem a edição 
                        System.out.println(ed.getFilmes());
                        //caso essa ediçao nao tenha filmes
                        if(ed.getFilmes().isEmpty()){
                            System.out.println("Crie primeiro um filme!");
                        }
                        //caso a ediçao tenha pelo menos um filme
                        else{
                            System.out.println("Escolha o filme onde deseja colocar o ator, introduzindo a posição desejada, começando por 0");         
                            int filmeEscolha = scan.nextInt();                                                                                                      
                            f = ed.getFilmes().get(filmeEscolha);
                            System.out.println(f);
                            //Criar atores
                            System.out.println("A criar atores");
                            System.out.println("Introduza o nome do ator,e na linha abaixo introduza os seus anos de carreira");
                            //f.addAtores(new Atores(br.readLine(),scan.nextInt()));
                            Atores a = new Atores(br.readLine(),scan.nextInt());

                            boolean var = ed.maximoAtoresFilmes(a);
                            //caso o ator ja tenha participado em dois filmes nesta ediçao
                            if(var)
                                System.out.println("Este ator ja participou em dois filmes nesta edicao");
                            else{
                                //caso este ator ja esteja neste filme 
                                if(f.atoresRepetidosNoFilme(a))
                                    System.out.println("Esse ator já existe neste filme!");
                                else{
                                    f.addAtores(a);
                                    System.out.println("Atores neste filme: " + f.getAtores());
                                    //verifica se o ator ja participa em algum filme
                                    if(festival.atorExistente(a.getNome())){
                                        //caso o ator ja participe em algum filme, apenas adicionamos este filme ao seu array de filmes 
                                        int variavel500 = festival.posicaoAtorExistente(a.getNome());
                                        festival.getFilmesDosAtores().get(variavel500).addNomeFilme(f.getNomeFilme());
                                    }
                                    //caso esse ator nao participe em nenhum filme nesta ediçao
                                    else{
                                        FilmesAtores fa = new FilmesAtores(a.getNome());
                                        fa.addNomeFilme(f.getNomeFilme());
                                        festival.addFilmesAtores(fa);
                                    }
                                }
                            }
                        }
                    }  
                    System.out.println();
                    break;
                    //mudar o codigo para ficar como o dos atores, ou seja adicionar os casos e as exepçoes
                case 4:
                    System.out.println(festival.getE());                                                                                                  //mostra as edições
                    System.out.println("Aceder as edições e ao filme da edição escolhida, para introduzir a atriz");
                    System.out.println("Escolha a edição, introduzindo a posição desejada, começando por 0");
                    int ediEscolhida3 = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                    ed = festival.getE().get(ediEscolhida3);        //obtem a edição 
                    System.out.println(ed.getFilmes());                                                                                                     
                    System.out.println("Escolha o filme onde deseja colocar a atriz, introduzindo a posição desejada, começando por 0");         
                    int filmeEscolha2 = scan.nextInt();                                                                                                      
                    f = ed.getFilmes().get(filmeEscolha2);
                    System.out.println(f);
                    System.out.println("A criar atrizes");
                    System.out.println("Introduza o nome da atriz e na linha abaixo introduza os seus anos de carreira");
                    Atriz atz = new Atriz(br.readLine(),scan.nextInt());
                    boolean variavel = ed.maximoAtrizesFilmes(atz);
                    if(variavel)
                        System.out.println("Esta atriz ja participou em dois filmes nesta edicao");
                    //verifica se há atrizes repetidas num filme
                    else{
                        if(f.atrizesRepetidosNoFilme(atz))
                            System.out.println("Esta atriz já existe neste filme!");
                        
                        else{
                            f.addAtriz(atz);
                            System.out.println("Atrizes neste filme: " + f.getAtriz());
                            //adiciona o nome do filme que o ator participa
                            //criar uma condiçao para verificar se a atriz ja esta noutro filme, caso esteja
                            //percorrer o array dos filmes atrizes, e adicionar o nome do filme ao seu array de filmes
                            FilmesAtores fa2 = new FilmesAtores(atz.getNome());
                            fa2.addNomeFilme(f.getNomeFilme());
                            festival.addFilmesAtores(fa2);
                        }
                    }
                    System.out.println(); 
                    break;
                case 5:
                    //para atribuir um papel principal, temos de escolher primeiro a ediçao e de seguida o filme
                    System.out.println(festival.getE());
                    //caso nao tenha ediçoes
                    if(festival.getE().isEmpty()){
                        System.out.println("Crie uma edição primeiro");
                    }
                    //caso tenha pelo menos uma ediçao
                    else{
                        System.out.println("Acedendo as edições e aos filme da edição escolhida, para introduzir o ator");
                        System.out.println("Escolha a edição, introduzindo a posição desejada, começando por 0");
                        int ediEscolhida200 = scan.nextInt();                                                                                                      //guarda a posição escolhida da edição
                        ed = festival.getE().get(ediEscolhida200);        //obtem a edição 
                        System.out.println(ed.getFilmes());
                        //caso essa ediçao nao tenha filmes
                        if(ed.getFilmes().isEmpty()){
                            System.out.println("Crie primeiro um filme!");
                        }
                        //caso a ediçao tenha pelo menos um filme
                        else{
                            System.out.println("Escolha o filme onde deseja colocar o ator, introduzindo a posição desejada, começando por 0");         
                            int filmeEscolha100 = scan.nextInt();                                                                                                      
                            f = ed.getFilmes().get(filmeEscolha100);
                            System.out.println(f);
                            System.out.println("Escolha se quer um ator principal(0) ou uma atriz principal, (1)");
                            int male_female = scan.nextInt();
                            //caso introduza um ator principal
                            if (male_female == 0){
                                //verificar se este filme ja contem um ator principal 
                                //caso contenha avisa o utilizador
                                if(!f.getPrincipaisMale().isEmpty()){
                                    System.out.println("Este filme ja tem um ator principal");
                                }
                                //caso nao tenha nenhum ator principal
                                else{
                                    System.out.println("Escolha a posiçao do ator que deseja colocar no papel principal deste filme, começando no 0 ");
                                    System.out.println(f.getAtores());
                                    int atorEscolhido = scan.nextInt();
                                    Atores a5 = f.getAtores().get(atorEscolhido);
                                    f.addPrincipalMale(a5);
                                    System.out.println(f);
                                }
                            }
                            else if(male_female == 1){
                                 //verificar se este filme ja contem uma atriz principal 
                                //caso contenha avisa o utilizador
                                if(!f.getPrincipaisFemale().isEmpty()){
                                    System.out.println("Este filme ja tem uma atriz principal");
                                }
                                //caso nao tenha nenhuma atriz principal
                                else{
                                    System.out.println("Escolha a posiçao da atriz que deseja colocar no papel principal deste filme, começando no 0 ");
                                    System.out.println(f.getAtriz());
                                    int atrizEscolhida = scan.nextInt();
                                    Atriz a6 = f.getAtriz().get(atrizEscolhida);
                                    f.addPrincipalFemale(a6);
                                    System.out.println(f);
                                }
                            }
                            else{
                                System.out.println("Erro, opcao invalida");
                            }
                        }
                    }
                    break;
                case 6:
                    FileReader inStream = new FileReader("Filmes.txt");
                    BufferedReader bR = new BufferedReader(inStream);
                    String a,b,c,line;
                    String nome;
                    try{
                        line = bR.readLine();
                        while(line!=null){
                            //falta o ano e numero da ediçao,arranjar um simbolo para esta
                            //para fazer as atrizes e atores principais basta fazer igual aos atores mas mudando o simbolo
                            //System.out.println(line);
                            switch (line.charAt(0)) {
                                case '-':
                                    {
                                        boolean stop = false;
                                        //enquanto for verdade
                                        while(!stop){
                                            line = bR.readLine();
                                            if(line.charAt(0) == '-'){
                                                line = bR.readLine();
                                                break;
                                            }
                                            else{
                                                int ano = Integer.parseInt(line);
                                                line = bR.readLine();
                                                int numDeEdicao = Integer.parseInt(line);
                                                //cria edição, a instanciaçao do festival nao tem q estar fora do ciclo?

                                                ed = new Edicao(ano, numDeEdicao);
                                                if(festival.contemEdicao(ed)){
                                                    System.out.println("Ocorreu um erro!" + "\nEste festival já contém esta edição: " + "\n" + ed);
                                                    System.out.println();
                                                }
                                                else{
                                                festival.addEdicoes(ed);
                                                //System.out.println(fest.getE());
                                                }
                                            }
                                        }       break;
                                    }
                                //Introduz os atores nos filmes 
                                case ';':
                                    {
                                        boolean stop = false;
                                        while(!stop){
                                            //cena de escrever os atores
                                            //le o nome do ator
                                            line = bR.readLine();
                                            if(line.charAt(0) == ';'){
                                                line = bR.readLine();
                                                break;
                                            }
                                            else{
                                                nome = line;
                                                line = bR.readLine();
                                                //le os anos de carreira do ator
                                                int anosCarreira = Integer.parseInt(line);
                                                //line = bR.readLine();
                                                Atores actor1 = new Atores(nome,anosCarreira);
                                                //estas variaveis sao apenas apra nao escrever aqela parede de texto
                                                //cada vez que qeremos o filme/edicao que estamos a usar
                                                Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                                Edicao edicaoAtual = festival.getE().get(festival.getE().size() - 1);
                                                //adicionar as exeçoes do ator ja estar em 2 filmes nesta ediçao ou o caso de ja estar neste filme
                                                if(!edicaoAtual.maximoAtoresFilmes(actor1)){
                                                    if(!filmeAtual.atoresRepetidosNoFilme(actor1)) {
                                                        filmeAtual.addAtores(actor1);
                                                    }
                                                    else{
                                                        System.out.println(actor1);
                                                        System.out.println("Este ator já participa neste filme!");
                                                        System.out.println();
                                                    }
                                                }
                                                //alterar estes prints para demonstrar o filme em q nao entrou etc
                                                //provavelmente dividir o if anterior em dois diferentes
                                                else{
                                                    System.out.println(actor1);
                                                    System.out.println("Este ator já participou em 2 filmes nesta edição");
                                                    System.out.println();
                                                }
                                            }
                                        }
                                        //quando acabar, passamos as atrizes e depois temos os dois principais
                                        break;
                                    }
                                case ':':
                                    {
                                        boolean stop = false;
                                        while(!stop){
                                            //cena de escrever os atores
                                            //le o nome do ator
                                            line = bR.readLine();
                                            if(line.charAt(0) == ':'){
                                                line = bR.readLine();
                                                break;
                                            }
                                            else{
                                                nome = line;
                                                line = bR.readLine();
                                                //le os anos de carreira do ator
                                                int anosCarreira = Integer.parseInt(line);
                                                //line = bR.readLine();
                                                Atriz atriz1 = new Atriz(nome,anosCarreira);
                                                Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                                Edicao edicaoAtual = festival.getE().get(festival.getE().size() - 1);
                                                if(!edicaoAtual.maximoAtrizesFilmes(atriz1)){
                                                    if(!filmeAtual.atrizesRepetidosNoFilme(atriz1)){
                                                        filmeAtual.addAtriz(atriz1);
                                                    }
                                                }
                                                else{
                                                    System.out.println("Esta atriz não podes participar neste filme!");
                                                }
                                            }

                                        }       
                                    break;
                                    }
                                case '/' :
                                {
                                     boolean stop3 = false;
                                    while(!stop3){
                                    //em vez de termos o codigo todo do caso no teste,por numa funçao e chamar aqi
                                    line = bR.readLine();
                                        if(line.charAt(0) == '/'){
                                            line = bR.readLine();
                                            break;
                                        }
                                        else{
                                            nome = line;
                                            line = bR.readLine();
                                            //le os anos de carreira do ator
                                            int anosCarreira = Integer.parseInt(line);
                                            //line = bR.readLine();
                                            Atores actor1 = new Atores(nome,anosCarreira);
                                            //caso nao tenha atores principais
                                            Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                            //Edicao edicaoAtual = festival.getE().get(festival.getE().size() - 1);
                                            if(filmeAtual.getPrincipaisMale().isEmpty()){
                                                filmeAtual.addPrincipalMale(actor1);
                                            }
                                            else{
                                                System.out.print("Ocorreu um erro! No filme: ");
                                                System.out.println(filmeAtual.getNomeFilme());
                                                System.out.println("Este filme já tem um ator principal");
                                                System.out.println();
                                            }
                                        }
                                    } 
                                    break;
                                }
                                case '+' :
                                {
                                    boolean stop3 = false;
                                    while(!stop3){
                                    //em vez de termos o codigo todo do caso no teste,por numa funçao e chamar aqi
                                        line = bR.readLine();
                                        if(line.charAt(0) == '+'){
                                            line = bR.readLine();
                                            break;
                                        }
                                        else{
                                            nome = line;
                                            line = bR.readLine();
                                            //le os anos de carreira do ator
                                            int anosCarreira = Integer.parseInt(line);
                                            //line = bR.readLine();
                                            Atriz actress = new Atriz(nome,anosCarreira);
                                            Filmes filmeAtual = ed.getFilmes().get(ed.getFilmes().size() - 1);
                                            //Edicao edicaoAtual = fest.getE().get(fest.getE().size() - 1);
                                            //caso nao tenha atrizes principais
                                            if(filmeAtual.getPrincipaisFemale().isEmpty()){
                                                filmeAtual.addPrincipalFemale(actress);
                                            }
                                            else{
                                                System.out.println("este filme ja tem um ator principal");
                                            }
                                        }
                                    } 
                                    break;
                                }

                                default:
                                    a = line;
                                    line = bR.readLine();
                                    b = line;
                                    line = bR.readLine();
                                    c = line;
                                    line = bR.readLine();
                                    Filmes filmesFicheiro = new Filmes(a,b,c);
                                    ed.addFilmes(filmesFicheiro);
                                    break;
                            }

                        }
                        bR.close();
                    }   
                    catch(IOException ioe){
                        System.out.println("Ocorreu um erro!");
                        ioe.getMessage();
                    }
                    catch(NullPointerException e){
                        System.out.println("Ocorreu um erro do tipo NullPointerExeption");
                        e.getMessage();
                    }

                    //percorre o array das edições
                    for (int i = 0; i < festival.getE().size(); i++) {
                        //for (int j = 0; j < fest.getE().get(i).getFilmes().size(); j++) {
                        Edicao varEdicaoAtual= festival.getE().get(i);
                        System.out.println(varEdicaoAtual);
                        System.out.println();
                        System.out.println(varEdicaoAtual.getFilmes());
                        System.out.println();

                    }

                    break;
                case 7:
                    System.out.println(festival.getE());
                    System.out.println("Escolha a posicao da edição desejada,começando no 0");
                    ed = festival.getE().get(scan.nextInt());
                    System.out.println(ed);
                    System.out.println("Filmes dessa edição: ");
                    System.out.println(ed.getFilmes());
                    break; 
                case 8:
                    ArrayList<FilmesAtores> var2 = festival.getFilmesDosAtores();
                  //ArrayList<FilmesAtrizes> var3 = festival.getFilmesDasAtrizes();
                    System.out.println(var2);
                   // System.out.println(var3);
                    System.out.println();
                    break;
                case 9:
                    //ESTA a dar nullponterexeption again
                    //preencher os arrays para poder premiar
                    festival.categoriasFestival();
                    festival.filmesFestival();
                    festival.realizadoresFestival();
                    festival.atoresPrincipais();
                    festival.atores();
                    festival.atrizesPrincipais();
                    festival.atrizes();
                    festival.candidatosFilmes();
                    festival.candidatosAtor();
                    festival.candidatosAtriz();
                    festival.candidatosAtrizPrincipal();
                    festival.candidatosAtorPrincipal();
                    festival.candidatosPremioCarreira();
                    //listar as categorias a premiar
                    System.out.println("-----------------Categorias a premiar------------------");
                    System.out.println("Melhor Filme");
                    System.out.println("Para a categoria de melhor filme, participam: " + festival.getFilmesDoFestival());
                    System.out.println();
                    System.out.println("Melhor Realizador");
                    System.out.println("Para a categoria de melhor realizador, participam: " + festival.getRealizadoresFestival());
                    System.out.println();
                    System.out.println("Melhor Ator principal");
                    System.out.println("Para a categoria de melhor ator principal, participam: " + festival.getAtoresPrincipais());
                    System.out.println();
                    System.out.println("Melhor Atriz principal");
                    System.out.println("Para a categoria de melhor atriz principal, participam: " + festival.getAtrizesPrincipais());
                    System.out.println();
                    System.out.println("Melhor Ator secundário");
                    System.out.println("Para a categoria de melhor ator secundário, participam: " + festival.getActors()); 
                    System.out.println();
                    System.out.println("Melhor Atriz secundária");
                    System.out.println("Para a categoria de melhor atriz secundária, participam: " + festival.getActress());
                    System.out.println();
                    System.out.println("Prémio Carreira"); 
                    System.out.println("Para esta categora, particam os seguintes atores: " + festival.getFinalistasPremioCarreira());
                    System.out.println();
                    break;
                case 10:
                    winner.atribuiPontuacoesPremioAtorPrincipal();
                    winner.atribuiPontuacoesPremioCarreira();
                    System.out.println("---------------------------------Vencedores por categoria--------------------------------------------------------");
                    System.out.println("O premio de carreira vai para: " + winner.getPontuacoesPremioCarreira());
                    System.out.println();
                    System.out.println("O premio de melhor ator principal vai para: " + winner.getPontuacoesPremioAtorPrincipal());
                    break;
                case 11:
                    //caso para ordenar os finalistas pelas pontuaçoes
                    break;
                case 12: 
                    System.out.println("Saindo da aplicação!");
                    break;  
                default:
                    System.out.println("Opção Inválida!");
     
            }
            
        } while (opcao!=12);

    }
    //metodo para apresentar o menu menu
    public static void apresentarMenu(){
        
            System.out.println("Escolha uma opção");
            System.out.println("1- Criar uma nova Edição");
            System.out.println("2- Criar Filmes");
            System.out.println("3- Criar atores");
            System.out.println("4- Criar atrizes");
            System.out.println("5- Atribuir papel principal");
            System.out.println("6- Criar Festival a partir de um ficheiro de texto");
            System.out.println("7- Ver edições");
            System.out.println("8- Ver atores nos filmes em que participam");
            System.out.println("9- Ver categorias as premiar");
            System.out.println("10- Ver os vencedores de cada categoria");
            //System.out.println();
            System.out.println("12- Sair");  
    }
    

}
