
package Menu;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Menu {
    private String Titulo;
    private  String[] items;
    private int cv;
    private final int MAX = 10;

    public Menu(String Titulo) {
        this.Titulo = Titulo;
        this.items = new String[MAX];
        this.cv = 0;
    }
    
    public void agregarItem(String opcion){
        if (cv < MAX) {
            items[cv] = opcion;
            cv ++;
        }else{
            Consola.emitirMensajeLN("no hay espacio suficiente para agregar");
        }
    }
    public void removerItem(String opcion){
        for (int i = 0; i < cv; i++) {
            if(items[i].equals(opcion)){
                for (int j = 0; j < cv; j++) {
                    items[j]=items[j+1];
                }
                items[cv-1]= null;
                cv --;
                Consola.emitirMensajeLN("elemento eliminado");
                return;
            }
        }
        Consola.emitirMensajeLN("no se encontro el elemento buscado");
    }    
    public void actualizarItem(String viejo,String nuevo){
         for (int i = 0; i < cv; i++) {
            if(items[i].equals(viejo)){
                items[i]=nuevo;
            }
        }
    }
 
    public void mostrarMenu(){
        Consola.emitirMensajeLN("\n--"+ Titulo +"--");
           if(cv == 0){
               Consola.emitirMensajeLN("el menu esta vacio o no a sido cargado");
           }else{
               for (int i = 0; i < cv; i++) {
                   Consola.emitirMensajeLN((i+1)+"."+items[i]);
               }
           }
     Consola.emitirMensajeLN("presione (0) para salir o volver...");
     Consola.emitirMensajeLN("Seleccione una opcion");
    }
    public int ejecutar(){
    int op ;
    do{
        mostrarMenu();
        op = Consola.leerInt();
        if (op < 0 || op > cv) {
            Consola.emitirMensajeLN("opcion invalida o fuera de rango de posibilidades...");
            op = -1;
        }
    }while(op==-1);
    return op;
    }
    
}
