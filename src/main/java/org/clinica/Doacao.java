package org.clinica;

import java.util.*;

public class Doacao extends Estoque {
    private Date dataDoacao;
    private String nomeDoador;
    private Set<Racao> racoesDoadas;
    private Set<Medicamento> medicamentosDoados;
    private Set<Avulso> avulsosDoados;

    public Doacao(Date dataDoacao, String nomeDoador, Set<Racao> racoesDoadas, Set<Medicamento> medicamentosDoados, Set<Avulso> avulsosDoados) {
        this.dataDoacao = dataDoacao;
        this.nomeDoador = nomeDoador;
        this.racoesDoadas = new HashSet<>();
        this.medicamentosDoados = new HashSet<>();
        this.avulsosDoados = new HashSet<>();
    }
}