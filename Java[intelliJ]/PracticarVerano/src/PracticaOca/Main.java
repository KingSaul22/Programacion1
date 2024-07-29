package PracticaOca;


import java.util.Arrays;

public class Main {
    private static final int NUMERO_JUGADORES = 4;
    private static String[] colores = {"Amarillo", "Verde", "Rojo", "Naranja"};
    private static int[] posJuga = new int[NUMERO_JUGADORES];
    //Un tablero de 8x8, tiene 64 casillas

    public static void main(String[] args) {
        System.out.println("Bienvenido a la oca de Saúl y Iker");

        ordenInicial();
        System.out.println("Empieza el jugador " + colores[0] +
                " y el orden que se seguira es el siguiente: " + Arrays.toString(colores));

        //for (int i = 0; i < posJuga.length; i++) posJuga[i] = 1;
        Arrays.fill(posJuga, 1);

        int jg = 0;
        do {
            System.out.println("\nLe toca al jugador " + colores[jg]);
            int aux = dado();
            System.out.println("Lanza el dado y consigue un " + aux);
            posJuga[jg] += aux;
            System.out.println("Pasas a la casilla " + posJuga[jg]);

            if (posJuga[jg] >= 64) {
                break;
            }

            if (posJuga[jg] % 4 == 0) {
                System.out.println("De oca a oca y tiro porque me toca");
                posJuga[jg] += 4;
                continue;
            } else if (posJuga[jg] == 62) {
                System.out.println("Has caido en la casilla calavera, pasas a la posición 1");
                posJuga[jg] = 1;
            }

            if (jg >= 3) {
                jg = 0;
            } else {
                jg++;
            }
        } while (true);


        System.out.println("\nHa ganado el jugador " + colores[jg]);
    }

    /**
     * Método que decide el orden de tirada para los jugadores.
     * <p>
     * TODO: En lugar de repetir todas las tiradas cuando dos jugadores empaten, hacer que esos en especifico tiren de nuevo y desempaten entre ellos
     */
    public static void ordenInicial() {
        int[] resultadoDado = new int[NUMERO_JUGADORES];
        for (int i = 0; i < resultadoDado.length; i++) {
            resultadoDado[i] = dado();
        }

        int posMayor = 0;
        for (int i = 1; i < resultadoDado.length; i++) {
            if (resultadoDado[posMayor] < resultadoDado[i]) {
                posMayor = i;
            }
        }

        boolean repe = false;
        for (int i = posMayor + 1; i < resultadoDado.length; i++) {
            if (resultadoDado[posMayor] == resultadoDado[i]) {
                repe = true;
                break;
            }
        }

        if (repe) {
            ordenInicial();
        } else {
           /* for (int i = 0; i < posMayor; i++) {
                String aux = colores[0];
                colores[0] = colores[1];
                colores[1] = colores[2];
                colores[2] = colores[3];
                colores[3] = aux;
            }*/
            for (int i = 0; i < posMayor; i++) {
                String aux = colores[0];
                for (int j = 0; j < colores.length - 1; j++) {
                    colores[j] = colores[j + 1];
                }
                colores[colores.length - 1] = aux;
            }
        }
    }

    /**
     * Se usa el metodo random de la clase Math, para conseguir un numero aleatorio a numero de dado.
     *
     * @return devuelve un numero aleatorio entre uno y seis
     */
    public static int dado() {
        return (int) (Math.random() * 6 + 1);
    }
}
