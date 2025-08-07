import org.example.AdocaoService;
import org.example.Pretendente;
import org.example.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RegistroAdocaoTest {

    private AdocaoService adocaoService;
    private Sistema sistemaDeTeste;

    @BeforeEach
    void setup() {
        sistemaDeTeste = new Sistema();
        Pretendente pretendenteExistente = new Pretendente(32, "Joaquin", "Malvinas", new String[]{}, new String[]{});
        sistemaDeTeste.adicionarPretendente(pretendenteExistente);

        Pretendente outroPretendente = new Pretendente(34, "Maria", "Bodocongó", new String[]{}, new String[]{});
        sistemaDeTeste.adicionarPretendente(outroPretendente);

        adocaoService = new AdocaoService(sistemaDeTeste);
    }

    @DisplayName("Registro de adoções")
    @ParameterizedTest
    @CsvSource({
            "101,32,true,true,true",   // sucesso
            "102,33,false,true,false", // animal já adotado
            "103,999,true,true,false", // pretendente não existe
            "104,34,true,false,false",
            "104,34,false,true,true", // falha
            "104,34,true,true,true",
            "104,34,false,false,false",
            "105,25,false,false,false",
            "106,34,true,true,true",
            "106,26,true,true,true" //falha

    })
    void testRegistroAdocao(int idAnimal, int idPretendente, boolean disponivel, boolean termoAssinado, boolean esperadoValido) {
        boolean resultado = adocaoService.validarAdocao(idAnimal, idPretendente, disponivel, termoAssinado);
        assertEquals(esperadoValido, resultado);
    }
}