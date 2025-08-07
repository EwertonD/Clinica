package org.clinica;

import java.util.*;

public class Voluntario extends Sistema {
    private String nome;
    private String cpf;
    private String endereco;
    private String contato;
    private Date dataAdmissao;
    private Set<Resgate> agendaResgates;
    private Set<Tratamento> agendaTratamentos;

    public Voluntario(String nome, String cpf, String endereco, String contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.contato = contato;
        this.dataAdmissao = new Date(); // Data atual
        this.agendaResgates = new HashSet<>();
        this.agendaTratamentos = new HashSet<>();
    }

    public void adicionarResgate(Resgate resgate) {
        this.agendaResgates.add(resgate);
    }

    public void adicionarTratamento(Tratamento tratamento) {
        this.agendaTratamentos.add(tratamento);
    }
}