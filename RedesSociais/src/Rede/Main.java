package Rede;

import Exceptions.Checked;
import Exceptions.UnChecked;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputMismatchException{
        Scanner entrada = new Scanner(System.in);
        Scanner entrada1 = new Scanner(System.in);

        RedeSocial rede;
        int N = 1;
        int acao;
        String conta;


        Usuario us = new Usuario("José", "zeca@gmail.com");

        Instagram insta = new Instagram("zeca1234", 150);
        Facebook face = new Facebook("1234zeca", 132);
        Twitter twit = new Twitter("12zeca34", 30);
        GooglePlus google = new GooglePlus("zecazeca",50);

        //Inserindo as Redes Sociais no Usuário
        try{
            us.usuario(insta);
        } catch (UnChecked e){
            System.out.println(e.getMessage());
        }
        try{
            us.usuario(face);
        } catch (UnChecked e){
            System.out.println(e.getMessage());
        }
        try{
            us.usuario(twit);
        } catch (UnChecked e){
            System.out.println(e.getMessage());
        }
        try{
            us.usuario(google);
        } catch (UnChecked e){
            System.out.println(e.getMessage());
        }

        do{
            System.out.println("\n__________________________________________________________________________________________________________________________________");
            System.out.println("Qual ação deseja executar? (0 - Sair)");
            System.out.println("1- Entrar na rede | 2- Verificar dados das redes");
            System.out.println("__________________________________________________________________________________________________________________________________\n");

            N = entrada.nextInt();


            switch (N) {
                case 0:
                    System.out.println("Até mais!");
                    break;
                case 1:
                    System.out.println("\n__________________________________________________________________________________________________________________________________");
                    System.out.println("Digite qual rede deseja entrar?");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println("Facebook | Instagram | Twitter | Google Plus | Sair (para voltar ao Menu)");
                    System.out.println("__________________________________________________________________________________________________________________________________\n");

                    conta = entrada1.nextLine();

                    rede = us.rede.get(conta);
                    if (rede instanceof Facebook) {
                        Facebook facebook = (Facebook) rede;
                        System.out.println("Qual ação deseja fazer na rede?");
                        do {
                            System.out.println("\n__________________________________________________________________________________________________________________________________");
                            System.out.println("1- Curtir Publicação | 2- Postar Foto | 3- Postar Video | 4- Postar Comentário | 5- Compartilhar | 6- Fazer Streaming | 0- Sair");
                            System.out.println("__________________________________________________________________________________________________________________________________\n");
                            acao = entrada.nextInt();
                            try{
                                switch (acao){
                                    case 0:
                                        System.out.println("Voltando para a página inicial");
                                    case 1:
                                        try {
                                            facebook.curtirPublicacao();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        try {
                                            facebook.postarFoto();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        try {
                                            facebook.postarVideo();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 4:
                                        try {
                                            facebook.postarComentario();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 5:
                                        try {
                                            facebook.compartilhar();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 6:
                                        try {
                                            facebook.fazStreaming();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                            } catch (Checked e){
                                System.out.println(e.getMessage());
                                System.out.println("Opção inválida");
                            }

                        } while (acao != 0);
                    }
                    if (rede instanceof Instagram) {
                        Instagram instagram = (Instagram) rede;
                        System.out.println("Qual ação deseja fazer na rede?");
                        do {
                            System.out.println("\n__________________________________________________________________________________________________________________________________");
                            System.out.println("1- Curtir Publicação | 2- Postar Foto | 3- Postar Video | 4- Postar Comentário | 0- Sair");
                            System.out.println("__________________________________________________________________________________________________________________________________\n");
                            acao = entrada.nextInt();
                            try{
                                switch (acao){
                                    case 0:
                                        System.out.println("Voltando para a página inicial");
                                    case 1:
                                        try {
                                            instagram.curtirPublicacao();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        try {
                                            instagram.postarFoto();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        try {
                                            instagram.postarVideo();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 4:
                                        try {
                                            instagram.postarComentario();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                            } catch (Checked e){
                                System.out.println(e.getMessage());
                                System.out.println("Opção inválida");
                            }

                        } while (acao != 0);
                    }
                    if (rede instanceof Twitter) {
                        Twitter twitter = (Twitter) rede;
                        System.out.println("Qual ação deseja fazer na rede?");
                        do {
                            System.out.println("\n__________________________________________________________________________________________________________________________________");
                            System.out.println("1- Curtir Publicação | 2- Postar Foto | 3- Postar Video | 4- Postar Comentário | 5- Compartilhar | 0- Sair");
                            System.out.println("__________________________________________________________________________________________________________________________________\n");
                            acao = entrada.nextInt();
                            try{
                                switch (acao){
                                    case 0:
                                        System.out.println("Voltando para a página inicial");
                                    case 1:
                                        try {
                                            twitter.curtirPublicacao();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        try {
                                            twitter.postarFoto();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        try {
                                            twitter.postarVideo();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 4:
                                        try {
                                            twitter.postarComentario();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 5:
                                        try {
                                            twitter.compartilhar();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                            } catch (Checked e){
                                System.out.println(e.getMessage());
                                System.out.println("Opção inválida");
                            }

                        } while (acao != 0);
                    }
                    if (rede instanceof GooglePlus) {
                        GooglePlus googlePlus = (GooglePlus) rede;
                        System.out.println("Qual ação deseja fazer na rede?");
                        do {
                            System.out.println("\n__________________________________________________________________________________________________________________________________");
                            System.out.println("1- Curtir Publicação | 2- Postar Foto | 3- Postar Video | 4- Postar Comentário | 5- Compartilhar | 6- Fazer Streaming | 0- Sair");
                            System.out.println("__________________________________________________________________________________________________________________________________\n");
                            acao = entrada.nextInt();
                            try{
                                switch (acao){
                                    case 0:
                                        System.out.println("Voltando para a página inicial");
                                    case 1:
                                        try {
                                            googlePlus.curtirPublicacao();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        try {
                                            googlePlus.postarFoto();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        try {
                                            googlePlus.postarVideo();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 4:
                                        try {
                                            googlePlus.postarComentario();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 5:
                                        try {
                                            googlePlus.compartilhar();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 6:
                                        try {
                                            googlePlus.fazStreaming();
                                        } catch (NullPointerException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                            } catch (Checked e){
                                System.out.println(e.getMessage());
                                System.out.println("Opção inválida");
                            }
                        } while (acao != 0);
                    }
                break;

                case 2:
                    us.rede.forEach((chave, valor) -> {
                        System.out.println("\nRede Social: " + chave);
                        System.out.println("Amigos: " + valor.getNumAmigos());
                        System.out.println("Senha: " + valor.getSenha());
                    });
                break;
            }

        } while(N != 0);

    }
}
