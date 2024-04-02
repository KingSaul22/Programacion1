package Ejer2;

public class Furgoneta extends Vehiculo {
    private static final double PRECIO_KILO = 0.5;
    private int pma;

    public Furgoneta(String matricula, Gama gama, int pma) throws VehiculoException {
        super(matricula, gama);
        setPma(pma);
    }

    private void setPma(int pma) throws VehiculoException {
        if (pma < 1) {
            throw new VehiculoException("PMA invalido");
        }

        this.pma = pma;
    }

    @Override
    public double getPrecioDiario() {

        return getGama().getPrecioBaseDia() + PRECIO_KILO * pma;
    }

    @Override
    public String toString() {
        return "\nFurgoneta con mátricula '" + getMatricula() +
                "'\n  · Gama: " + getGama() +
                "\n  · PMA: " + pma;
    }
}
