public class NodoArbol<T extends Comparable<T>> {
    
    public T valor;
    public NodoArbol<T> izq, der;
    
    public NodoArbol(T valor) {
        this.valor = valor;
    }
}