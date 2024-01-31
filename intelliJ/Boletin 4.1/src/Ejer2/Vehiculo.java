package Ejer2;

public abstract class Vehiculo {
    private String matricula;
    private Gama gama;

    public Vehiculo(String matricula, Gama gama) {

        this.matricula = matricula;
        this.gama = gama;
        //setAlquiler();
    }

    public String getMatricula() {
        return matricula;
    }

    public Gama getGama() {
        return gama;
    }

    /*public void setAlquiler() {

    }*/

    public abstract double getPrecioDiario();
    public double getPrecioAlquiler(int dias) {

        return getPrecioDiario() * dias;
    }

}
