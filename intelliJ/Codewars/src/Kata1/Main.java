package Kata1;

public class Main {
    /**
     * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
     * <p>
     * Examples
     * "din"      =>  "((("
     * "recede"   =>  "()()()"
     * "Success"  =>  ")())())"
     * "(( @"     =>  "))(("
     * <p>
     * Notes
     * Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
     */
    public static void main(String[] args) {

        if (isNarcissistic(153)) {
            System.out.println("It is.");
        } else {
            System.out.println("It is not.");
        }

    }

    public static boolean isNarcissistic(int number) {
        String stringNumber = number + "";
        int auxNumber;
        int auxTotal;
        int total = 0;

        for (int i = 0; i < stringNumber.length(); i++) {
            auxNumber = -48 + (int) stringNumber.charAt(i);
            auxTotal = auxNumber;

            for (int j = 0; j < stringNumber.length() - 1; j++) {

                auxTotal *= auxNumber;
            }
            total += auxTotal;
        }

        return total == number;
    }
}
