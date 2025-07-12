
package tda;
import model.Expediente;

public class ListaDobleExpedientes {
    
    private static ListaDoble<Expediente> lista = new ListaDoble<>();

    public static void agregar(Expediente exp) {
        lista.agregar(exp);
    }

    public static ListaDoble<Expediente> obtener() {
        return lista;
    }
}
