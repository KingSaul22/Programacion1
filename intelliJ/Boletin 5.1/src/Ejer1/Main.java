package Ejer1;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Saul", "123");
        Equipo equipo = new Equipo("Miravent");
        System.out.println(equipo);
        System.out.print("\nAñadimos un jugador a equipo:");
        try {
            equipo.addAlumno(a);
            System.out.println(equipo);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nPreguntamos si el alumno se encuentra dentro del equipo:");
        System.out.println("El jugador " + a.getNombre() + (equipo.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipo.getNombre());

        System.out.println("\nRemovemos al jugador del equipo:");
        try {
            equipo.removeAlumno(a);
            System.out.println("El jugador " + a.getNombre() + (equipo.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipo.getNombre());
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }
    }
}
