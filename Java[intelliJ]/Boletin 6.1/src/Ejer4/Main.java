package Ejer4;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //NIO; IO en el Ejer3
        Path outPath = Paths.get(".\\Resources\\Ejer4\\salidaEj4.txt");
        try (BufferedWriter outData = Files.newBufferedWriter(outPath);
             BufferedReader inData = new BufferedReader(new InputStreamReader(System.in))) {

            String data = inData.readLine();
            while (!data.equals("fin")) {
                outData.write(data);
                data = inData.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
