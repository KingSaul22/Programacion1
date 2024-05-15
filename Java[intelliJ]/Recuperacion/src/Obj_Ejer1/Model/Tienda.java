package Obj_Ejer1.Model;

import Obj_Ejer1.Enums.TFamilia;
import Obj_Ejer1.Excepciones.TiendaException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Tienda {
    private String nombre;
    private List<Cliente> clientes;
    private List<Mascota> mascotas;
    private List<Compra> compras;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.mascotas = new LinkedList<>();
        this.compras = new ArrayList<>();
    }

    public void venderMascota(Mascota mascota, Cliente cliente) throws TiendaException {
        int error = 0;
        if (!mascotas.contains(mascota)) error++;
        if (!clientes.contains(cliente)) error += 10;
        switch (error) {
            case 1:
                throw new TiendaException("La mascota introducida no se encuentra en la lista de Mascotas");
            case 10:
                throw new TiendaException("El cliente introducido no existe en la lista de clientes");
            case 11:
                throw new TiendaException("La mascota y el Cliente introducido no se encuentran en sus respectivas listas");
        }
        compras.add(new Compra(cliente, mascota));
        mascotas.remove(mascota);
    }

    public void nuevoCliente(String newNombre) throws TiendaException {
        if (!Pattern.compile("^\\p{L}{2,}$").matcher(newNombre).matches())
            throw new TiendaException("Nombre de cliente no valido");
        clientes.add(new Cliente(newNombre));
    }

    public void nuevaMascota(String nombre, TFamilia familia, int edad, double precio, boolean disponible) throws TiendaException {
        if (!Pattern.compile("^\\p{L}{2,}$").matcher(nombre).matches())
            throw new TiendaException("Nombre de mascota no valido");
        mascotas.add(new Mascota(nombre, familia, edad, precio, disponible));
    }

    public void comprarMascota(int id_cliente, int id_mascota) throws TiendaException {
        try {
            compras.add(new Compra(clientes.get(id_cliente - 1), mascotas.get(id_mascota - 1)));
        } catch (IndexOutOfBoundsException e) {
            throw new TiendaException("La selección del cliente y/o mascota no es valida");
        }
    }

    public List<String> getClientesString() {
        return clientes.stream().map(cliente -> String);
    }

    public List<Mascota> getMascotasDisponibles() {
        return mascotas.stream().filter(Mascota::isDisponible).toList();
    }
}
