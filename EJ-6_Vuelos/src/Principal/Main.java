
package Principal;
import Controllers.*;
import Models.*;
/**
 *
 * @author emami
 */
public class Main {

    
    public static void main(String[] args) {
       GestorVuelos<Vuelos> app = new GestorVuelos<>();
         
       app.ejecutar();
        
    }
    
}
