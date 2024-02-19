package Ejer1;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Saul", "123");
        Equipo equipo = new Equipo("Miravent");
        try {
            equipo.addAlumno(a);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(equipo);
    }
}
