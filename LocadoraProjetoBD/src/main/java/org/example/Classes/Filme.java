package org.example.Classes;

public class Filme {
    //Atributos do filme
    private int idFilme;
    private String nome;
    private String categoria;
    private int classificacaoIdade;
    private int anoLancamento;
    private float preco;
    private String fk_Produtora_CNPJ;


    //Construtor do filme
    public Filme(int idFilme, String nome, String categoria, int classificacaoIdade, int anoLancamento, float preco, String fk_Produtora_CNPJ) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.categoria = categoria;
        this.classificacaoIdade = classificacaoIdade;
        this.anoLancamento = anoLancamento;
        this.preco = preco;
        this.fk_Produtora_CNPJ = fk_Produtora_CNPJ;
    }

    public Filme(int id) {
        this.idFilme = id;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getClassificacaoIdade() {
        return classificacaoIdade;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public float getPreco() {
        return preco;
    }

    public String getFk_Produtora_CNPJ() {
        return fk_Produtora_CNPJ;
    }

}
