import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static HashMap<String, Long> listaContactos;

    public static void main(String[] args) {


        //EJERCICIO EXTRA
        sc = new Scanner(System.in);
        listaContactos = new HashMap<>();
        dificultadExtra();
        sc.close();
    }

    private static void dificultadExtra() {
        int opcion;
        do {
            imprimirMenu();
            opcion = getEnteroRango("Selección", 0, 4);
            switch (opcion) {
                case 1 -> busqueda();
                case 2 -> creacion();
                case 3 -> actualizar();
                case 4 -> eliminar();
            }
        } while (opcion != 0);
    }

    private static void busqueda() {
        String nombre = getNombreContacto();

        if (!listaContactos.containsKey(nombre)) {
            System.out.println("\nNo existe un contacto con ese nombre.");
        } else {
            System.out.println("El contacto " + nombre + " tiene por número: " + listaContactos.get(nombre));
        }
    }

    private static void creacion() {
        String nombre = getNombreContacto();
        long numero = getLongRangoLongitud("Introduzca el número de su contacto", 2, 11);

        if (!listaContactos.containsKey(nombre)) {
            listaContactos.put(nombre, numero);
            System.out.println("El contacto '" + nombre + "' con número " + numero + " ha sido añadido exitosamente.");
        } else {
            System.out.println("El contacto con nombre " + nombre + " ya existe, si desea modificarlo seleccione la opción 'actualizar contacto'");
        }
    }

    private static void actualizar() {
        String nombre = getNombreContacto();

        if (listaContactos.containsKey(nombre)) {
            long numero = getLongRangoLongitud("Introduzca el número nuevo de su contacto", 2, 11);
            listaContactos.put(nombre, numero);
            System.out.println("El contacto '" + nombre + "' ha sido editado exitosamente." + " Su número actual es: " + numero);
        } else {
            System.out.println("El contacto con nombre " + nombre + " no existe, si desea crearlo seleccione la opción 'crear contacto'");
        }
    }

    private static void eliminar() {
        String nombre = getNombreContacto();

        if (listaContactos.containsKey(nombre)) {
            System.out.println("El contacto " + nombre + " con número " + listaContactos.get(nombre) + " ha sido eliminado exitosamente.");
            listaContactos.remove(nombre);
        } else {
            System.out.println("El contacto con nombre " + nombre + " no existe");
        }
    }

    private static String getNombreContacto() {
        System.out.print("\nIntroduzca el nombre de su contacto: ");
        String nombre = (sc.nextLine().trim()).toLowerCase();
        while (nombre.isBlank()) {
            System.out.println("Introduzca un nombre valido");
            nombre = (sc.nextLine().trim()).toLowerCase();
        }

        return nombre;
    }

    private static int getEnteroRango(String mensaje, int min, int max) {
        int entero = getEntero(mensaje);
        while (entero < min || entero > max) {
            System.out.println("Por favor, introduce un número entre " + min + " y " + max);
            entero = getEntero(mensaje);
        }

        return entero;
    }

    private static int getEntero(String mensaje) {
        System.out.print(mensaje + ": ");

        int entero = 0;
        boolean ok = false;

        while (!ok) {
            try {
                entero = Integer.parseInt(sc.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Error. Introduce un número entero: ");
            }
        }

        return entero;
    }

    private static long getLongRangoLongitud(String mensaje, int longitudMin, int longitudMax) {
        long entero = getLong(mensaje);
        String cadenaEntero = String.valueOf(entero);
        while (cadenaEntero.length() < longitudMin || cadenaEntero.length() > longitudMax || entero < 1) {
            System.out.println("Por favor, introduce un número positivo con una longitud comprendida entre " + longitudMin + " y " + longitudMax);
            entero = getLong(mensaje);
            cadenaEntero = String.valueOf(entero);
        }

        return entero;
    }

    private static long getLong(String mensaje) {
        System.out.print(mensaje + ": ");

        long entero = 0L;
        boolean ok = false;

        while (!ok) {
            try {
                entero = Long.parseLong(sc.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Introduzca un número entero: ");
            }
        }

        return entero;
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Acciones posibles sobre la agenda de contactos:
                  1. Buscar contacto
                  2. Crear contacto
                  3. Actualizar contacto
                  4. Eliminar contacto
                  0. Finalizar programa""");
    }
}