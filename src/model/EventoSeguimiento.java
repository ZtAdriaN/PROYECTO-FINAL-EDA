import java.time.LocalDateTime;

public class EventoSeguimiento {
    private String estado;
    private String observacion;
    private LocalDateTime fecha;

    public EventoSeguimiento(String estado, String observacion) {
        this.estado = estado;
        this.observacion = observacion;
        this.fecha = LocalDateTime.now();
    }

    public String getEstado() { return estado; }
    public String getObservacion() { return observacion; }
    public LocalDateTime getFecha() { return fecha; }

    @Override
    public String toString() {
        return "[" + fecha + "] " + estado + ": " + observacion;
    }
}