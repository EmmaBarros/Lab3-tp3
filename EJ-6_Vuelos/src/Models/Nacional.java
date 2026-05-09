
package Models;
import Consola.Consola;
import Validar.Validar;
/**
 *
 * @author emami
 */
public class Nacional extends Vuelos
{
   private double impuestoProvincial;

    public Nacional() {
        super();
    }

  
    
    @Override
    public void cargarDatos(){
        super.cargarDatos();
        ingresarImpuestoProv(); 
    }
    
    private void ingresarImpuestoProv(){
        double imp;
        do{
            Consola.emitirMensajeLN("ingresar el impuesto Provincial del vuelo N°"+this.getId()+" hacia Destino :"+this.getDestino());
            imp = Consola.leerDouble();
            if(!Validar.validarDouble(imp)){
                Consola.emitirMensajeLN("Impuesto incorrecto , por favor ingrese un impuesto valido...");
            }
        }while(!Validar.validarDouble(imp));
        setImpuestoProvincial(imp);
    }
    
    @Override
    public void actualizarReservas() {
        reservarVuelo();
    }
    private double calcularMontoTotal(){
        return this.getMonto() + this.impuestoProvincial;
    }
    
    @Override
    public void generarInforme() {
        Consola.emitirMensajeLN("Vuelo Nacional");
        Consola.emitirMensajeLN("- Numero de Vuelo"+this.getId()+"\t\t - Monto :"+this.getMonto()+"\t - Impuesto: "+impuestoProvincial+"\t - Total :"+ calcularMontoTotal());
        Consola.emitirMensajeLN("- Origen : "+this.getOrigen()+"\t\t- Destino : "+this.getDestino());
        Consola.emitirMensajeLN("- Cantidad de Plazas :"+this.getCantPlaza()+"\t\t- Cantidad de Reservas :"+this.getCantReserva());
        Consola.emitirMensajeLN("--------------------------------------");
    }

    public double getImpuestoProvincial() {
        return impuestoProvincial;
    }

    private void setImpuestoProvincial(double impuestoProvincial) {
        this.impuestoProvincial = impuestoProvincial;
    }

    

    
  
    
    
}
