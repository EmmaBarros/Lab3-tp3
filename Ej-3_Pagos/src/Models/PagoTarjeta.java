package Models;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class PagoTarjeta extends Pago {
    private Cliente clienteAsociado;
    private int nroTarjeta;
    
   

    public PagoTarjeta(Cliente clAct) {
        super();
        this.clienteAsociado = clAct;
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
      if(this.monto <= clienteAsociado.getSaldo()){
          Consola.emitirMensajeLN("Pago con Tarjeta Realizado Exitosamente ...");
          return true;
      }else{
          Consola.emitirMensajeLN("Error Saldo insuficiente");
          return false;
      }
   }

    @Override
    public String toString() {
        return super.toString()+"Pago : Tarjeta";
    }

    @Override
    public void mostrarComprobante(Persona cliente) {
        super.mostrarComprobante(cliente);
        Consola.emitirMensajeLN("Nro Tarjeta : "+this.nroTarjeta);
        Consola.emitirMensajeLN("Pago aprobado");
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    private void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    @Override
    public void mostrarInfo() {
       this.toString();
    }
    
   
}
