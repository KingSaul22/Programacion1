package Ejer2;

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
        try (BufferedReader inFile = new BufferedReader(new FileReader(".\\Resources\\Fichero.txt"))) {
            String line;
            StringBuilder info = new StringBuilder();
            while ((line = inFile.readLine()) != null) {
                info.append(line).append(" ");
            }
            System.out.println(info);

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        Path path = Paths.get(".\\Resources\\Fichero.txt");
        try (Stream<String> lines = Files.lines(path)){
            StringBuilder info = new StringBuilder();
            lines.forEach(a -> info.append(a).append(" "));
            System.out.println(info);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
