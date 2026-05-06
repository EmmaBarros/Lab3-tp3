
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Cliente extends Persona {
    private static int contadorId = 0;
    private int idCliente;
    private double saldo;
   

    public Cliente(int idCliente, String nom, String ape, int dni) {
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
        ingresarSaldo();
        Consola.emitirMensajeLN("ID asignado :"+ this.idCliente);
    }
    private void ingresarSaldo(){
        double saldo;
        do{
            Consola.emitirMensajeLN("ingrese el saldo en la cuenta del cliente");
            saldo = Consola.leerDouble();
            if(!validarDouble(saldo)){
                Consola.emitirMensajeLN("ingreso de saldo incorrecto , intente nuevamente...");
            }
        }while(!validarDouble(saldo));
        setSaldo(saldo);
    }
    
    private boolean validarDouble(double x){
        return x >= 0;
    }
    
    public void descontarSaldo(double monto){
        this.saldo = this.saldo - monto;
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

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    
    
}
