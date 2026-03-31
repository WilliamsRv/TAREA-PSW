package vallegrande.edu.pe.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la enumeración TipoCliente.
 */
public class TipoClienteTest {

    @Test
    @DisplayName("Test descuento VIP es 0.2")
    public void testDescuentoVIP() {
        assertEquals(0.2, TipoCliente.VIP.getDescuento());
    }

    @Test
    @DisplayName("Test descuento REGULAR es 0.1")
    public void testDescuentoRegular() {
        assertEquals(0.1, TipoCliente.REGULAR.getDescuento());
    }

    @Test
    @DisplayName("Test descuento SIN_DESCUENTO es 0.0")
    public void testDescuentoSinDescuento() {
        assertEquals(0.0, TipoCliente.SIN_DESCUENTO.getDescuento());
    }

    @Test
    @DisplayName("Test fromString con VIP")
    public void testFromStringVIP() {
        assertEquals(TipoCliente.VIP, TipoCliente.fromString("VIP"));
    }

    @Test
    @DisplayName("Test fromString con REGULAR")
    public void testFromStringRegular() {
        assertEquals(TipoCliente.REGULAR, TipoCliente.fromString("REGULAR"));
    }

    @Test
    @DisplayName("Test fromString con null devuelve SIN_DESCUENTO")
    public void testFromStringNull() {
        assertEquals(TipoCliente.SIN_DESCUENTO, TipoCliente.fromString(null));
    }

    @Test
    @DisplayName("Test fromString con valor inválido devuelve SIN_DESCUENTO")
    public void testFromStringInvalido() {
        assertEquals(TipoCliente.SIN_DESCUENTO, TipoCliente.fromString("INVALIDO"));
    }

    @Test
    @DisplayName("Test fromString con minúsculas devuelve VIP")
    public void testFromStringMinusculas() {
        assertEquals(TipoCliente.VIP, TipoCliente.fromString("vip"));
    }

    @Test
    @DisplayName("Test getDescripción no es nula")
    public void testGetDescripcion() {
        assertNotNull(TipoCliente.VIP.getDescripcion());
        assertNotNull(TipoCliente.REGULAR.getDescripcion());
        assertNotNull(TipoCliente.SIN_DESCUENTO.getDescripcion());
    }
}
