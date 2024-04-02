package Ejer2;

import static java.lang.Character.*;

public class Cadena {

    private String characteres;
    private int contMin = 0, contMay = 0, contNum = 0;

    protected Cadena(String characteres) {
        this.characteres = characteres;
        cuentaCharacter();
    }

    private void cuentaCharacter() {
        for (int i = 0; i < characteres.length(); i++) {

            if (isLowerCase(characteres.charAt(i))) {
                contMin++;

            } else if (isUpperCase(characteres.charAt(i))) {
                contMay++;

            } else if (isDigit(characteres.charAt(i))) {
                contNum++;
            }
        }
    }

    protected int getContMin() {
        return contMin;
    }

    protected int getContMay() {
        return contMay;
    }

    protected int getContNum() {
        return contNum;
    }

    public String toString() {
        return "La cadena: '" + characteres + "', contiene " + contMin +
                " letras minúsculas, " + contMay + " mayúsculas y " +
                contNum + " dígitos.";
    }
}
