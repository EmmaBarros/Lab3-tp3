package ED;

public class ListaOrdenada<T extends Comparable<T>> extends Lista<T>{

    public ListaOrdenada() {
        super();
    }

    public void insertarMedio(Nodo<T> p, Nodo<T> ant, Nodo<T> x) {
        x.setPs(p);
        ant.setPs(x);
    }

    public void insertarFin(Nodo<T> ant, Nodo<T> p, Nodo<T> x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }

    public void insertar(T entrada) {
        Nodo<T> p = inicio();
        Nodo<T> ant = null;
        int b = 0;

        while (p != null && b == 0) {
            if (p.getDato().compareTo(entrada) > 0 ){
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo<T> x = new Nodo(entrada);
        if (b == 1) {
            if (p == list) {
                insertarPri(entrada);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, p, x);
            }
        }
    }

    public Nodo eliminar(T elem) {
        Nodo<T> x = null;
        Nodo<T> p = inicio();
        Nodo<T> ant = null;
        if (listaVacia()) {
            prt("Lista Vacía!!!");
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().compareTo(elem) >= 0) {
                if (p.getDato().equals(elem)) {
                    x = quitar(p, ant);
                    band = true;
                } else {
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {

            prt("Elemento eliminado!");
        } else {
            prt("Elemento inexistente!!!");
        }
        return x;
    }
}
