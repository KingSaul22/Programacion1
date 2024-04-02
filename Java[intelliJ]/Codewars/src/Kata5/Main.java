package Kata5;

public class Main {
    /**
     * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
     * <p>
     * Examples
     * <p>
     * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
     * <p>
     * pigIt('Hello world !');     // elloHay orldway !
     */
    public static void main(String[] args) {
        String frase = "Pig¿ ¿ latin is cool";
        System.out.println(frase);
        System.out.println(pigIt(frase));
        System.out.println(pigItB(frase));

    }

    public static String pigIt(String str) {
        String result = "";
        String auxResult = "";

        for (int i = 0; i < str.length(); i++) {

            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                auxResult = auxResult + String.valueOf(str.charAt(i));

            } else {

                if (auxResult.length() > 1) {
                    for (int j = 1; j < auxResult.length(); j++) {
                        result = result + String.valueOf(auxResult.charAt(j));
                    }
                    result = result + String.valueOf(auxResult.charAt(0)) + "ay" + String.valueOf(str.charAt(i));

                } else if (auxResult.length() == 1) {
                    result = result + String.valueOf(auxResult.charAt(0)) + "ay" + String.valueOf(str.charAt(i));
                }

                auxResult = "";
            }

        }

        if (auxResult.length() > 1) {
            for (int j = 1; j < auxResult.length(); j++) {
                result = result + String.valueOf(auxResult.charAt(j));
            }
            result = result + String.valueOf(auxResult.charAt(0)) + "ay";

        } else if (auxResult.length() == 1) {
            result = result + String.valueOf(auxResult.charAt(0)) + "ay";

        } else {
            result = result + String.valueOf(str.charAt(str.length() - 1));
        }
        return result;
    }

    public static String pigItB(String str) {
        String result = "";
        String auxResult = "";
        int last = 0;

        for (int i = 0; i < str.length(); i++) {

            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                auxResult = auxResult + String.valueOf(str.charAt(i));

            } else {

                if (auxResult.length() > 1) {
                    for (int j = 1; j < auxResult.length(); j++) {
                        result = result + String.valueOf(auxResult.charAt(j));
                    }
                    result = result + String.valueOf(auxResult.charAt(0)) + "ay" + String.valueOf(str.charAt(i));
                    last = 0;

                } else if (auxResult.length() == 1) {
                    result = result + String.valueOf(auxResult.charAt(0)) + "ay" + String.valueOf(str.charAt(i));
                    last = 0;

                } else {
                    result = result + String.valueOf(str.charAt(i));
                    last = 1;
                }

                auxResult = "";
            }
        }

        if (auxResult.length() > 1) {
            for (int j = 1; j < auxResult.length(); j++) {
                result = result + String.valueOf(auxResult.charAt(j));
            }
            result = result + String.valueOf(auxResult.charAt(0)) + "ay";

        } else if (auxResult.length() == 1) {
            result = result + String.valueOf(auxResult.charAt(0)) + "ay";

        } else if (last == 0) {
            result = result + String.valueOf(str.charAt(str.length() - 1));
        }

        return result;
    }
}
