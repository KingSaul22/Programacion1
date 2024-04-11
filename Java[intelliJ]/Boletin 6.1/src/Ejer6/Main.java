package Ejer6;

import utils.MiEntradaSalida;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        mostrarContenidosCarpeta();
    }

    private static void mostrarContenidosCarpeta() {
        File directorio = getValidDirectorio().toFile();

        File[] listFiles = directorio.listFiles();
        if (listFiles == null) return;

        System.out.println("Ficheros dentro de la carpeta " + directorio.getName() + ":");
        for (File file : listFiles) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            } else {
                System.out.println(file.getName() + " ("+file.length()+" bytes)");
            }
        }
    }

    private static Path getValidDirectorio() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del directorio a mostrar");
        Path outPath = Paths.get(".\\Resources\\" + name);

        while (!outPath.toFile().isDirectory()) {
            System.out.println("El nombre del directorio " + name + " no existe");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el directorio a mostrar");
            outPath = Paths.get(".\\Resources\\" + name);
        }

        return outPath;
    }
}
