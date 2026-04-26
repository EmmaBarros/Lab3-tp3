
package Models;
import Consola.Consola;
import Controllers.Icomprobante;
/**
 *
 * @author emami
 */
public abstract class Pago implements Icomprobante {
    protected double monto;

    public Pago(double monto) {
        this.monto = monto;
    }
    
    public Pago() {
        this.monto = 0;
    }
    public void cargarDatos(){
        ingresarMonto(); 
    }
    private void ingresarMonto(){
        double m;
        do{
           Consola.emitirMensajeLN("ingrese el monto a pagar");
           m = Consola.leerDouble();
           if(!validarMonto(m)){
               Consola.emitirMensajeLN("ingreso incorrecto , intente nuevamente");
           }
        }while(!validarMonto(m));
        setMonto(m);
    }
    
    private boolean validarMonto(double m){
        return m >= 0;
    }
    
    public abstract void procesar();   

    @Override
    public String toString() {
        return "Monto : "+monto;
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }

        
    
   
}

