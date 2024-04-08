package Ejer1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //IO
        try (BufferedReader inFile = new BufferedReader(new FileReader(".\\Resources\\Fichero.txt"))) {
            int numLines = 0;
            /*while(inFile.readLine != null) {
                numLines++;
            }*/

            numLines = (int) inFile.lines().count();
            System.out.println("Número de lineas en el fichero: " + numLines);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        //NIO
        Path path = Paths.get(".\\Resources\\Fichero.txt");
        try (Stream<String> lines = Files.lines(path)) {
            System.out.println("Numero de lineas en el fichero: " + lines.count());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
