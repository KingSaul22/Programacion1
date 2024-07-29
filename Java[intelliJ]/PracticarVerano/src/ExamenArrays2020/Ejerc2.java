package ExamenArrays2020;

public class Ejerc2 {
    private static final int[][] JARDIN = {
            {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
            {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
            {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
            {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
            {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
            {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
            {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
            {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
            {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
            {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
    };

    private static final int FLOR = 1;
    private static final int AGUA = 2;
    private static final int HIERBA = 3;
    private static final int GUSANO = 4;
    private static final int ABEJA = 5;

    public static void main(String[] args) {
        for (int i = 0; i < JARDIN.length; i++) {
            for (int j = 0; j < JARDIN[i].length; j++) {
                if (JARDIN[i][j] == FLOR) {
                    comprobarFlorecimiento(i, j);
                }
            }
        }
    }

    /**
     * En esté metodo se encarga de comprobar si la flor puede florecer y imprime un mensaje.
     * <p>
     * Se compruba que haya abeja y agua; y en el caso de encontrar hierba, que haya gusano.
     *
     * @param fila  Posición del eje Y donde se encuentra la flor
     * @param colum Posición del eje X donde se encuentra la flor
     */
    public static void comprobarFlorecimiento(int fila, int colum) {
        boolean haveAgua = false;
        boolean haveHierba = false;
        boolean haveGusano = false;
        for (int i = fila - 1; i <= fila + 1; i++) {
            if (i < 0 || i > 14) continue;
            for (int j = colum - 1; j <= colum + 1; j++) {
                if (j < 0 || j > 14) continue;

                switch (JARDIN[i][j]) {
                    case AGUA:
                        haveAgua = true;
                        break;
                    case HIERBA:
                        haveHierba = true;
                        break;
                    case GUSANO:
                        haveGusano = true;
                        break;
                }
            }
        }

        if (!haveAgua || (haveHierba && !haveGusano)) {
            System.out.println("La flor de la posición " + fila + "," + colum + " no florecerá.");
            return;
        }

        //Buscar Abeja
        for (int i = fila - 3; i <= fila + 3; i++) {
            if (i < 0 || i > 14) continue;
            for (int j = colum - 3; j <= colum + 3; j++) {
                if (j < 0 || j > 14) continue;
                if (JARDIN[i][j] == ABEJA) {
                    System.out.println("La flor de la posición " + fila + "," + colum + " florecerá.");
                    return;
                }
            }
        }

        System.out.println("La flor de la posición " + fila + "," + colum + " no florecerá.");
    }
}
