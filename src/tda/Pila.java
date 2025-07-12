public class Pila<T> {
    
    private Nodo<T> tope;
    
    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        nuevo.siguiente = tope;
        tope = nuevo;
    }
    
    public T desapilar() {
        if (tope == null) return null;
        T valor = tope.valor;
        tope = tope.siguiente;
        return valor;
    }
}