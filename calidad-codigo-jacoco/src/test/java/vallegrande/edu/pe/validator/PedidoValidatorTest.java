package vallegrande.edu.pe.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase PedidoValidator.
 */
public class PedidoValidatorTest {

    @Test
    @DisplayName("Test validarPrecio con valor positivo no lanza excepción")
    public void testValidarPrecioPositivo() {
        assertDoesNotThrow(() -> PedidoValidator.validarPrecio(100.0));
    }

    @Test
    @DisplayName("Test validarPrecio con cero no lanza excepción")
    public void testValidarPrecioCero() {
        assertDoesNotThrow(() -> PedidoValidator.validarPrecio(0.0));
    }

    @Test
    @DisplayName("Test validarPrecio con negativo lanza excepción")
    public void testValidarPrecioNegativo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PedidoValidator.validarPrecio(-100.0)
        );
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Test validarCantidad con valor positivo no lanza excepción")
    public void testValidarCantidadPositiva() {
        assertDoesNotThrow(() -> PedidoValidator.validarCantidad(5));
    }

    @Test
    @DisplayName("Test validarCantidad con cero no lanza excepción")
    public void testValidarCantidadCero() {
        assertDoesNotThrow(() -> PedidoValidator.validarCantidad(0));
    }

    @Test
    @DisplayName("Test validarCantidad con negativo lanza excepción")
    public void testValidarCantidadNegativa() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PedidoValidator.validarCantidad(-5)
        );
        assertEquals("La cantidad no puede ser negativa", exception.getMessage());
    }

    @Test
    @DisplayName("Test validarParametrosPedido con valores válidos no lanza excepción")
    public void testValidarParametrosPedidoValidos() {
        assertDoesNotThrow(() -> PedidoValidator.validarParametrosPedido(100.0, 5));
    }

    @Test
    @DisplayName("Test validarParametrosPedido con precio negativo lanza excepción")
    public void testValidarParametrosPedidoPrecioNegativo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PedidoValidator.validarParametrosPedido(-100.0, 5)
        );
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Test validarParametrosPedido con cantidad negativa lanza excepción")
    public void testValidarParametrosPedidoCantidadNegativa() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PedidoValidator.validarParametrosPedido(100.0, -5)
        );
        assertEquals("La cantidad no puede ser negativa", exception.getMessage());
    }
}
