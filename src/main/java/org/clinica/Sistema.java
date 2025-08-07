package org.clinica;

import java.util.*;

public class Sistema {
    protected Set<Animal> animais;
    protected Set<Tratamento> tratamentos;
    protected Set<Resgate> resgates;
    protected Set<Voluntario> voluntarios;
    protected Set<Pretendente> pretendentes;
    protected Set<Doacao> doacoes;
    protected Set<Adocao> adocoes;

    public Sistema() {
        this.animais = new HashSet<>();
        this.tratamentos = new HashSet<>();
        this.resgates = new HashSet<>();
        this.voluntarios = new HashSet<>();
        this.pretendentes = new HashSet<>();
        this.doacoes = new HashSet<>();
        this.adocoes = new HashSet<>();
    }

    public void adicionarAnimal(Animal animal) {
        this.animais.add(animal);
    }

    public void adicionarTratamento(Tratamento tratamento) {
        this.tratamentos.add(tratamento);
    }

    public void adicionarResgate(Resgate resgate) {
        this.resgates.add(resgate);
    }

    public void adicionarVoluntario(Voluntario voluntario) {
        this.voluntarios.add(voluntario);
    }

    public void adicionarPretendente(Pretendente pretendente) {
        this.pretendentes.add(pretendente);
    }

    public void adicionarDoacao(Doacao doacao) {
        this.doacoes.add(doacao);
    }

    public void adicionarAdocao(Adocao adocao) {
        this.adocoes.add(adocao);
    }

    public Set<Animal> getAnimais() {
        return animais;
    }

    public Set<Tratamento> getTratamentos() {
        return tratamentos;
    }

    public Set<Resgate> getResgates() {
        return resgates;
    }

    public Set<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public Set<Pretendente> getPretendentes() {
        return pretendentes;
    }

    public Set<Doacao> getDoacoes() {
        return doacoes;
    }

    public Set<Adocao> getAdocoes() {
        return adocoes;
    }
}