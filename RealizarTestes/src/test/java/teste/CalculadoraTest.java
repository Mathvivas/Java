package teste;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    void testSomar() {
        Calculadora calculadora = new Calculadora();
        int soma = calculadora.somar("1+1+3");
        assertEquals(5, soma);          // Validação do Teste
    }
}
