
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
            Consola.emitirMensajeLN("Pago en efectvo realizado con exito del monto de: $"+super.monto);
            return true;
       
    }

    @Override
    public String toString() {
        return super.toString() + " / pago Efectivo";
    }

    @Override
    public void mostrarComprobante(Persona cliente) {
     super.mostrarComprobante(cliente);
     this.toString();
     Consola.emitirMensajeLN("Pago en EFECTIVO APROBADO");
    }

    @Override
    public void mostrarInfo() {
        this.toString();
    }
    
    
}
