
package tda;

public class ListaDoble<T> {
    
    private NodoDoble<T> cabeza;

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDoble<T> nodo) {
        this.cabeza = nodo;
    }

    public void agregar(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoDoble<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }
}
