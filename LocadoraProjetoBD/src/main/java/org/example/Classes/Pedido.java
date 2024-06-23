package org.example.Classes;

import java.util.Date;

public class Pedido {

    //Atributos do pedido
    private int idPedido;
    private String dataPedido;
    private int diasDevolucao;
    private String fk_Cliente_CPF;

    //Construtor do pedido
    public Pedido(int idPedido, String dataPedido, int diasDevolucao, String fk_Cliente_CPF) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.diasDevolucao = diasDevolucao;
        this.fk_Cliente_CPF = fk_Cliente_CPF;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public int getDiasDevolucao() {
        return diasDevolucao;
    }

    public String getFk_Cliente_CPF() {
        return fk_Cliente_CPF;
    }

}
