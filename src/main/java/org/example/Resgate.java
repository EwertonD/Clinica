package org.example;

import java.util.*;

public class Resgate extends Sistema {
    private Set<Animal> animaisResgatados;
    private Date dataResgate;

    public Resgate(Date dataResgate) {
        this.dataResgate = dataResgate;
        this.animaisResgatados = new HashSet<>();
    }

    public void setAnimaisResgatados(Set<Animal> animaisResgatados) {
        this.animaisResgatados = animaisResgatados;
    }

    public void registrarResgate(Sistema sistema) {
        sistema.adicionarResgate(this);
    }
}