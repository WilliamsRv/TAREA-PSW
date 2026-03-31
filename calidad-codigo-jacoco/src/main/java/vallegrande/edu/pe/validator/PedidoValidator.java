package vallegrande.edu.pe.validator;

import vallegrande.edu.pe.constants.DescuentosConstants;

/**
 * Clase responsable de validar los parámetros de los pedidos.
 */
public final class PedidoValidator {
    
    // Constructor privado para evitar instanciación
    private PedidoValidator() {
        throw new UnsupportedOperationException("Clase de validación no puede ser instanciada");
    }
    
    /**
     * Valida que el precio sea válido.
     * @param precio precio a validar
     * @throws IllegalArgumentException si el precio es negativo
     */
    public static void validarPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException(DescuentosConstants.ERROR_PRECIO_NEGATIVO);
        }
    }
    
    /**
     * Valida que la cantidad sea válida.
     * @param cantidad cantidad a validar
     * @throws IllegalArgumentException si la cantidad es negativa
     */
    public static void validarCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(DescuentosConstants.ERROR_CANTIDAD_NEGATIVA);
        }
    }
    
    /**
     * Valida todos los parámetros del pedido.
     * @param precio precio del producto
     * @param cantidad cantidad de productos
     */
    public static void validarParametrosPedido(double precio, int cantidad) {
        validarPrecio(precio);
        validarCantidad(cantidad);
    }
}
