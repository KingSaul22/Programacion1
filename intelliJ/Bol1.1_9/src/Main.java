

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (esPerfecto(i)) {
                System.out.println("El número "+i+" es perfecto.");
            }
        }
    }

    public static boolean esPerfecto(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}