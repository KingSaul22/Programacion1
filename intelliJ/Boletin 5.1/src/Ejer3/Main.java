package Ejer3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona prf1 = new Profesor("Pepe");
        Persona prf2 = new Profesor("Zapatustio");
        Persona al1 = new Alumno("Carmelo", LocalDate.of(2002, 2, 22));

        List<Persona> personas = new ArrayList<>();
        personas.add(prf1);
        personas.add(prf2);
        personas.add(al1);

        try {
            personas.get(0).sendMessage(personas.get(1), "Mensaje de prueba0");
            Thread.sleep(1000);
            personas.get(1).sendMessage(personas.get(0), "Mensaje de prueba0");
            Thread.sleep(1000);
            personas.get(2).sendMessage(personas.get(0), "Mensaje de prueba3");
            Thread.sleep(1000);
            personas.get(1).sendMessage(personas.get(0), "Mensaje de prueba1");
            Thread.sleep(1000);
            personas.get(0).sendMessage(personas.get(1), "Mensaje de prueba2");
            Thread.sleep(1000);
            personas.get(2).sendMessage(personas.get(0), "Mensaje de prueba3");
        } catch (MensajeException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sin ordenar");
        System.out.println(personas.get(0).leerMensajes());
        System.out.println("Tras ordenar");
        System.out.println(personas.get(0).leerMensajesOrdenados());
        System.out.println("Tras ordenar Alfa");
        System.out.println(personas.get(0).leerMensajesOrdenadosAlfabeti());
    }
}
