
package Models;
import Consola.Consola;
import Validar.Validar;
/**
 *
 * @author emami
 */
public class Comercio extends Vuelos {
    private String nomCarga; //el tipo de carga que sera 
    private double peso;

    public Comercio() {
        super();
    }

    @Override
    public void cargarDatos(){
        super.cargarDatos();
        ingresarNomCarga();
        ingresarPeso();
    }
    
    private void ingresarNomCarga(){
        String nom;
        do{
            Consola.emitirMensajeLN("ingrese el nombre de la carga ");
            Consola.emitirMensajeLN("(Textil | Combustible | Comestible etc.)");
            nom = Consola.leerDatoString();
            if(!Validar.validarString(nom)){
                Consola.emitirMensajeLN("ingreso incorrecto , por favor vuelva a ingresar nuevamente...");
            }
        }while(!Validar.validarString(nom));
        setNomCarga(nom);
    }
    
    private void ingresarPeso(){
        double pes;
        do{
            Consola.emitirMensajeLN("ingrese el peso de carga del vuelo N°: "+this.getId());
            Consola.emitirMensajeLN("Peso Maximo Soportado : 18.000 Kg");
            pes  = Consola.leerDouble();
            if(!Validar.ValidarDoubleRang(pes, 0,18000 )){
                Consola.emitirMensajeLN("ingreso incorrecto , por favor ingrese un peso soportable");
            }
        }while(!Validar.ValidarDoubleRang(pes, 0, 18000));
        setPeso(pes);
    }
    
    @Override
    public void actualizarReservas() {
        super.reservarVuelo();
    }

    @Override
    public void generarInforme() {
        Consola.emitirMensajeLN("Vuelo De Carga");
        Consola.emitirMensajeLN("- Numero de Vuelo"+this.getId()+"\t\t - Monto :"+this.getMonto());
        Consola.emitirMensajeLN("- Origen : "+this.getOrigen()+"\t\t- Destino : "+this.getDestino());
        Consola.emitirMensajeLN("- Cantidad de Plazas :"+this.getCantPlaza()+"\t\t- Cantidad de Reservas :"+this.getCantReserva()+"- Carga: "+this.nomCarga+"- Peso: "+this.peso);
        Consola.emitirMensajeLN("--------------------------------------");
    
    }

    public String getNomCarga() {
        return nomCarga;
    }

    private void setNomCarga(String nomCarga) {
        this.nomCarga = nomCarga;
    }

    public double getPeso() {
        return peso;
    }

    private void setPeso(double peso) {
        this.peso = peso;
    }
    
    
    
    
}
