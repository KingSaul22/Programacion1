package Ejer1;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Equipo {
    private String nombre;
    private Set<Alumno> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public void addAlumno(Alumno alumno) throws AlumnoException {
        if (!alumnos.add(alumno)) throw new AlumnoException("El alumno ya está incluido en el equipo");
    }

    public void removeAlumno(Alumno alumno) throws AlumnoException {
        if (!alumnos.remove(alumno)) throw new AlumnoException("El alumno no existe en el equipo");
    }

    public Alumno haveAlumno(Alumno alumno) {
        return alumnos.contains(alumno) ? alumno : null;
    }

    public Equipo unionEquipo(Equipo equipoB) throws AlumnoException {
        Equipo union = new Equipo(nombre + " U " + equipoB.nombre);
        union.alumnos.addAll(alumnos);
        union.alumnos.addAll(equipoB.alumnos);

        return union;
    }

    public Equipo interseccionEquipo(Equipo equipoB) throws AlumnoException {
        Equipo union = new Equipo(nombre + " I " + equipoB.nombre);

        union.alumnos.addAll(alumnos);
        union.alumnos.retainAll(equipoB.alumnos);

        /*for (Alumno a : equipoB.alumnos){
            if (alumnos.contains(a)) union.addAlumno(a);
        }*/

        return union;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public String toString() {
        return "\nEl equipo " + nombre + getDatosAlumnos();
    }

    private String getDatosAlumnos() {
        String base = ", ha reclutado a los siguientes alumnos:\n";
        StringBuilder cadena = new StringBuilder(base);

        for (Alumno alumno : alumnos) {
            cadena.append("  ").append(alumno.toString()).append("\n");
        }

        /*Iterator<Alumno> iterador = alumnos.iterator();
        while(iterador.hasNext()) {
            cadena.append("  ").append(iterador.next().toString()).append("\n");
        }*/

        return base.contentEquals(cadena) ? ", no ha reclutado a ningun alumno." : cadena.toString();
    }


    public String getNombre() {
        return nombre;
    }
}
