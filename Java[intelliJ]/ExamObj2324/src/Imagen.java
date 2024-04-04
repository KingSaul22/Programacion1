import java.util.Random;

public class Imagen {
    public static String[][] generateRandomColors(int width, int height) {
        String[][] colorMatrix = new String[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Generar un color hexadecimal aleatorio
                String color = String.format("#%06X", random.nextInt(0xFFFFFF + 1));
                colorMatrix[i][j] = color;
            }
        }

        return colorMatrix;
    }
}
