package Obj_Ejer1.Model;

public class Cliente {
    private static int cont_clientes = 1;
    private int id;
    private String nombre;

    public Cliente(String nombre) {
        id = cont_clientes++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
