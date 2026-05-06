
package Models;

public abstract class EstudioRealizado {
    private double costo;
    private double duracion;

    public EstudioRealizado() {
    }

    
    
    
    
  public abstract void calcularCosto();
  public abstract void MostrarInfo();
  
  
    
    @Override
    public String toString() {
        return "EstudioRealizado{" + "costo=" + costo + ", duracion=" + duracion + '}';
    }

    
   
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    
    
    
    
    
                                                                                                                                                                                                        
    
    
    
    
}
