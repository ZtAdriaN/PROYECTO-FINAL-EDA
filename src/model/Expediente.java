
package model;

import java.time.LocalDateTime;

public class Expediente implements Comparable<Expediente> {
    
    private String id;
    private String prioridad; // Alta, Media, Baja
    private String asunto;
    private Documento documento;
    private Interesado interesado;
    private Dependencia dependencia;
    private LocalDateTime fechaHoraInicio;
    private boolean finalizado;
    private LocalDateTime fechaHoraFin; 

    public Expediente(String id, String prioridad, String asunto, Documento documento,
                      Interesado interesado, Dependencia dependencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.asunto = asunto;
        this.documento = documento;
        this.interesado = interesado;
        this.dependencia = dependencia;
        this.fechaHoraInicio = LocalDateTime.now();
        this.finalizado = false;
    }

    public String getId() {
        return id;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getAsunto() {
        return asunto;
    }

    public Documento getDocumento() {
        return documento;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void marcarFinalizado() {
        this.finalizado = true;
        this.fechaHoraFin = LocalDateTime.now();
    }
    

    @Override
    public String toString() {
        return id + " - " + prioridad + " - " + asunto;
    }

    @Override
    public int compareTo(Expediente o) {
        return this.fechaHoraInicio.compareTo(o.fechaHoraInicio);
    }
}
