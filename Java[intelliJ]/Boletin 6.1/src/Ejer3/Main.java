package Ejer3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //IO; NIO en el Ejer4
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(".\\Resources\\Ejer3\\salidaEj3.txt", true), 22);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = br.readLine();
            while (!input.equals("fin")) {
                bw.write(input);
                input = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
