package Extra1;

import java.time.LocalDateTime;

public class Revision {
    private boolean estado;
    private LocalDateTime fecha;
    private int validezMes;


    public Revision(LocalDateTime fecha, int duracionValidez) {

        if (fecha.isBefore(LocalDateTime.now())) {
            this.fecha = fecha;

            if (getValidezMes() > 0) {
                this.estado = true;
            }

            this.validezMes = duracionValidez;
        }


    }

    public int getValidezMes() {//TODO continuar aquí.
        LocalDateTime auxFecha ? : ;

        return;
    }

    public LocalDateTime getFecha() {

        return fecha;
    }

    @Override
    public String toString() {
        String condicion = estado ? "satisfactorio y con una validez de " + validezMes : "negativo";
        return fecha + " con resultado " + condicion;
    }
}
