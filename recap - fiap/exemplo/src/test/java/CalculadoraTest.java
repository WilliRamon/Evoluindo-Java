import com.ws.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CalculadoraTest {

    @Test
    void deveSomar() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(4, 2);
        Assertions.assertEquals(6, resultado);
    }

    @Test
    void deveSubtrair() {
        Assertions.fail("Teste não implementado");
    }

    @Test
    void deveMultiplicar() {
        Assertions.fail("Teste não implementado");
    }

    @Test
    void deveDividir() {
        Assertions.fail("Teste não implementado");
    }
}