
package Models;
import Consola.Consola;
import Validar.Validar;
import Controllers.Reservable;

/**
 *
 * @author emami
 */
public abstract class Vuelos implements Reservable{
    private int id;
    static int contId = 0;
    private String nomEmpresa;
    private int cantPlaza;
    private int cantReserva;
    private String origen;
    private String destino;
    private int tipoVueelo; 
    private double monto;
    //--

    public Vuelos() {
      contId ++;
      this.id = contId;
    }
    
    
   //-- 
   public abstract void actualizarReservas();
   public abstract void generarInforme();
   
   
   //ingreso y validacion de datos 
   
   public void cargarDatos(){
       ingresarNomEmpresa();
       ingresarCantPlaza();
       ingresarCantReserva();
       ingresarOrigen();
       ingresarDestino();
       ingresarMonto();
   }
   
   private void ingresarNomEmpresa(){
       String nom;
       do{
           Consola.emitirMensajeLN("ingrese el nombre de la empresa del vuelo");
           nom = Consola.leerString();
           if(!Validar.validarString(nom)){
               Consola.emitirMensajeLN("ingreso incorrecto , por favor ingresar un nombre...");
           }
       }while(!Validar.validarString(nom));
       setNomEmpresa(nom);
   } 
   
   private void ingresarCantPlaza(){
       int cant;
       do{
           Consola.emitirMensajeLN("ingrese la cantidad de plazas del vuelo");
           cant = Consola.leerInt();
           if(!Validar.validarInt(cant)){
               Consola.emitirMensajeLN("ingreso incorrecto , por favor ingrese una cantidad de plazas mayor a 0");
           }
       }while(!Validar.validarInt(cant));
       setCantPlaza(cant);
   } 
   
  private void ingresarCantReserva(){
      int cant;
    do {
        Consola.emitirMensaje("Ingrese reservas actuales del vuelo N° " + this.id );
        cant = Consola.leerInt();
        
        // se contorla que no supere las plazas
        if (!Validar.validarInt(cant) || cant > this.cantPlaza) {
            Consola.emitirMensajeLN("Error: Cantidad invalida o supera el total de plazas " + this.cantPlaza);
        }
    } while (!Validar.validarInt(cant) || cant > this.cantPlaza);
    this.cantReserva = cant;
  }
  
  private void ingresarOrigen(){
       String origen;
       do{
           Consola.emitirMensajeLN("ingrese el nombre de la ciudad de origen del vuelo N°:"+this.id);
           origen = Consola.leerString();
           if(!Validar.validarString(origen)){
               Consola.emitirMensajeLN("ingreso incorrecto , por favor ingresar un nombre...");
           }
       }while(!Validar.validarString(origen));
       setOrigen(origen);
  }
  private void ingresarDestino(){
        String origen;
       do{
           Consola.emitirMensajeLN("ingrese el nombre de la ciudad de Destino del vuelo N°:"+this.id);
           origen = Consola.leerString();
           if(!Validar.validarString(origen)){
               Consola.emitirMensajeLN("ingreso incorrecto , por favor ingresar un nombre...");
           }
       }while(!Validar.validarString(origen));
       setDestino(origen);
  }  
  private void ingresarMonto(){
      double monto;
      do{
          Consola.emitirMensajeLN("ingrese el monto del vuelo N°"+this.id+"con origen a: "+this.destino);
          monto = Consola.leerDouble();
          if(!Validar.validarDouble(monto)){
              Consola.emitirMensajeLN("ingreso de monto incorrecto , por favor ingrese un monto valido");
          }
      }while(!Validar.validarDouble(monto));
      setMonto(monto);
  }
  
  
  
    @Override
    public void reservarVuelo() {
        
 
    if (this.cantReserva < this.cantPlaza) {
        this.cantReserva++; 
        Consola.emitirMensajeLN("Vuelo " + this.id + " reservado con exito!");
    } else {
        Consola.emitirMensajeLN("Error: El vuelo " + this.id + " ya no tiene plazas disponibles.");
    }
    }
    
    
   //gtt y stt

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    private void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public int getCantPlaza() {
        return cantPlaza;
    }

    private void setCantPlaza(int cantPlaza) {
        this.cantPlaza = cantPlaza;
    }

    public int getCantReserva() {
        return cantReserva;
    }

    private void setCantReserva(int cantReserva) {
        this.cantReserva = cantReserva;
    }

    public String getOrigen() {
        return origen;
    }

    private void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    private void setDestino(String destino) {
        this.destino = destino;
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Vuelos" + "id : " + id + ", nomEmpresa=" + nomEmpresa + ", cantPlaza=" + cantPlaza + ", cantReserva=" + cantReserva + ", origen=" + origen + ", destino=" + destino + ", monto=" + monto + '}';
    }
    
    
    

            
}
