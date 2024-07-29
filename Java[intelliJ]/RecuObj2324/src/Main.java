import enums.TColor;
import excepciones.ValorNoValidoException;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Motor> listaMotores;
    private static List<CajaDeCambio> listaCajasDeCambio;
    private static List<Bateria> listaBaterias;
    private static List<Deposito> listaDepositos;

    public static void main(String[] args) {
        listaMotores = new ArrayList<>();
        listaCajasDeCambio = new ArrayList<>();
        listaBaterias = new ArrayList<>();
        listaDepositos = new ArrayList<>();

        //Creamos tres motores
        crearMotor("Mazda", "superman", "12Apew", 0.98,
                120000, 0.94, 89.9);
        crearMotor("Audi", "superboy", "8Aprw", 0.96,
                12000, 0.90, 94);
        crearMotor("Porshe", "piun", "6Vrwa", 1,
                1200000, 0, 111);

        //Creamos tres Cajas de  Cambio
        crearCajaDeCambio(5, true);
        crearCajaDeCambio(4, false);
        crearCajaDeCambio(7, true);

        //Creamos tres Baterías
        crearBateria(100, 12, 50);
        crearBateria(250, 48, 10);
        crearBateria(75, 36, 8);

        //Creamos tres Depositos
        crearDeposito(60, 20, true);
        crearDeposito(25, 25, true);
        crearDeposito(70, 35, true);

        Coche cocheA = crearCoche("Mazda", "FastBack", TColor.AMARILLO, listaMotores.get(0),
                listaCajasDeCambio.get(0), listaBaterias.get(0), listaDepositos.get(0), 12);
        Coche cocheB = crearCoche("Audi", "FastBack", TColor.BLANCO, listaMotores.get(1),
                listaCajasDeCambio.get(1), listaBaterias.get(1), listaDepositos.get(1), 48);
        Coche cocheC = crearCoche("Porshe", "FastBack", TColor.NEGRO, listaMotores.get(2),
                listaCajasDeCambio.get(2), listaBaterias.get(2), listaDepositos.get(2), 36);

        System.out.println(cocheA);
        System.out.println(cocheA.arrancar() + "\n");
        System.out.println(cocheB);
        System.out.println(cocheB.arrancar() + "\n");
        System.out.println(cocheC);
        System.out.println(cocheC.arrancar() + "\n");
    }

    /**
     * Método que crea un coche y controla su excecpciones. Se devolverá null en caso de error
     *
     * @param marca
     * @param modelo
     * @param color                 Del Enum TColor
     * @param motor
     * @param cajaDeCambio
     * @param bateria
     * @param deposito              Debe coincidir con el voltaje de funcionamimento
     * @param voltajeFuncionamiento Voltaje al que funciona el coche
     * @return Devuelve el coche creado o null si se ha dado un error
     */
    private static Coche crearCoche(String marca, String modelo, TColor color, Motor motor, CajaDeCambio cajaDeCambio,
                                    Bateria bateria, Deposito deposito, double voltajeFuncionamiento) {
        try {
            return new Coche(marca, modelo, color, motor, cajaDeCambio, bateria, deposito, voltajeFuncionamiento);
        } catch (ValorNoValidoException e) {
            System.out.println("El coche " + marca + " y " + modelo + ": " + e.getMessage());
        }
        return null;
    }

    /**
     * Método que crea un Motor y lo añade a la listaMotor
     *
     * @param marca
     * @param modelo
     * @param numeroSerie Solo formado por  letras y números
     * @param nivelAceite En el rango 0 - 1
     * @param kilometraje Positivo
     * @param nivelAgua   En el rango 0 - 1
     * @param temperatura En el rango 0 - 120
     */
    private static void crearMotor(String marca, String modelo, String numeroSerie, double nivelAceite,
                                   int kilometraje, double nivelAgua, double temperatura) {
        try {
            Motor motor = new Motor(marca, modelo, numeroSerie, nivelAceite, kilometraje, nivelAgua, temperatura);
            listaMotores.add(motor);
            System.out.println("Se ha creado el motor");
            System.out.println(motor);
            System.out.println();
        } catch (ValorNoValidoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que crea una caja de cambio y la añade a la listaCajasDeCambio
     *
     * @param numeroMarchas
     * @param estado        Si la caja de cambios es funcional
     */
    private static void crearCajaDeCambio(int numeroMarchas, boolean estado) {
        try {
            CajaDeCambio caja = new CajaDeCambio(numeroMarchas, estado);
            listaCajasDeCambio.add(caja);
            System.out.println("Se ha creado la caja de cambio");
            System.out.println(caja);
            System.out.println();
        } catch (ValorNoValidoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que crea una bateria y la añade a la listaBaterias
     *
     * @param capacidad   Debe ser mayor que 0 y se mide en amperios/hora
     * @param voltaje     Debe ser mayor que 0 y se mide en voltios
     * @param cargaActual Deentro del rango de la capacidad y se mide en amperios/hora
     */
    private static void crearBateria(double capacidad, double voltaje, double cargaActual) {
        try {
            Bateria bateria = new Bateria(capacidad, voltaje, cargaActual);
            listaBaterias.add(bateria);
            System.out.println("Se ha creado la bateria");
            System.out.println(bateria);
            System.out.println();
        } catch (ValorNoValidoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que crea un deposito y lo añade a la listDepositos
     *
     * @param capacidad        Tamaño del deposito en Litros
     * @param nivelCombustible Combustible actual
     * @param presionCorrecta  Si hay presión correcta
     */
    private static void crearDeposito(int capacidad, int nivelCombustible, boolean presionCorrecta) {
        try {
            Deposito deposito = new Deposito(capacidad, nivelCombustible, presionCorrecta);
            listaDepositos.add(deposito);
            System.out.println("Se ha creado el deposito");
            System.out.println(deposito);
            System.out.println();
        } catch (ValorNoValidoException e) {
            System.out.println(e.getMessage());
        }
    }
}