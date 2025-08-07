package org.clinica;

public class Pretendente extends Sistema {
    private int ID;
    private String nome;
    private String bairro;
    private String[] especiesPreferidas;
    private String[] racasPreferidas;

    public Pretendente(int ID, String nome, String bairro, String[] especiesPreferidas, String[] racasPreferidas) {
        this.ID = ID;
        this.nome = nome;
        this.bairro = bairro;
        this.especiesPreferidas = especiesPreferidas;
        this.racasPreferidas = racasPreferidas;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }
}