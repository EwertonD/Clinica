package org.example;

import java.util.*;

public class Tratamento extends Sistema {
    private String nomeProcedimento;
    private Animal animalTratado;
    private Date dataProcedimento;
    private Set<Medicamento> medicamentosUsados;
    private String descricaoProcedimento;

    public Tratamento(String nomeProcedimento, Animal animalTratado, Date dataProcedimento, String descricaoProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
        this.animalTratado = animalTratado;
        this.dataProcedimento = dataProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.medicamentosUsados = new HashSet<>();
    }

    public void setMedicamentosUsados(Set<Medicamento> medicamentosUsados) {
        this.medicamentosUsados = medicamentosUsados;
    }

    public void registrarTratamento(Sistema sistema) {
        sistema.adicionarTratamento(this);
    }

    public void informarConsumo(Estoque estoque) {
        for (Medicamento medicamentoUsado : medicamentosUsados) {
            // Buscar o medicamento no estoque pelo ID
            Medicamento medicamentoEstoque = estoque.buscarMedicamentoPorID(medicamentoUsado.getID());

            if (medicamentoEstoque != null) {
                // Subtrair a quantidade utilizada da quantidade disponível no estoque
                int novaQuantidade = medicamentoEstoque.getQuantidade() - medicamentoUsado.getQuantidade();
                if (novaQuantidade >= 0) {
                    medicamentoEstoque.setQuantidade(novaQuantidade);
                    System.out.println("Consumo de " + medicamentoUsado.getNome() + " registrado. Nova quantidade no estoque: " + novaQuantidade);
                } else {
                    System.out.println("Erro: Quantidade insuficiente de " + medicamentoUsado.getNome() + " no estoque.");
                }
            } else {
                System.out.println("Erro: Medicamento " + medicamentoUsado.getNome() + " não encontrado no estoque.");
            }
        }
    }
}