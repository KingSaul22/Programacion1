import excepciones.TiendaException;
import modelo.Categoria;
import modelo.Producto;
import modelo.Tienda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Producto a = new Producto("Casa", "Pepe", "Cocacola", 3.3, 5);
        Producto b = new Producto("Casa", "Pepe", "Pepsi", 6.3, 50);
        Producto c = new Producto("Casas", "Pepe", "Pepsi", 6.3, 50);

        Categoria cA = new Categoria("Ostras");
        Categoria cB = new Categoria("Ostras");

        cA.annadirProducto(b);


        Tienda tA = new Tienda("Patrocinio");
        try {
            tA.addCategoria("Ostras");
            tA.addCategoria("Ostras");
        } catch (TiendaException e) {
            System.out.println("Debo salir");
            System.out.println(e.getMessage());
        }

            List<Categoria> lista = new ArrayList<>();
            lista.add(cA);
        try {
            tA.addProducto(a, lista);
            tA.addProducto(b, lista);
        } catch (TiendaException e) {
            System.out.println("No debo salir");
            System.out.println(e.getMessage());
        }
    }
}
