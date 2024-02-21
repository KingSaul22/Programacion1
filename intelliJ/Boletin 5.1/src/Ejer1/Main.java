package Ejer1;

import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Alumno a = new Alumno("Saul", "123");
        Equipo equipoA = new Equipo("Miravent");
        System.out.println(equipoA);
        System.out.print("\nAñadimos un jugador a equipo:");
        try {
            equipoA.addAlumno(a);
            System.out.println(equipoA);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nPreguntamos si el alumno se encuentra dentro del equipo:");
        System.out.println("El jugador " + a.getNombre() + (equipoA.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipoA.getNombre());

        System.out.println("\nRemovemos al jugador del equipo:");
        try {
            equipoA.removeAlumno(a);
            System.out.println("El jugador " + a.getNombre() + (equipoA.haveAlumno(a) == null ? " no" : " si") + " pertenece al equipo " + equipoA.getNombre());
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            equipoA.addAlumno(new Alumno("Pepe", "75838547"));
            equipoA.addAlumno(a);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n\nMétodo imprimir Personas en EquipoA");
        imprimirConjuntoPersonas(equipoA.getAlumnos());

        Equipo equipoB = new Equipo("Mirabent");
        try {
            equipoB.addAlumno(new Alumno("Sebas", "jhfdjdjkd"));
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nMétodo imprimir Personas en EquipoB");
        imprimirConjuntoPersonas(equipoB.getAlumnos());
        System.out.println();

        Equipo equipoC = null;
        try {
            equipoB.addAlumno(new Alumno("Pepe", "75838547"));
            equipoC = equipoA.interseccionEquipo(equipoB);
        } catch (AlumnoException e) {
            throw new RuntimeException(e);
        }
        System.out.println(equipoC);

        equipoC = null;
        try {
            equipoC = equipoA.unionEquipo(equipoB);
        } catch (AlumnoException e) {
            throw new RuntimeException(e);
        }
        System.out.println(equipoC);
    }

    private static void imprimirConjuntoPersonas(Set<Alumno> alumnos){
        Iterator<Alumno> it = alumnos.iterator();
        while(it.hasNext()) System.out.println(it.next());
    }
}
