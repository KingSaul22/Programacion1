import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vel;

        System.out.println("Introduce el tipo de vehículo; Coche, Moto o Camión");
        String vehi = sc.nextLine();

/*      if (vehi.equals("Coche")){
            vel = 120;
        }
        else if (vehi.equals("Moto")) {
            vel = 90;
        }
        else if(vehi.equals("Camión")){
            vel = 80;
        }
        else {
        System.out.println("No se reconoce ese vehículo");
        }*/
        switch(vehi) {
            case "Coche":
                vel = 120;
                System.out.println("La velocidad del vehículo es: " + vel);
                break;
            case "Moto":
                vel = 90;
                System.out.println("La velocidad del vehículo es: " + vel);
                break;
            case "Camión":
                vel = 80;
                System.out.println("La velocidad del vehículo es: " + vel);
                break;
            default:
                System.out.println("No se reconoce ese vehículo");
        }
    }
}
