package ExamenRecuperacionObjeto.model;

public class CajaCambios {
    public static final int MIN_MARCHA = 1, MAX_MARCHA = 7;

    int numeroVelocidades;
    boolean estado;


    public boolean isFuncional() {
        return estado;
    }
}
