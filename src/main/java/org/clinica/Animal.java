package org.clinica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Animal extends Sistema {
    private int ID;
    private String raca;
    private String especie;
    private String cor;
    private int idade;
    private Date dataChegada;
    private Date dataSaida;
    private Set<Tratamento> tratamentos;
    private boolean vaoAdotar;
    private boolean foiAdotado;


    public Animal(int ID, String raca, String especie, String cor, int idade) {
        this.ID = ID;
        this.raca = raca;
        this.especie = especie;
        this.cor = cor;
        this.idade = idade;
        this.tratamentos = new HashSet<>();
        this.foiAdotado = false;
        this.dataChegada = new Date();
    }

    public Animal(String especie, String raca, String cor, int idade, String dataChegadaStr) {
        this.ID = 0;
        this.raca = raca;
        this.especie = especie;
        this.cor = cor;
        this.idade = idade;
        this.tratamentos = new HashSet<>();
        this.foiAdotado = false;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.dataChegada = sdf.parse(dataChegadaStr);
        } catch (ParseException e) {
            this.dataChegada = null;
        }
    }

    public void cadastrarAnimal(Sistema sistema) {
        sistema.adicionarAnimal(this);
    }

    public int getID() {
        return ID;
    }

    public void registrarTratamento(Tratamento tratamento) {
        tratamentos.add(tratamento);
    }

    public void confirmarAdocao() {
        this.foiAdotado = true;
        this.dataSaida = new Date();
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", raca='" + raca + '\'' +
                ", especie='" + especie + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                '}';
    }
}