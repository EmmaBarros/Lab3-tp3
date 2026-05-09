
package Controllers;
import ED.*;
import Models.*;
import Menu.Menu;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class GestorVuelos <T extends Vuelos> {
    Lista<Vuelos> lista;
    private Menu menuPrincipal;
    private Menu menuGenerar;

    
    public GestorVuelos() {
    this.lista = new Lista<>();
    
      //menu principal del programa
       this.menuPrincipal = new Menu("Menu Principal");
       menuPrincipal.agregarItem("Generar Vuelos");
       menuPrincipal.agregarItem("Actualizar reservas");
       menuPrincipal.agregarItem("Informe de Vuelos");
       
       //menu solo de agregar como sub menu por tipos de vuelos
       this.menuGenerar = new Menu("Agregar Vuelo");
       menuGenerar.agregarItem("Nacinal");
       menuGenerar.agregarItem("Internacional");
       menuGenerar.agregarItem("Comercio");           
    }
    
     //opciones del sistema segun enunciado 
     //con el uso del menu y sub menu 
    
    public void ejecutar(){
        int op;
        do{
            op = menuPrincipal.ejecutar();
            switch(op){
                case 1:
                    abrirMenuCarga();
                    break;
                case 2:
                   actualizarReserva();
                    break;
                case 3:
                    mostrarInformes();
                    break;
            }
        }while(op!=0);
    }
    
    //menu para carga de vuelos segun su tipo
    public void abrirMenuCarga(){
       int tipo = menuGenerar.ejecutar();       
       switch(tipo){
           case 1:
               agregarVuelo(new Nacional());
               break;
           case 2:
               agregarVuelo(new Internacional());
               break;
           case 3:
               agregarVuelo(new Comercio());
               break;
       }
    }
    
    //metodos de menu 
   
    private void agregarVuelo(Vuelos v){
        v.cargarDatos();
        lista.insertarPri(v);
        Consola.emitirMensajeLN("vuelo generado exitosamente con Id :"+v.getId());        
    }
    //busca un vuelo y lo retorna de tipo vuelo si lo encuentra , en caso contrario retorna 
   
    private Vuelos buscarPorId(int id){
        //obtenemos el inicio de la lista con un nodo 
      Nodo<Vuelos> p = lista.inicio();
      while(p!=null){
          //obtenemos el dato (el vuelo) del nodo
          Vuelos v = p.getDato();
          if(v.getId() == id){//peregunta y retorna
              return v;
          }
          p = p.getPs();
      }
      return null; // retorna null si no lo encuentra
    }
    
    //actualizar reserva
    //utilizar el metodo de busqueda por id
    public void actualizarReserva(){
        Consola.emitirMensajeLN("ingrese el ID del vuelo a actualizar:");
        int idBuscado = Consola.leerInt();
        //se busca el vuelo y se guarda en una variable
        Vuelos encontrado = buscarPorId(idBuscado);
        
        //si existe se llama al actualziar reserva de la interface reservable desarrollado en Vuels 
        if(encontrado != null){
            encontrado.actualizarReservas();
            Consola.emitirMensajeLN("Reserva actalizada correctamente");
        }else{
            Consola.emitirMensajeLN("Error , no se encontro el vuelo con id"+idBuscado);
        }
        
    }
    
    //muestra , crea el nodo con el inicio de lista , obtiene el dato e llama al generarInforme
    
    private void mostrarInformes(){
        if(lista.listaVacia()){
            Consola.emitirMensajeLN("no hay vuelos registrados");
            return;
        }
        Nodo<Vuelos> p = lista.inicio();
        while(p != null){
            p.getDato().generarInforme();
            p = p.getPs();
        }
    }        
    
    
}
