package Ejer2;

public class Paciente {
    public static final byte MIN_PRIORIDAD = 1;
    public static final byte MAX_PRIORIDAD = 5;
    private String DNI;
    private String nombre;
    private byte prioridad, edad;

    public Paciente(String DNI, String nombre, byte prioridad, byte edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.edad = edad;
    }

    
}
