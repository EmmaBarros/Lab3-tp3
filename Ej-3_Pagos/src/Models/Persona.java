
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Persona {
 private String nom;
 private String ape;
 private int  dni;

    public Persona(String nom, String ape, int dni) {
        this.nom = nom;
        this.ape = ape;
        this.dni = dni;
    }

    public Persona() {
    }
    public void CargarDatos(){
        ingresarNombre();
        ingresarApellido();
        ingresarDni();
    }
    private void ingresarNombre(){
      String n;
        do {
            Consola.emitirMensaje("Nombre: ");
            n = Consola.leerDato();
            if (!validarString(n)) {
                Consola.emitirMensajeLN("Carga invalida , ingrese un nombre...");
            }
        } while (!validarString(n));
        setNom(n);  
    }
    private void ingresarApellido(){
        String a;
        do {
            Consola.emitirMensaje("Apellido: ");
            a = Consola.leerDato();
            if (!validarString(a)) {
                Consola.emitirMensajeLN("Carga invalida , ingrese un apellido");
            }
        } while (!validarString(a));
        setApe(a);
    }
    private void ingresarDni(){
        int d;
        do {
            Consola.emitirMensaje("DNI: ");
            d = Consola.leerInt();
            if (!validarInt(d)) {
                Consola.emitirMensajeLN("Carga invlida , ingerese un Dni");
            }
        } while (!validarInt(d));
        setDni(d);
    }
        
    private boolean validarString(String n){
         return  n != null && !n.trim().isEmpty() ;
    }    
    private boolean validarInt(int x){
        return x >= 0;
    }  

    
    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    private void setApe(String ape) {
        this.ape = ape;
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }
 
 @Override
    public String toString() {
        return ape + ", " + nom + " | DNI: " + dni;
    }
        
}
