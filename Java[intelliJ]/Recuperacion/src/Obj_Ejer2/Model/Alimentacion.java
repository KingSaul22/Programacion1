package Obj_Ejer2.Model;

import java.time.LocalDateTime;

public class Alimentacion {
    public enum TAlimentacion {
        NATURAL, SEMINATURAL, ARTIFICIAL
    }

    private TAlimentacion alimentacion;
    private LocalDateTime fechaHora;

    public Alimentacion(TAlimentacion alimentacion) {
        this.alimentacion = alimentacion;
        this.fechaHora = LocalDateTime.now();
    }

    public TAlimentacion getAlimentacion() {
        return alimentacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
