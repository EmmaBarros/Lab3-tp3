package ED;


public class Nodo <T> {

    private T dato;
    private Nodo<T> ps;

    public Nodo(T elem) {
        dato = elem;
        ps = null;
    }

    /**
     * @return el dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato el dato a establecer
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return el ps
     */
    public Nodo<T> getPs() {
        return ps;
    }

    /**
     * @param ps el ps a establecer
     */
    public void setPs(Nodo<T> ps) {
        this.ps = ps;
    }

}
