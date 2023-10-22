package Ejer3_2;

import java.util.Scanner;

public class Main {
    private static final int valueI = 1;
    private static final int valueV = 5;
    private static final int valueX = 10;
    private static final int valueL = 50;
    private static final int valueC = 100;
    private static final int valueD = 500;
    private static final int valueM = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el número romano para convertirlo a número decimal.");
        String numRomano = sc.nextLine();
        sc.close();

        int contV, contL, contD, contRept;
        char lastLetter;

        char digit;
        int digitValue;
        //int digitSave;
        int valorDecimal = 0;
        int lastDigitValue = 0;


        for (int i = 0; i < numRomano.length(); i++) {
            if (i == 0) {

                lastLetter = numRomano.charAt(i);
            } else {
                switch (numRomano.charAt(i)) {
                    case 'I':
                        yield valueI;
                    case 'V':
                        yield valueV;
                    case 'X':
                        yield valueX;
                    case 'L':
                        yield valueL;
                    case 'C':
                        yield valueC;
                    case 'D':
                        yield valueD;
                    case 'M':
                        yield valueM;
                    default:
                        yield -1;
                }

            }
        }

        for (int i = numRomano.length() - 1; i > -1; i--) {
            digit = numRomano.charAt(i);
            digitValue = valueOf(digit);

            if (i == numRomano.length() - 1) {
                valorDecimal = digitValue;
            } else {
                if (lastDigitValue > digitValue) {
                    valorDecimal -= digitValue;
                } else {
                    valorDecimal += digitValue;
                }
            }
            lastDigitValue = digitValue;
        }

        System.out.printf("El valor introducido %s traducido a decimal es: %d", numRomano, valorDecimal);
    }

    public static int valueOf(char c) {
        return switch (c) {
            case 'I':
                yield valueI;
            case 'V':
                yield valueV;
            case 'X':
                yield valueX;
            case 'L':
                yield valueL;
            case 'C':
                yield valueC;
            case 'D':
                yield valueD;
            case 'M':
                yield valueM;
            default:
                yield -1;
        };
    }

    public static boolean comparacion() {


    }
}
