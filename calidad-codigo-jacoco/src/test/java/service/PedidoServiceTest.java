package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import vallegrande.edu.pe.service.PedidoService;

/**
 * Clase de pruebas unitarias para PedidoService.
 * Cubre todos los escenarios incluyendo casos límite y validaciones.
 */
public class PedidoServiceTest {

    private PedidoService service;

    @BeforeEach
    public void setUp() {
        service = new PedidoService();
    }

    // ================================
    // PRUEBAS DE FUNCIONALIDAD BÁSICA
    // ================================

    @Test
    @DisplayName("Test cliente VIP con descuento del 20%")
    public void testClienteVIP() {
        double total = service.calcularTotal(100, 2, "VIP");
        assertEquals(160, total, 0.001);
    }

    @Test
    @DisplayName("Test cliente Regular con descuento del 10%")
    public void testClienteRegular() {
        double total = service.calcularTotal(100, 2, "REGULAR");
        assertEquals(180, total, 0.001);
    }

    @Test
    @DisplayName("Test cliente sin tipo (sin descuento)")
    public void testSinDescuento() {
        double total = service.calcularTotal(100, 2, "OTRO");
        assertEquals(200, total, 0.001);
    }

    @Test
    @DisplayName("Test cliente con null (sin descuento)")
    public void testClienteNull() {
        double total = service.calcularTotal(100, 2, null);
        assertEquals(200, total, 0.001);
    }

    // ================================
    // PRUEBAS DE DESCUENTO ADICIONAL
    // ================================

    @Test
    @DisplayName("Test descuento adicional por monto mayor a 500")
    public void testDescuentoAdicional() {
        double total = service.calcularTotal(100, 6, "REGULAR");
        assertEquals(520, total, 0.001);
    }

    @Test
    @DisplayName("Test sin descuento adicional (monto exacto 500)")
    public void testSinDescuentoAdicionalMontoExacto() {
        double total = service.calcularTotal(250, 2, "REGULAR");
        assertEquals(450, total, 0.001);
    }

    @Test
    @DisplayName("Test sin descuento adicional (monto menor a 500)")
    public void testSinDescuentoAdicionalMontoMenor() {
        double total = service.calcularTotal(100, 4, "REGULAR");
        assertEquals(360, total, 0.001);
    }

    // ================================
    // PRUEBAS DE CASOS LÍMITE
    // ================================

    @Test
    @DisplayName("Test con cantidad cero")
    public void testCantidadCero() {
        double total = service.calcularTotal(100, 0, "VIP");
        assertEquals(0, total, 0.001);
    }

    @Test
    @DisplayName("Test con precio cero")
    public void testPrecioCero() {
        double total = service.calcularTotal(0, 5, "VIP");
        assertEquals(0, total, 0.001);
    }

    @Test
    @DisplayName("Test con valores mínimos positivos")
    public void testValoresMinimosPositivos() {
        double total = service.calcularTotal(0.01, 1, "VIP");
        assertEquals(0.008, total, 0.001);
    }

    // ================================
    // PRUEBAS DE VALIDACIÓN (ERRORES)
    // ================================

    @Test
    @DisplayName("Test precio negativo debe lanzar excepción")
    public void testPrecioNegativo() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(-100, 2, "VIP")
        );
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Test cantidad negativa debe lanzar excepción")
    public void testCantidadNegativa() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(100, -2, "VIP")
        );
        assertEquals("La cantidad no puede ser negativa", exception.getMessage());
    }

    @Test
    @DisplayName("Test ambos parámetros negativos")
    public void testAmbosParametrosNegativos() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(-100, -2, "VIP")
        );
        assertEquals("El precio no puede ser negativo", exception.getMessage());
    }

    // ================================
    // PRUEBAS DE ESCENARIOS COMPLEJOS
    // ================================

    @Test
    @DisplayName("Test VIP con descuento adicional")
    public void testVIPConDescuentoAdicional() {
        double total = service.calcularTotal(200, 3, "VIP");
        assertEquals(480, total, 0.001);
    }

    @Test
    @DisplayName("Test con monto muy grande")
    public void testMontoGrande() {
        double total = service.calcularTotal(1000, 10, "VIP");
        assertEquals(7980, total, 0.001);
    }

    @Test
    @DisplayName("Test con tipo cliente en minúsculas")
    public void testTipoClienteMinusculas() {
        double total = service.calcularTotal(100, 2, "vip");
        assertEquals(160, total, 0.001);
    }

    @Test
    @DisplayName("Test con tipo cliente vacío")
    public void testTipoClienteVacio() {
        double total = service.calcularTotal(100, 2, "");
        assertEquals(200, total, 0.001);
    }

    // ================================
    // PRUEBAS DE PRECISIÓN DECIMAL
    // ================================

    @Test
    @DisplayName("Test precisión con decimales")
    public void testPrecisionDecimales() {
        double total = service.calcularTotal(99.99, 2, "VIP");
        assertEquals(159.984, total, 0.001);
    }
}