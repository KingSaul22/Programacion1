package Extra1;


public class Avion {
    private String marca, modelo;
    private double consumo, distancia;
    private Deposito deposito;
    private static final int MAX_REVISIONES = 10;
    private Revision[] revisiones;

    public Avion(Deposito deposito, double consumo, String marca, String modelo) {
        this.revisiones = new Revision[MAX_REVISIONES];
        this.deposito = deposito;
        this.consumo = consumo;
        this.marca = marca;
        this.modelo = modelo;
        this.distancia = 20000;

    }

    public void addRevision(Revision newRevision) {
        for (int i = 0; i < revisiones.length; i++) {

            if (revisiones[i] == null) {
                this.revisiones[i] = newRevision;
                //i = revisiones.length;
                break;
            }
        }
    }

    public Revision getUltimaRevision() {
        if (revisiones[0] == null) return null;

        for (int i = 1; i < revisiones.length; i++) {
            if (revisiones[i] == null) return revisiones[i - 1];
        }

        return revisiones[MAX_REVISIONES - 1];
    }

    public boolean puedeVolar(double distancia){
        return (deposito.cantidadActual / consumo) > distancia;
    }

    @Override
    public String toString() {
        return "\nEl avión de la marca " + marca + " y con el modelo " + modelo
                + ":\n ·Tiene un consumo de " + consumo + "Kg/Km"
                + "\n ·Con el deposito actual completo a un " + deposito
                + "%\n ·" + (revisiones[0] == null ? "No se le han realizado revisiones" : "%\n ·Y su última revisión fue el " + getUltimaRevision() + ".")
                + (puedeVolar(distancia) ? "\n ·El avión SI puede volar." : "\n ·El avión NO puede volar");
    }
}
