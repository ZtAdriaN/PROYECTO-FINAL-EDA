package tda;
public class NodoDoble<T> {
    
    public T valor;
    public NodoDoble<T> siguiente;
    public NodoDoble<T> anterior;

    public NodoDoble(T valor) {
        this.valor = valor;
    }
}
