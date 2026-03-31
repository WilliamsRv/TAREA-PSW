package vallegrande.edu.pe;

public class PruebaManualCalculadora {

    public static void main(String[] args) {

        // Creamos un objeto de la calculadora
        Calculadora calc = new Calculadora();

        // Probamos manualmente la operación de suma
        int resultado = calc.sumar(2, 3);

        // Mostramos el resultado obtenido
        System.out.println("Resultado obtenido: " + resultado);

        // Verificamos manualmente si el resultado es correcto
        if(resultado == 5) {

            // Si el resultado es correcto
            System.out.println("Prueba manual exitosa");

        } else {

            // Si el resultado es incorrecto
            System.out.println("Prueba manual fallida");

        }

    }

}