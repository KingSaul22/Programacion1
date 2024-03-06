package Ejer3;

import java.time.LocalDate;

public class Alumno extends Persona {
    private static final int MAYORIA_EDAD = 18;
    private final LocalDate FECHA_NACIMIENTO;

    public Alumno(String nombre, LocalDate fecha) {
        super(nombre);
        FECHA_NACIMIENTO = fecha;
    }

    @Override
    public void sendMessage(Persona receptor, String mensaje) throws MensajeException {
        LocalDate fechaMinima = LocalDate.now().minusYears(MAYORIA_EDAD);
<<<<<<< HEAD
        if (receptor instanceof Alumno && FECHA_NACIMIENTO.isAfter(fechaMinima)) {
=======
        //if (receptor.getClass() == Alumno.class && fechaNacimiento.isAfter(fechaMinima)) {
        if (receptor instanceof Alumno && fechaNacimiento.isAfter(fechaMinima)) {
>>>>>>> a7edd94b2ad590562a6a902d9e8c545564c17765
            throw new MensajeException("Los alumnos menores de edad no pueden enviar mensajes a otros alumnos");
        }

        super.sendMessage(receptor, mensaje);
    }
}
