
package Models;
import Consola.Consola;
import Validar.Validar;
/**
 *
 * @author emami
 */
public class Internacional extends Vuelos{
    private double impuestoAduana;
    private String paisDest;

    public Internacional() {
        super();
    }
    
    
    @Override 
    public void  cargarDatos(){
        super.cargarDatos();
        ingresarImpuestoAduana();
        ingresarPaisDestino();
    }
    
    private void ingresarImpuestoAduana(){
        double imp;
        do{
            Consola.emitirMensajeLN("ingresar el impuesto de Aduana del vuelo N°"+this.getId()+" hacia Destino :"+this.getDestino());
            imp = Consola.leerDouble();
            if(!Validar.validarDouble(imp)){
                Consola.emitirMensajeLN("Impuesto incorrecto , por favor ingrese un impuesto valido...");
            }
        }while(!Validar.validarDouble(imp));
        setImpuestoAduana(imp);
    }
    
    private void ingresarPaisDestino(){
        String pais;
        do{
            Consola.emitirMensajeLN("ingrese el nombre del pais de destino");
            pais = Consola.leerString();
            if(!Validar.validarString(pais)){
                Consola.emitirMensajeLN("incorrecto por favot ingrese nuevamente...");
            }
        }while(!Validar.validarString(pais));
        setPaisDest(pais);
    }
    private double calcularMontoTotal(){
        return this.getMonto() + this.impuestoAduana;
    }
    
    @Override
    public void actualizarReservas() {
        super.reservarVuelo();
    }

    @Override
    public void generarInforme() {
        Consola.emitirMensajeLN("Vuelo Internacional");
        Consola.emitirMensajeLN("- Numero de Vuelo"+this.getId()+"\t\t - Monto :"+this.getMonto()+"\t - Impuesto: "+impuestoAduana+"\t - Total :"+ calcularMontoTotal());
        Consola.emitirMensajeLN("- Origen : "+this.getOrigen()+"\t\t- Destino : "+this.getDestino()+"\t Pais :"+this.paisDest);
        Consola.emitirMensajeLN("- Cantidad de Plazas :"+this.getCantPlaza()+"\t\t- Cantidad de Reservas :"+this.getCantReserva());
        Consola.emitirMensajeLN("--------------------------------------");
    }

    public double getImpuestoAduana() {
        return impuestoAduana;
    }

    private void setImpuestoAduana(double impuestoAduana) {
        this.impuestoAduana = impuestoAduana;
    }

    public String getPaisDest() {
        return paisDest;
    }

    private void setPaisDest(String paisDest) {
        this.paisDest = paisDest;
    }
    
    
}
