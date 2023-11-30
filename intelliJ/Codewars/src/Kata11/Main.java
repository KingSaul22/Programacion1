package Kata11;

/**
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
 * <p><p>
 * Task
 * <p>
 * You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
 * <p>
 * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
 * <p><p>
 * Examples
 * <p>
 * A size 3 diamond:
 * <p>
 * ."*"<p>
 * "***"<p>
 * ."*"<p>
 * ...which would appear as a string of " *\n***\n *\n"
 * <p>
 * A size 5 diamond:
 * <p>
 * .."*"<p>
 * ."***"<p>
 * "*****"<p>
 * ."***"<p>
 * .."*"<p>
 * ...that is:
 * <p>
 * "  *\n ***\n*****\n ***\n  *\n"
 */
public class Main {
    public static void main(String[] args) {
        final int SIZE = 5;

        System.out.println(print(SIZE));
    }


    public static String print(int n) {
        String diamond = null;
        String auxDiamond;

        if (n > 0 && n % 2 != 0) {
            diamond = "\n";

            for (int i = 0; i < n; i++){
                diamond = "*" + diamond;
            }

            for (int i = 2; i < n; i+=2){
                auxDiamond = "\n";

                for (int j = 0; j < n - i; j++){
                    auxDiamond = "*" + auxDiamond;
                }

                for (int j = 0; j < (i + 1) / 2; j++){
                    auxDiamond = " " + auxDiamond;
                }

                diamond = auxDiamond + diamond + auxDiamond;
            }

        }

        return diamond;
    }
}
