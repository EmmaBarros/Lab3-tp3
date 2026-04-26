
package Models;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class PagoEfectivo extends Pago {

    
    public PagoEfectivo(double monto) {
        super(monto);
    }

    public PagoEfectivo(){ 
            super();
    }
    
    @Override
    public boolean procesar(){
        Consola.emitirMensajeLN("se realizo con exito el pago en efectivo del monto de  $ ="+monto );
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " / pago Efectivo";
    }

    @Override
    public void mostrarComprobante(Persona cliente) {
        
    }
    
    
}
