package Models;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class PagoTarjeta extends Pago {
    private double saldoDisp;
    private int nroTarjeta;
    
    public PagoTarjeta(double monto) {
        super(monto);
    }

    public PagoTarjeta() {
        super();
    }
    
    public void cargarDatos(){
        super.cargarDatos();
        ingresarNro();
    }
    
    private void ingresarNro(){
    int nro;
    do{
        Consola.emitirMensajeLN("ingrese el numero de la tarjeta");
        nro = Consola.leerInt();
        if(!validarNroTarjeta(nro)){
            Consola.emitirMensajeLN("numero invalido , por favor seleccione un numero positivo");
        }
    }while(!validarNroTarjeta(nro));
    setNroTarjeta(nro);
    }
    
    private boolean validarNroTarjeta(int nro){
        return nro > 0 ;
    }
     
   @Override
   public boolean procesar(){
       return true;
   }

    @Override
    public String toString() {
        return super.toString()+"Pago : Tarjeta";
    }

    @Override
    public void mostrarComprobante(Persona cliente) {
        
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    private void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }
    
   
}
