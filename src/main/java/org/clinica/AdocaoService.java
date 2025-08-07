package org.clinica;

public class AdocaoService {
    private final Sistema sistema;

    public AdocaoService(Sistema sistema) {
        this.sistema = sistema;
    }

    public boolean validarAdocao(int idAnimal, int idPretendente, boolean disponivel, boolean termoAssinado) {
        if (!disponivel) {
            return false;
        }
        boolean pretendenteExiste = sistema.getPretendentes().stream()
                .anyMatch(p -> p.getID() == idPretendente);
        if (!pretendenteExiste) {
            return false;
        }
        if (!termoAssinado) {
            return false;
        }
        return true;
    }
}
