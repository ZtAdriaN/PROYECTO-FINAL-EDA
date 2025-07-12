
package model;

public class Documento {
    private String tipo;
    private String referencia;
    private String resultado;

    public Documento(String tipo, String referencia) {
        this.tipo = tipo;
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getReferencia() {
        return referencia;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return tipo + " - " + referencia;
    }
}
