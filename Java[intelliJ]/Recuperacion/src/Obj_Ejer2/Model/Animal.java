package Obj_Ejer2.Model;

import Obj_Ejer2.Enums.TAnimales;
import Obj_Ejer2.Enums.TSalud;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public static int contId = 1;

    private int id;
    private TAnimales tipoAnimal;
    private int edad;
    private List<Alimentacion> alimentacion;
    private List<ChequeoSalud> chequeos;

    public Animal(TAnimales tipoAnimal, int edad) {
        this.id = contId++;
        this.tipoAnimal = tipoAnimal;
        this.edad = edad;
        this.alimentacion = new ArrayList<>();
        this.chequeos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public TAnimales getTipoAnimal() {
        return tipoAnimal;
    }

    public int getEdad() {
        return edad;
    }

    public void registrarAlimentacion(Alimentacion.TAlimentacion tipoAlimentacion) {
        alimentacion.add(new Alimentacion(tipoAlimentacion));
    }

    public void registrarChequeoSalud(TSalud tipoSalud) {
        chequeos.add(new ChequeoSalud(tipoSalud));
    }
}
