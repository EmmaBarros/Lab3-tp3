
package Controllers;
import Models.*;
import ED.Lista;
import Menu.Menu;
import Consola.Consola;


public class GestorPagos {
    private Cliente clienteAct;
    private Lista<Pago> pagos;
    private double recaudacionTot;
    private Menu menu;

    public GestorPagos() {
    this.pagos = new Lista<>();
    this.recaudacionTot = 0;
    
    //menu
    this.menu = new Menu("Sistema De Gestion De Pagos");
    menu.agregarItem("Realizar Pago en Efectivo");
    menu.agregarItem("Realizar pago en Tarjeta");
    menu.agregarItem("Consultar Saldo y Datos del Cliente");
    
    }
    
    public void iniciar(){
        boolean sistemaActivo = true; //se abre la caja de antencion
        while(sistemaActivo){
            Consola.emitirMensajeLN("NUEVA ATENCION AL CLIENTE");
            this.clienteAct = new Cliente();
            this.clienteAct.CargarDatos();//se carga los datos del cliente actual antes de empezar
            
            
            int op;
            boolean atendiendo = true; //variable para el ciclo del menu;
            do{
                op = menu.ejecutar();
                switch(op){
                    case 1:
                    PagoEfectivo pe = new PagoEfectivo();
                    pe.cargarDatos();
                    if(pe.procesar()){
                        finalizarOperacion(pe);
                        atendiendo = false; //pago listo , se pasa al siguiente cliente
                    }
                    break;
                    case 2:
                         PagoTarjeta pt = new PagoTarjeta(this.clienteAct);
                         pt.cargarDatos();
                         
                         if(pt.procesar()){//si el pago es exitoso se procesa y descuenta
                             this.clienteAct.descontarSaldo(pt.getMonto()); // se descuenta el saldo del clietne
                             finalizarOperacion(pt);
                             atendiendo = false; //pago listo , se pasa al siguiente clietne
                         }
                        break;
                    case 3:
                    mostrarEstadoActual();
                    break;
                    case 0:
                        //se sale del menu y se cierra el sistema
                        atendiendo = false;
                        sistemaActivo = false;
                        break;
                }
            }while(atendiendo);
        
        }
         emitirReporteFinal();
    
        
    }
    private void finalizarOperacion(Pago p){
        //se guarda la recaudacion del dia
        this.recaudacionTot += p.getMonto();
        
        //se guarda en la lista los pagos
        this.pagos.insertarPri(p);
        
        p.mostrarComprobante(this.clienteAct);// se muestra el comprobante con el uso de la interfaz Icomprobante
        
    }
    private void mostrarEstadoActual(){
        Consola.emitirMensajeLN("---INFORMACION DEL CLIENTE---");
        Consola.emitirMensajeLN("Nombre : "+ clienteAct.getNom() + "Apellido : "+clienteAct.getApe());
        Consola.emitirMensajeLN("Dni :" +clienteAct.getDni());
        Consola.emitirMensajeLN("Saldo Disponible $"+clienteAct.getSaldo());
    }
   private void emitirReporteFinal() {
        Consola.emitirMensajeLN("========================================");
        Consola.emitirMensajeLN("       CIERRE DE JORNADA");
        Consola.emitirMensajeLN("========================================");
        Consola.emitirMensajeLN("TOTAL RECAUDADO: $" + recaudacionTot);
        Consola.emitirMensajeLN("Cerrando sistema...");
        Consola.emitirMensajeLN("========================================\n");
    } 
    
}
