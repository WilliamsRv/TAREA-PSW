package vallegrande.edu.pe.service;

import vallegrande.edu.pe.constants.DescuentosConstants;
import vallegrande.edu.pe.model.TipoCliente;
import vallegrande.edu.pe.validator.PedidoValidator;

/**
 * Servicio responsable de calcular el total de pedidos aplicando descuentos
 * según el tipo de cliente y montos de compra.
 */
public class PedidoService {

    /**
     * Calcula el total de un pedido aplicando descuentos correspondientes.
     * 
     * @param precio precio unitario del producto
     * @param cantidad cantidad de productos
     * @param tipoCliente tipo de cliente (VIP, REGULAR, o null para sin descuento)
     * @return total calculado con descuentos aplicados
     * @throws IllegalArgumentException si el precio o cantidad son negativos
     */
    public double calcularTotal(double precio, int cantidad, String tipoCliente) {
        // Validar parámetros de entrada
        PedidoValidator.validarParametrosPedido(precio, cantidad);
        
        // Calcular subtotal
        double subtotal = calcularSubtotal(precio, cantidad);
        
        // Aplicar descuento por tipo de cliente
        double totalConDescuentoCliente = aplicarDescuentoCliente(subtotal, tipoCliente);
        
        // Aplicar descuento adicional por monto
        return aplicarDescuentoAdicional(totalConDescuentoCliente);
    }
    
    /**
     * Calcula el subtotal sin descuentos.
     * @param precio precio unitario
     * @param cantidad cantidad
     * @return subtotal
     */
    private double calcularSubtotal(double precio, int cantidad) {
        return precio * cantidad;
    }
    
    /**
     * Aplica el descuento correspondiente según el tipo de cliente.
     * @param subtotal monto al que aplicar el descuento
     * @param tipoCliente tipo de cliente como string
     * @return monto con descuento de cliente aplicado
     */
    private double aplicarDescuentoCliente(double subtotal, String tipoCliente) {
        TipoCliente tipo = TipoCliente.fromString(tipoCliente);
        double descuento = subtotal * tipo.getDescuento();
        return subtotal - descuento;
    }
    
    /**
     * Aplica descuento adicional si el monto supera el umbral.
     * @param monto monto a evaluar
     * @return monto con descuento adicional aplicado si corresponde
     */
    private double aplicarDescuentoAdicional(double monto) {
        if (monto > DescuentosConstants.UMBRAL_DESCUENTO_ADICIONAL) {
            return monto - DescuentosConstants.MONTO_DESCUENTO_ADICIONAL;
        }
        return monto;
    }
}