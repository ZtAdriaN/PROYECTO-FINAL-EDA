public class Cola<T> {
    private Nodo<T> frente, fin;
    public void encolar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (fin == null) frente = fin = nuevo;
        else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }
    public T desencolar() {
        if (frente == null) return null;
        T valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return valor;
    }
}