package org.example;

import java.util.Date;

public class CadastroService {
    public boolean validarCadastro(Animal animal) {
        if (animal.getIdade() < 0) {
            return false;
        }
        if (animal.getEspecie() == null || animal.getEspecie().trim().isEmpty() ||
                animal.getRaca() == null || animal.getRaca().trim().isEmpty()) {
            return false;
        }
        if (animal.getDataChegada() != null && animal.getDataChegada().after(new Date())) {
            return false;
        }
        return true;
    }
}
