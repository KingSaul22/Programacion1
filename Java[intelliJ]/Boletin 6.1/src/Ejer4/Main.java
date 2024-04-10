package Ejer4;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        //NIO; IO en el Ejer3
        Path outPath = Paths.get(".\\Resources\\Ejer4\\salidaEj4.txt");
        try (BufferedReader inData = new BufferedReader(new InputStreamReader(System.in))) {
            String data;
            while (!(data = inData.readLine()).equals("fin")) {
                //Files.write(outPath, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.writeString(outPath, data, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
