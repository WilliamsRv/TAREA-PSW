package vallegrande.edu.pe.constants;

/**
 * Clase de constantes para los cálculos de pedidos.
 */
public final class DescuentosConstants {
    
    // Constantes de descuentos
    public static final double DESCUENTO_VIP = 0.2;
    public static final double DESCUENTO_REGULAR = 0.1;
    public static final double DESCUENTO_NINGUNO = 0.0;
    
    // Umbrales y montos
    public static final double UMBRAL_DESCUENTO_ADICIONAL = 500.0;
    public static final double MONTO_DESCUENTO_ADICIONAL = 20.0;
    
    // Mensajes de error
    public static final String ERROR_PRECIO_NEGATIVO = "El precio no puede ser negativo";
    public static final String ERROR_CANTIDAD_NEGATIVA = "La cantidad no puede ser negativa";
    
    // Constructor privado para evitar instanciación
    private DescuentosConstants() {
        throw new UnsupportedOperationException("Clase de constantes no puede ser instanciada");
    }
}
