package vallegrande.edu.pe;

/**
 * Clase que representa una calculadora con operaciones matemáticas básicas.
 * Proporciona métodos para realizar cálculos aritméticos comunes.
 */
public class Calculadora {

    // Constantes para operaciones
    public static final String SUMA = "suma";
    public static final String RESTA = "resta";
    public static final String MULTIPLICACION = "multiplicacion";
    public static final String DIVISION = "division";
    
    /**
     * Método para sumar dos números
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de la suma
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Método para restar dos números
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de la resta
     */
    public int restar(int a, int b) {
        return a - b;
    }
    
    /**
     * Método para multiplicar dos números
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de la multiplicación
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    /**
     * Método para dividir dos números
     * @param a dividendo
     * @param b divisor
     * @return resultado de la división
     * @throws ArithmeticException cuando se intenta dividir por cero
     */
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return (double) a / b;
    }
    
    /**
     * Método para calcular el valor absoluto de un número
     * @param numero número a evaluar
     * @return valor absoluto
     */
    public int valorAbsoluto(int numero) {
        return Math.abs(numero);
    }
    
    /**
     * Método para verificar si un número es par
     * @param numero número a evaluar
     * @return true si es par, false si es impar
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }
    
    /**
     * Método para calcular el factorial de un número
     * @param numero número entero no negativo
     * @return factorial del número
     * @throws IllegalArgumentException si el número es negativo
     */
    public long factorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }
        
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}