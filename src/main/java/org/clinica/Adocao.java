package org.clinica;

import java.util.*;

public class Adocao extends Sistema {
    private Date dataAdocao;
    private Animal animalAdotado;
    private Pretendente pretendente;
    private boolean termoAssinado;

    public Adocao(Date dataAdocao, Animal animalAdotado, Pretendente pretendente) {
        this.dataAdocao = dataAdocao;
        this.animalAdotado = animalAdotado;
        this.pretendente = pretendente;
        this.termoAssinado = false;
    }

    public void assinarTermo() {
        this.termoAssinado = true;
        System.out.println("Termo de responsabilidade assinado por " + pretendente.getNome());
    }

    public void cadastrarAdocao(Sistema sistema) {
        System.out.println("Adoção de " + animalAdotado.getEspecie() + " por " + pretendente.getNome() + " cadastrada.");
        sistema.adicionarAdocao(this);
    }
}