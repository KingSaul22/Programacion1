package Obj_Ejer2.Model;

import Obj_Ejer2.Enums.TSalud;

import java.time.LocalDateTime;

public class ChequeoSalud {
    private LocalDateTime fechaHora;
    private TSalud estadoSalud;

    public ChequeoSalud(TSalud estadoSalud) {
        this.fechaHora = LocalDateTime.now();
        this.estadoSalud = estadoSalud;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public TSalud getEstadoSalud() {
        return estadoSalud;
    }
}
