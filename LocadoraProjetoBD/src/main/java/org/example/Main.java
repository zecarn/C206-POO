package org.example;


//Import de funções utilizadas no código
import java.text.DecimalFormat;
import java.util.Scanner;

//Import de classes usadas no código
import org.example.Classes.Cliente;
import org.example.Classes.Data;
import org.example.Classes.Pedido;
import org.example.Tables.ClienteBD;
import org.example.Tables.FilmeBD;
import org.example.Tables.PedidoBD;
import org.example.Tables.PedidoHasFilmeBD;

public class Main {
    public static void main(String[] args) {

        //Estanciando variáveis de entrada e controle
        Scanner sc = new Scanner(System.in);
        Boolean flag = true;
        Boolean flag2;
        Boolean flag3;
        Boolean flag4;

        //Estanciando as classes de BD utilizadas
        ClienteBD clienteBD = new ClienteBD();
        FilmeBD filmeBD = new FilmeBD();
        PedidoBD pedidoBD = new PedidoBD();
        PedidoHasFilmeBD pedidoHasFilmeBD = new PedidoHasFilmeBD();

        // Informações do cliente
        String nome;
        String cpf;
        String telefone;
        int idade;

        // Informações do pedido
        int idPedido;
        String dataPedido;

        // Informações do filme
        int idFilme;

        // Instanciando a classe de adquirir a data
        Data data = new Data();

        // MENU PARA SELEÇÃO INICIAL
        while (flag) {
            System.out.println("\n+------------------------------------------------------------+");
            System.out.println("|                   Bem vindo à locadora                     |");
            System.out.println("|                        José Marcio                         |");
            System.out.println("+------------------------------------------------------------+");
            System.out.println("\nPor favor selecione uma das opções abaixo: ");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Ja possuo conta");
            System.out.println("3 - Sair");
            System.out.print("\nOpção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.println("\n==============================================================");
                    System.out.println("                    Crição de novo usuário                    ");
                    System.out.println("==============================================================");

                    System.out.println("\nPor favor entre com as informações abaixo: ");

                    System.out.print("\nEntre com seu nome: ");
                    nome = sc.nextLine(); //Entrando com o nome do usuário

                    System.out.print("Entre com o seu CPF: ");
                    cpf = sc.nextLine(); //Entrando com o CPF do usuário

                    System.out.print("Entre com o seu telefone: ");
                    telefone = sc.nextLine(); //Entrando com o telefone do usuário

                    System.out.print("Entre com a sua idade: ");
                    idade = sc.nextInt(); //Entrando com a idade do usuário

                    Cliente cliente = new Cliente(cpf,nome, idade, telefone);
                    clienteBD.insertCliente(cliente);  //Inserindo na tabela o usuário criado
                    break;

                case 2:
                    System.out.print("\nEntre com seu CPF: ");
                    cpf = sc.nextLine();

                    if (clienteBD.selectClienteCPF(cpf)) { //Verficiando se o CPF inserido está presente no BD

                        System.out.println("\n==============================================================");
                        System.out.println("                    Seja bem vindo " + clienteBD.selectClienteNome(cpf));
                        System.out.println("==============================================================");

                        flag2 = true;
                        while (flag2) {
                            System.out.println("\nPor favor selecione uma das opções abaixo: ");
                            System.out.println("\n1 - Gerenciar pedidos");
                            System.out.println("2 - Detalhes dos pedidos");
                            System.out.println("3 - Pagar pedido existente");
                            System.out.println("4 - Voltar");
                            System.out.print("\nOpção: ");
                            op = sc.nextInt();
                            sc.nextLine();

                            switch (op) {

                                case 1:
                                    flag3 = true;
                                    while (flag3) {
                                        System.out.println("\n==============================================================");
                                        System.out.println("                   Gerenciamento de pedidos                   ");
                                        System.out.println("==============================================================");

                                        System.out.println("\nPor favor selecione uma das opções abaixo: ");

                                        System.out.println("\n1 - Criar pedido");
                                        System.out.println("2 - Mostrar filmes disponíveis");
                                        System.out.println("3 - Adicionar filmes a um pedido existente");
                                        System.out.println("4 - Remover filmes de um pedido existente");
                                        System.out.println("5 - Apagar pedido existente");
                                        System.out.println("6 - Voltar");

                                        System.out.print("\nOpção: ");
                                        op = sc.nextInt();
                                        sc.nextLine();
                                        switch (op) {

                                            case 1:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                      Criação de pedido                       ");
                                                System.out.println("==============================================================");

                                                System.out.println("\nPor favor entre com as informações abaixo: ");

                                                System.out.print("\nInsira o ID do pedido: ");
                                                idPedido = sc.nextInt(); //Entrando com o ID do pedido a ser criado

                                                Pedido pedido = new Pedido(idPedido, data.getDateTime(), 2, cpf);
                                                pedidoBD.insertPedido(pedido); //Inserindo pedido no banco de dados
                                                System.out.println("\nPedido criado com sucesso");
                                                break;
                                            case 2:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                      Filmes disponíveis                      ");
                                                System.out.println("==============================================================");
                                                filmeBD.selectFilme(); //Selecionando os filmes presentes no BD
                                                break;
                                            case 3:
                                               System.out.println("\n==============================================================");
                                                System.out.println("                        Adicionar filmes                       ");
                                                System.out.println("==============================================================");

                                                System.out.println("\nPor favor entre com as informações abaixo: ");

                                                System.out.print("\nInsira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido,cpf)) { //Verificando se o pedido existe no banco de dados
                                                    System.out.print("Insira o ID do filme: ");
                                                    idFilme = sc.nextInt();

                                                    if (filmeBD.selectFilmeId(idFilme)){ //Verficiando se o filme existe no banco de dados
                                                        if(clienteBD.selectClienteIdade(cpf) >= filmeBD.selectFilmeIdadeMinima(idFilme)){
                                                            pedidoHasFilmeBD.insertFilmeOnPedido(idFilme, idPedido); //Inserindo a relação entre filme e pedido
                                                            System.out.println("\nFilme adicionado com sucesso ao pedido!");
                                                        }
                                                        else
                                                            System.out.println("\nFilme indisponível para sua idade!");
                                                    }
                                                }
                                                break;
                                            case 4:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                        Remover filmes                        ");
                                                System.out.println("==============================================================");

                                                System.out.println("\nPor favor entre com as informações abaixo: ");

                                                System.out.print("\nInsira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido,cpf)) { //Verificando existencia do pedido dentro do banco de dados
                                                    System.out.print("Insira o ID do filme: ");
                                                    idFilme = sc.nextInt();
                                                    if (pedidoHasFilmeBD.deleteFilmeFromPedido(idFilme, idPedido)) //Vefjfjcando a existencia da relação entre o pedido e filme
                                                        System.out.println("\nFilme retirado com sucesso!");
                                                    else {
                                                        System.out.println("\nNão há um livro de ID:" + idFilme
                                                                + " vinculado ao pedido de ID: " + idPedido);
                                                    }
                                                } else {
                                                    System.out.println("\nID de pedido inválido");
                                                }
                                                break;
                                            case 5:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                      Exclusão de pedido                      ");
                                                System.out.println("==============================================================");

                                                System.out.println("\nPor favor entre com as informações abaixo: ");

                                                System.out.print("\nInsira o ID do pedido: ");
                                                idPedido = sc.nextInt();

                                                if (pedidoBD.selectPedidoId(idPedido,cpf)) { //Verficando a existencia do pedido no banco de dados
                                                    pedidoHasFilmeBD.deleteFromFilmeHasPedido(idPedido); //Deletando a relação deste pedido com filmes
                                                    pedidoBD.deletePedido(idPedido,cpf); //Deletando o pedido do banco de dados
                                                    System.out.println("\nPedido deletado com sucesso!");
                                                } else
                                                    System.out.println("\nPedido não encontrado!");
                                                break;
                                            case 6:
                                                flag3 = false;
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    flag4 = true;
                                    while (flag4) {
                                        System.out.println("\n==============================================================");
                                        System.out.println("                     Detalhes dos pedidos                     ");
                                        System.out.println("==============================================================");

                                        System.out.println("\nPor favor selecione uma das opções abaixo: ");

                                        System.out.println("\n1 - Pedidos desta conta");
                                        System.out.println("2 - Mostrar informações de um pedido específico");
                                        System.out.println("3 - Voltar");

                                        System.out.print("\nOpção: ");
                                        op = sc.nextInt();
                                        sc.nextLine();
                                        switch (op) {

                                            case 1:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                         Meus pedidos                         ");
                                                System.out.println("==============================================================");
                                                pedidoBD.selectPedidosIDs(cpf); //Selecionando os pedidos referentes ao CPF do usuario
                                                break;
                                            case 2:
                                                System.out.println("\n==============================================================");
                                                System.out.println("                      Seleção de pedido                       ");
                                                System.out.println("==============================================================");

                                                System.out.println("\nPor favor entre com a informação abaixo: ");

                                                System.out.print("\nInsira o ID do pedido: ");
                                                idPedido = sc.nextInt();
                                                if (pedidoBD.selectPedidoId(idPedido,cpf)) { //Verficiando a existencia do pedido no Banco de dados
                                                    pedidoBD.selectInfosPedidos(idPedido,cpf); //Printando as informações do pedido no banco de dados

                                                    int[] idFilmes = pedidoHasFilmeBD.selectFilmesPedido(idPedido); //Armazenando o ID dos filme vinculados a este pedido
                                                    double TotalPreco = 0; //Variavel de preço total
                                                    DecimalFormat formatador = new DecimalFormat("0.00"); //Configurando as casas decimais da saida

                                                    System.out.println("\nFilmes do pedido: ");
                                                    for (int i = 0; i < idFilmes.length; i++) { //Varrendo o vetor de ID de filmes
                                                        if (idFilmes[i] != 0) {
                                                            filmeBD.selectFilmeFromId(idFilmes[i]); //Printando as informações do livro referente ao ID
                                                            TotalPreco += filmeBD.selectFilmePreco(idFilmes[i]); //Somando o preço de cala livro do pedido
                                                        }
                                                    }
                                                    System.out.println("\nTotal valor do pedido: R$ " + formatador.format(TotalPreco));
                                                } else {
                                                    System.out.println("\nID Inválido");
                                                }
                                                break;
                                            case 3:
                                                flag4 = false;
                                                break;
                                            default:
                                                System.out.println("\tInsira um valor válido!");
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("\n==============================================================");
                                    System.out.println("                           Pagamento                          ");
                                    System.out.println("==============================================================");

                                    System.out.println("\nPor favor entre com a informação abaixo: ");

                                    System.out.print("\nInsira o ID do pedido: ");
                                    idPedido = sc.nextInt();
                                    if (pedidoBD.selectPedidoId(idPedido,cpf)) { //Verificando a existencia do pedido no BD
                                        pedidoBD.updateStatusPedido(idPedido,cpf);  //Fazendo o update do status do pedido
                                        System.out.println("\nPedido pago com sucesso!");
                                    } else
                                        System.out.println("\nID inválido");
                                    break;
                                case 4:
                                    flag2 = false;
                                    break;
                                default:
                                    System.out.println("\nInsira um valor válido!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("\nCpf inválido");
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("\nInsira um valor válido!");
            }
        }
        System.out.println("\n\tAté mais! ");
    }
}
