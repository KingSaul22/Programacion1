import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dist, vel;
        int hor, min, seg;

        System.out.println("Introduzca la distancia en kilometros");
        dist = sc.nextDouble();
        System.out.println("Introduzca la velocidad en kilometros por hora");
        vel = sc.nextDouble();
        sc.close();

        double tiempo = dist / vel;
        hor = (int) tiempo;
        min = (int) ((tiempo - hor) * 60);
        seg = (int) (((tiempo - hor) * 60 - min) * 60);


        System.out.printf("El tiempo estimado es de %d:%d:%d", hor, min, seg);
    }
}