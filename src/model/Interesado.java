
package model;

public class Interesado {
    private String nombre;
    private String dni;

    public Interesado(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}
