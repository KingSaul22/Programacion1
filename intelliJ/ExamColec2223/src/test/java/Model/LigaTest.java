package Model;

import Enum.TDemarcacion;
import Excepciones.LigaException;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LigaTest {
    private Equipo a = new Equipo("Blue");


    @org.junit.jupiter.api.Test
    void addEquipo() {
        a.addJugador(new Jugador("Pepe", TDemarcacion.CENTROCAMPISTA, LocalDate.of(2002, 10, 22), "España"));
        assertDoesNotThrow(a, LigaException);
    }

    @org.junit.jupiter.api.Test
    void eliminaEquipo() {
    }

    @org.junit.jupiter.api.Test
    void unirEquipos() {
    }

    @org.junit.jupiter.api.Test
    void jugadoresEnComun() {
    }

    @org.junit.jupiter.api.Test
    void mediaEdad() {
    }

    @org.junit.jupiter.api.Test
    void jugadoresOrdenadosEdad() {
    }

    @org.junit.jupiter.api.Test
    void jugadoresOrdenadosNombre() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}