package Kata17;

/**
 * Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).
 * <p>
 * Examples:
 * <p>
 * solution('abc', 'bc') // returns true
 * <p>
 * solution('abc', 'd') // returns false
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution("Hola", "la"));
    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
}
