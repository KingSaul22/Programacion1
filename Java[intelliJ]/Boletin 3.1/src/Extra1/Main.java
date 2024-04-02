package Extra1;

import java.time.LocalDateTime;

/**
 * Vamos a implementar la gestión del mantenimiento básico de un avión.
 * <p>
 * El avión tiene:
 * <p>
 * ● Una marca
 * <p>
 * ● Un modelo
 * <p>
 * ● Un consumo, que se entenderá por litros consumidos por kilómetro
 * <p>
 * ● Un depósito de combustible, que a su vez tendrá:
 * <p>
 * --○ Una capacidad máxima
 * <p>
 * --○ Una cantidad actual
 * <p>
 * ● Un registro de revisiones, donde cada una de ellas tendrá:
 * <p>
 * --○ Una fecha
 * <p>
 * --○ Un estado (correcto o incorrecto)
 * <p>
 * --○ Un periodo de validez
 * <p>
 * El avión deberá poder mostrar sus datos actuales: marca, modelo, nivel de combustible actual y si está listo para viajar o no.
 * <p>
 * Debe disponer también de un método que nos indique si, dada la distancia a un destino, el avión puede realizar el recorrido o no, teniendo en cuenta también si su última revisión está en fecha y fue correcta
 */
public class Main {
    public static void main(String[] args) {
        Deposito depo1 = new Deposito(200000, 12000);
        Avion avion1 = new Avion(depo1, 13, "Coca-Cola", "Zero-Zero");
        System.out.println(avion1);

        Revision revi1_a = new Revision(LocalDateTime.of(2023, 10, 12, 21, 1), 6);
        avion1.addRevision(revi1_a);
        System.out.println(avion1);

    }
}
