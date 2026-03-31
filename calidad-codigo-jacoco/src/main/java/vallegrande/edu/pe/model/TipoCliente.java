package vallegrande.edu.pe.model;

/**
 * Enumeración que representa los tipos de clientes con sus respectivos descuentos.
 */
public enum TipoCliente {
    VIP(0.2, "Cliente VIP con 20% de descuento"),
    REGULAR(0.1, "Cliente Regular con 10% de descuento"),
    SIN_DESCUENTO(0.0, "Cliente sin descuento");

    private final double descuento;
    private final String descripcion;

    TipoCliente(double descuento, String descripcion) {
        this.descuento = descuento;
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el tipo de cliente basado en el nombre.
     * @param nombre nombre del tipo de cliente
     * @return TipoCliente correspondiente o SIN_DESCUENTO si no coincide
     */
    public static TipoCliente fromString(String nombre) {
        if (nombre == null) {
            return SIN_DESCUENTO;
        }
        
        try {
            return TipoCliente.valueOf(nombre.toUpperCase());
        } catch (IllegalArgumentException e) {
            return SIN_DESCUENTO;
        }
    }
}
