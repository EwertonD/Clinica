package org.example;

public class Medicamento extends Estoque {
    private int ID;
    private String nome;
    private int quantidade;
    private String tipo;

    public Medicamento(int ID, String nome, int quantidadeInicial, String tipo) {
        this.ID = ID;
        this.nome = nome;
        this.quantidade = quantidadeInicial;
        this.tipo = tipo;
    }

    public void setQuantidade(int alteracao) {
        this.quantidade += alteracao;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}