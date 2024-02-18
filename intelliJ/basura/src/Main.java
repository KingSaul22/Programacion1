import java.util.Arrays;

public class Main {
private static int numJugadores=4;

    public static void main(String[] args) {
        int[] resultadoDadoB = new int[numJugadores];
        int[] indicesJugadores = new int[numJugadores];
        int aux;
        for (int i = 0; i < numJugadores; i++) {
            resultadoDadoB[i] = (int) (Math.random() * 12 + 1);
            indicesJugadores[i] = i;
        }
        System.out.println(Arrays.toString(indicesJugadores));
        System.out.println(Arrays.toString(resultadoDadoB));

        for (int i = 1; i< numJugadores; i++){
            for (int j = 0; j< numJugadores; j++){
                if (resultadoDadoB[j] < resultadoDadoB[i]){
                    aux = resultadoDadoB[i];
                    resultadoDadoB[i] = resultadoDadoB[j];
                    resultadoDadoB[j] = aux;
                    aux = indicesJugadores[i];
                    indicesJugadores[i] = indicesJugadores[j];
                    indicesJugadores[j] = aux;
                }
            }
        }

        System.out.println(Arrays.toString(indicesJugadores));
        System.out.println(Arrays.toString(resultadoDadoB));
    }


}