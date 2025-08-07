import org.example.Animal;
import org.example.CadastroService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroAnimalTest {

    private final CadastroService cadastroService = new CadastroService();

    @DisplayName("Cadastro de animal")
    @ParameterizedTest
    @CsvSource({
            "'Cachorro','Vira-lata','Caramelo',3,'2025-08-01',true",// sucesso
            "'Gato','Persa','Branco',-2,'2025-08-01',true",// falha
            "'','','Branco',4,'2025-08-01',false",
            "'Cachorro','Beagle','Preto',2,'2030-12-10',true", // falha
            "'Gato','Ragdoll','Branco',4,'2025-02-07',true"
    })
    void testCadastroAnimal(String especie, String raca, String cor, int idade, String data, boolean esperadoValido) {
        Animal animal = new Animal(especie, raca, cor, idade, data);

        boolean resultado = cadastroService.validarCadastro(animal);
        assertEquals(esperadoValido, resultado);
    }
}
