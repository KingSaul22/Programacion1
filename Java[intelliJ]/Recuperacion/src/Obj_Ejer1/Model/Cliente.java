package Obj_Ejer1.Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
