
package Validar;

/**
 *
 * @author emami
 */
public class Validar {
   /**
     * Valida que un entero sea mayor a cero.
     * Útil para IDs, cantidades, o números de tarjeta.
     */
    public static boolean validarInt(int valor) {
        return valor > 0;
    }
    
    public static boolean ValidarIntRang(int valor,int min,int max){
        return valor > 0 && valor > min && valor < max;
    }

    /**
     * Valida que un número decimal sea mayor a cero.
     * Ideal para montos de pago, precios o saldos.
     */
    public static boolean validarDouble(double valor) {
        return valor > 0;
    }
    public static boolean ValidarDoubleRang(double valor,double min,double max){
        return valor > 0 && valor > min && valor < max;
    }

    /**
     * Valida que un String no sea nulo y no esté vacío.
     * El método .trim() elimina los espacios en blanco accidentales.
     */
    public static boolean validarString(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un DNI tenga una longitud lógica (7 u 8 caracteres).
     * También verifica que el String sea válido.
     */
    public static boolean validarDni(String dni) {
        if (!validarString(dni)) {
            return false;
        }
        int largo = dni.trim().length();
        return largo >= 7 && largo <= 8;
    }

    /**
     * Valida un número de tarjeta. Por ahora verifica que sea positivo, 
     * pero podrías extenderlo para que verifique una cantidad de dígitos.
     */
    public static boolean validarNroTarjeta(int nro) {
        return nro > 0;
    }
    
}
