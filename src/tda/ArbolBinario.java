public class ArbolBinario<T extends Comparable<T>> {
    
    private NodoArbol<T> raiz;
    
    public void insertar(T valor) {
        raiz = insertarRec(raiz, valor);
    }
    
    private NodoArbol<T> insertarRec(NodoArbol<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoArbol<>(valor);
        }
        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izq = insertarRec(nodo.izq, valor);
        } else {
            nodo.der = insertarRec(nodo.der, valor);
        }
        return nodo;
    }
    
    public void inOrden() {
        inOrdenRec(raiz);
    }
    
    private void inOrdenRec(NodoArbol<T> nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izq);
            System.out.println(nodo.valor);
            inOrdenRec(nodo.der);
        }
    }
}