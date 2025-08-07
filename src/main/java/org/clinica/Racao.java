package org.clinica;

public class Racao extends Estoque {
    private int ID;
    private String marca;
    private String qualEspecie;
    private int quantidade;
    private String tipo;

    public Racao(int ID, String marca, String qualEspecie, int quantidadeInicial, String tipo) {
        this.ID = ID;
        this.marca = marca;
        this.qualEspecie = qualEspecie;
        this.quantidade = quantidadeInicial;
        this.tipo = tipo;
    }

    public int getID() {
        return ID;
    }

    public void setQuantidade(int alteracao) {
        this.quantidade += alteracao;
    }

    public int getQuantidade() {
        return quantidade;
    }
}