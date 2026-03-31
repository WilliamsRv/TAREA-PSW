package vallegrande.edu.pe;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    // Esta clase contiene las pruebas automatizadas
// para verificar que los métodos de la calculadora funcionen correctamente
    public class CalculadoraTest {

        // Creamos una instancia de la calculadora
        Calculadora calc = new Calculadora();


        // ================================
        // PRUEBA 1: Verificar la suma
        // ================================
        @Test
        public void pruebaSumaBasica() {

            // Ejecutamos el método sumar
            int resultado = calc.sumar(2, 3);

            // Verificamos si el resultado es el esperado
            assertEquals(5, resultado);

        }


        // ================================
        // PRUEBA 2: Otra prueba de suma
        // ================================
        @Test
        public void pruebaSumaConOtrosNumeros() {

            int resultado = calc.sumar(10, 5);

            assertEquals(15, resultado);

        }


        // ================================
        // PRUEBA 3: Verificar resta
        // ================================
        @Test
        public void pruebaRestaBasica() {

            int resultado = calc.restar(8, 3);

            assertEquals(5, resultado);

        }


        // ================================
        // PRUEBA 4: Resta con números diferentes
        // ================================
        @Test
        public void pruebaRestaNegativa() {

            int resultado = calc.restar(5, 10);

            assertEquals(-5, resultado);

        }

    }