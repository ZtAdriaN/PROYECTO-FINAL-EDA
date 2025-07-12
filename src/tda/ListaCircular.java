public class ListaCircular<T> {
    
    private Nodo<T> ultimo;
    
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (ultimo == null) {
            ultimo = nuevo;
            /*ultimo.siguiente = nuevo;*/
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    
    public void mostrarUnaVuelta() {
        if (ultimo == null) return;
        Nodo<T> actual = ultimo.siguiente;
        do {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
    }
}