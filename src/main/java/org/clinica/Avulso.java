package org.clinica;

public class Avulso extends Estoque {
    private int ID;
    private int quantidade;
    private String descricao;
    private boolean financeira;

    public Avulso(int ID, int quantidade, String descricao, boolean financeira) {
        this.ID = ID;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.financeira = financeira;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getID() {
        return ID;
    }
}