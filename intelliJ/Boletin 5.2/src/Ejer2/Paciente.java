package Ejer2;

public class Paciente implements Comparable<Paciente> {
    public static final byte MIN_PRIORIDAD = 1;
    public static final byte MAX_PRIORIDAD = 5;
    private String DNI;
    private String nombre;
    private int prioridad, edad, ordenLlegada;

    public Paciente(String DNI, String nombre, int prioridad, int edad, int ordenLlegada) throws HospitalException {
        setPrioridad(prioridad);
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.ordenLlegada = ordenLlegada;
    }

    public void setPrioridad(int prioridad) throws HospitalException {
        if (prioridad < MIN_PRIORIDAD || prioridad > MAX_PRIORIDAD) {
            throw new HospitalException("Valor de prioridad invalido");
        }
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente other) {
        /*if (prioridad != other.prioridad){
            return prioridad - other.prioridad;
        }
        return ordenLlegada - other.ordenLlegada;*/

        return prioridad != other.prioridad ? prioridad - other.prioridad
                                            : ordenLlegada - other.ordenLlegada;
    }
}
