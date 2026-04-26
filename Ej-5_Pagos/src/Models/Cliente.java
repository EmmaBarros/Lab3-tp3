
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Cliente extends Persona {
    private static int contadorId = 0;
    private int idCliente;
   

    public Cliente(int idCliente, String nom, String ape, String dni) {
        super(nom, ape, dni);
         contadorId ++;
        this.idCliente = contadorId;
    }
  
    public Cliente() {
        super();
        contadorId ++;
        this.idCliente = contadorId;
    }
    @Override
    public void CargarDatos(){
        super.CargarDatos();
        Consola.emitirMensajeLN("ID asignado :"+ this.idCliente);
    }

    public int getContadorId() {
        return contadorId;
    }

    private void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public int getIdCliente() {
        return idCliente;
    }

    private void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
