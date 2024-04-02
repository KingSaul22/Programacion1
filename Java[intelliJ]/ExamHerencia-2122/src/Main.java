import Interfaces.Analizable;
import Interfaces.Convertible;
import Interfaces.Representable;
import Interfaces.Reproducible;

import java.util.Random;

public class Main {
    private static Fichero[] ficheros;

    public static void main(String[] args) {
        Random r = new Random();

        try {
            Fichero fBinario = new FicheroBinario("Fichero binario", generarArrayBytes(r.nextInt(1, 200)));
            Fichero fAudio = new FicheroAudio("Fichero Audio", r.nextInt(1, 200), generarArrayBytes(r.nextInt(1, 200)));
            Fichero fVideo = new FicheroVideo("Fichero Video", r.nextInt(1, 200), generarArrayBytes(r.nextInt(1, 200)));
            Fichero fImagen = new FicheroImagen("Fichero Imagem", generarArrayBytes(r.nextInt(1, 200)), TFormatoImagen.BMP);
            Fichero fEjecutable = new FicheroEjecutable("Fichero Ejecutable", generarArrayBytes(r.nextInt(1, 200)), 111);
            Fichero fTextoPlano = new FicheroTextoPlano("Fichero texto plano", generarArrayString(r.nextInt(1, 200)));
            Fichero fTextoFormateado = new FicheroTextoFormateado("Fichero texto Formateado", generarArrayString(r.nextInt(1, 200)), "Font Luis", r.nextInt(1, 200), "#111111");

            ficheros = new Fichero[]{fBinario, fAudio, fVideo, fImagen, fEjecutable, fTextoPlano, fTextoFormateado};
        } catch (FicheroException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i] instanceof Representable) ((Representable) ficheros[i]).representar();
            if (ficheros[i] instanceof Analizable) System.out.println(((Analizable) ficheros[i]).analizar());
            if (ficheros[i] instanceof Reproducible) System.out.println(((Reproducible) ficheros[i]).reproducir());
            if (ficheros[i] instanceof Convertible) System.out.println(((Convertible) ficheros[i]).textToAudio());
        }
    }

    private static String[] generarArrayString(int size) {
        String[] randomStrings = new String[size];
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            int length = random.nextInt(10) + 1;
            for (int j = 0; j < length; j++) {
                int index = random.nextInt(chars.length());
                sb.append(chars.charAt(index));
            }
            randomStrings[i] = sb.toString();
        }
        return randomStrings;
    }

    private static byte[] generarArrayBytes(int size) {
        Random r = new Random();
        byte[] arrayByte = new byte[size];

        //for (int i = 0; i < arrayByte.length; i++) arrayByte[i] = (byte) (Math.random() * 255 - 128);
        r.nextBytes(arrayByte);

        return arrayByte;
    }
}
