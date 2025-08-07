package org.example;

import java.util.*;

public class Estoque extends Sistema {
    protected Set<Racao> racoes;
    protected Set<Medicamento> medicamentos;
    protected Set<Avulso> avulsos;

    public Estoque() {
        this.racoes = new HashSet<>();
        this.medicamentos = new HashSet<>();
        this.avulsos = new HashSet<>();
    }

    public Set<Racao> getRacoes() {
        return racoes;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Set<Avulso> getAvulsos() {
        return avulsos;
    }

    public Medicamento buscarMedicamentoPorID(int id) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getID() == id) {
                return medicamento;
            }
        }
        return null; // Retorna null se o medicamento não for encontrado
    }

    public Racao buscarRacaoPorID(int id) {
        for (Racao racao : racoes) {
            if (racao.getID() == id) {
                return racao;
            }
        }
        return null; // Retorna null se a ração não for encontrada
    }

    public Avulso buscarAvulsoPorID(int id) {
        for (Avulso avulso : avulsos) {
            if (avulso.getID() == id) {
                return avulso;
            }
        }
        return null; // Retorna null se o item avulso não for encontrado
    }

}