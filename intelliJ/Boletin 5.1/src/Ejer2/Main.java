package Ejer2;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Saul", "123");
        Equipo equipoA = new Equipo("Miravent");
        System.out.println(equipoA);
        System.out.print("\nAñadimos un jugador a equipoA:");
        try {
            equipoA.addAlumno(a);
            System.out.println(equipoA);
        } catch (ElementoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nPreguntamos si el alumno se encuentra dentro del equipoA:");
        System.out.println("El jugador " + a.getNombre() + (equipoA.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipoA.getNombre());

        System.out.println("\nRemovemos al jugador del equipoA:");
        try {
            equipoA.removeAlumno(a);
            System.out.println("El jugador " + a.getNombre() + (equipoA.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipoA.getNombre());
        } catch (ElementoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nCon Integer:");

        Integer b = 33;
        Equipo equipoB = new Equipo("Mirabent");
        System.out.println(equipoB);
        System.out.print("\nAñadimos un Integer a equipoB:");
        try {
            equipoB.addAlumno(b);
            System.out.println(equipoB);
        } catch (ElementoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nPreguntamos si el alumno se encuentra dentro del equipoB:");
        System.out.println("El jugador " + b + (equipoB.haveAlumno(b) == null ? " no" : " si") + " pertenece al equipo " + equipoB.getNombre());

        System.out.println("\nRemovemos al jugador del equipoB:");
        try {
            equipoB.removeAlumno(b);
            System.out.println("El jugador " + b + (equipoB.haveAlumno(b) == null ? " no" : " si") + " pertenece al equipo " + equipoB.getNombre());
        } catch (ElementoException e) {
            System.out.println(e.getMessage());
        }
    }
}
