package Kata16;

/**
 * ROT13
 * <p>
 * How can you tell an extrovert from an introvert at NSA?
 * <p>
 * Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.
 * <p>
 * I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
 * According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.
 * <p>
 * For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.
 * <p>
 * Test examples:
 * <p>
 * "EBG13 rknzcyr." -> "ROT13 example."
 * <p>
 * "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("In: abcdefghijklmneopqrstuvwxyz" + "abcdefghijklmneopqrstuvwxyz".toUpperCase());
        System.out.print("Out: " + rot13("abcdefghijklmneopqrstuvwxyz"));
        System.out.println(rot13("abcdefghijklmneopqrstuvwxyz".toUpperCase()));

        System.out.println();
        System.out.println("Expected: " + "!Rj(POSüK%Mf(!ST%s^KXzku&rvkN%69_VnwE!1(X*BndIX1n4%DbrW+S");
        System.out.println("Result:   " + rot13("!Ew(CBFüX%Zs(!FG%f^XKmxh&eixA%69_IajR!1(K*OaqVK1a4%QoeJ+F"));
    }

    public static String rot13(String message) {
        StringBuilder messageRoot13 = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);

            if (letter >= 'A' && letter < 'N' || (letter >= 'a' && letter < 'n')) {
                messageRoot13.append((char) (letter + 13));

            } else if (letter >= 'N' && letter <= 'Z' || (letter >= 'n' && letter <= 'z')) {
                messageRoot13.append((char) (letter - 13));
            } else {
                messageRoot13.append(letter);
            }
        }

        return messageRoot13.toString();
    }
}
