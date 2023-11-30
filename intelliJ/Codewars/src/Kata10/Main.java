package Kata10;

/**
 * Digital root is the recursive sum of all the digits in a number.
 * <p>
 * Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
 * <p><p>
 * Examples
 * <p>
 * 16  -->  1 + 6 = 7
 * <p>
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * <p>
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * <p>
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */
public class Main {
    public static void main(String[] args) {
        int number = 1444;

        System.out.println(digital_root(number));
        System.out.println(digital_rootB(number));
        System.out.println(digital_rootC(number));
    }


    public static int digital_root(int n) {
        String number = Integer.toString(n);
        int root = -48 * number.length();

        for (int i = 0; i < number.length(); i++) {
            root += number.charAt(i);
        }

        while (root > 9) {
            root = digital_root(root);
        }

        return root;
    }


    public static int digital_rootB(int n) {
        while (n > 9) {
            n = n / 10 + n % 10;
        }
        return (n);
    }


    public static int digital_rootC(int n) {
        String number;
        int root = n;

        while (root > 9) {
            number = Integer.toString(root);
            root = -48 * number.length();

            for (int i = 0; i < number.length(); i++) {
                root += number.charAt(i);
            }
        }

        return root;
    }
}
