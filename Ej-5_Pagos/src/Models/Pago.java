
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
    
    public abstract void mostrarInfo();
    public abstract boolean procesar(); 
    
    
    @Override 
    public void mostrarComprobante(Persona cliente){
        Consola.emitirMensajeLN("------Comprobante de Pago------");
        Consola.emitirMensajeLN("Cliente :"+cliente.getNom()+"-"+cliente.getApe());
        Consola.emitirMensajeLN("DNI :"+cliente.getDni());
        Consola.emitirMensajeLN("------------------------");
        Consola.emitirMensajeLN("DETALLE de operacion");
        this.mostrarInfo();
        Consola.emitirMensajeLN("Monto Total : $"+this.monto);
        Consola.emitirMensajeLN("-------------------------------");
    }

    @Override
    public String toString() {
        return "Monto : $"+monto;
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }

        
    
   
}

