package Ejer5;

import utils.MiEntradaSalida;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            mostrarMenu();
            option = MiEntradaSalida.leerEnteroDeRango("Selección", 1, 5);
            switch (option) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    crearFichero();
                    break;
                case 3:
                    borrarFichero();
                    break;
                case 4:
                    mostrarFicherosDeCarpeta();
            }
        } while (option != 5);
    }

    private static void crearDirectorio() {
        String nombre = MiEntradaSalida.leerCadena("Introducir el nombre del directorio");
        File directorio = new File(".\\Resources\\Ejer5\\" + nombre);
        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            if (directorio.mkdir()) {
                System.out.println("El directorio se ha creado correctamente");
            } else {
                System.out.println("El directorio no ha podido ser creado");
            }
        }
    }

    private static void crearFichero() {
        String nombre = MiEntradaSalida.leerCadena("Introducir el nombre del fichero");
        File ficheroTexto = new File(".\\Resources\\Ejer5\\" + nombre);

        if (!nombre.endsWith(".txt")) {
            System.out.println("la extensión del archivo no esta soportada. Solo se admiten ficheros '.txt'");
            return;
        }
        if (ficheroTexto.exists() && !ficheroTexto.isFile()) {
            System.out.println("No puedo crear ese fichero. El nombre indicado ya está en uso");
            return;
        }

        boolean append = false;
        if (ficheroTexto.exists()) {
            System.out.println("El fichero ya existe. ¿Quiere añadir contenido al final del fichero? (S o N)");
            append = MiEntradaSalida.leerSN("Responda con 'S' o 'N'") == 'S';
        }

        String data = MiEntradaSalida.leerCadena("Introducir los datos a incluir el fichero");
        try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroTexto, append))) {
            pw.println(data);
            System.out.println("Los datos se han escrito correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarFichero() {
        String nombre = MiEntradaSalida.leerCadena("Introducir el nombre del fichero");
        File ficheroTexto = new File(".\\Resources\\Ejer5\\" + nombre);

        if (!nombre.endsWith(".txt")) {
            System.out.println("la extensión del archivo no esta soportada. Solo se admiten ficheros '.txt'");
            return;
        }

        if (!ficheroTexto.isFile()) {
            System.out.println("El archivo con el nombre indicado no es un fichero o no existe.");
        } else {
            if (ficheroTexto.delete()) {
                System.out.println("El fichero ha sido borrado");
            } else {
                System.out.println("El fichero no se ha borrado");
            }
        }
    }

    private static void mostrarFicherosDeCarpeta() {
        String nombre = MiEntradaSalida.leerCadena("Introducir el nombre del directorio");
        File directorio = new File(".\\Resources\\Ejer5\\" + nombre);

        if (!directorio.isDirectory()) {
            System.out.println("No existe ningún directorio con ese nombre");
        } else {
            File[] listFiles = directorio.listFiles(path -> path.isFile() && path.getName().endsWith(".txt"));
            if (listFiles != null) {
                System.out.println("Archivos dentro de la carpeta " + nombre);
                for (File file : listFiles) {
                    System.out.println("  " + file.getName());
                }
            } else {
                System.out.println("No hay archivos dentro de la carpeta " + nombre);
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                                
                1. Crear Directorio
                2. Crear Fichero de Texto
                3. Borrar Fichero de Texto
                4. Mostrar Ficheros de una Carpeta
                5. Salir""");
    }
}
