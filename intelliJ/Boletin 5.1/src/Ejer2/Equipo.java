package Ejer2;

import java.util.HashSet;
import java.util.Set;

public class Equipo<T> {
    private String nombre;
    private Set<T> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public void addAlumno(T alumno) throws ElementoException {
        if (!alumnos.add(alumno)) throw new ElementoException("El alumno ya está incluido en el equipo");
    }

    public void removeAlumno(T alumno) throws ElementoException {
        if (!alumnos.remove(alumno)) throw new ElementoException("El alumno no existe en el equipo");
    }

    public T haveAlumno(T alumno) {
        return alumnos.contains(alumno) ? alumno : null;
    }

    @Override
    public String toString() {
        return "\nEl equipo " + nombre + getDatosAlumnos();
    }

    private String getDatosAlumnos() {
        String base = ", ha reclutado a los siguientes alumnos:\n";
        StringBuilder cadena = new StringBuilder(base);

        for (T alumno : alumnos) {
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
