import com.ws.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setup(){
        calculadora = new Calculadora();
    }

    @Test
    void deveSomar() {
        int resultado = calculadora.somar(4, 2);
        Assertions.assertEquals(6, resultado);
    }

    @Test
    void deveSubtrair() {
        int resultado = calculadora.subtrair(4, 2);
        Assertions.assertEquals(2, resultado);
    }

    @Test
    void deveMultiplicar() {
        int resultado = calculadora.multiplicar(4, 2);
        Assertions.assertEquals(8, resultado);
    }

    @Test
    void deveDividir() {
        int resultado = calculadora.dividir(4, 2);
        Assertions.assertEquals(2, resultado);
    }

    @Test
    void deveDividir_gerarExcecaoQuandoDividirPorZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(4, 0);
        });
    }
}