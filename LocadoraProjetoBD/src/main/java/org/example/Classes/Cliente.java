package org.example.Classes;

public class Cliente {
    //Atributos do cliente
    private String nome;
    private String CPF;
    private int idade;
    private String telefone;


    //Construtor do cliente
    public Cliente(String CPF, String nome, int idade, String telefone) {
        this.CPF = CPF;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    //Getters do cliente
    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdade() {
        return idade;
    }

}
