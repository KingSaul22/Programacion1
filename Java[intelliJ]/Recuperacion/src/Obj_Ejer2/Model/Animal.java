package Obj_Ejer2.Model;

import Obj_Ejer2.Enums.TAnimales;
import Obj_Ejer2.Enums.TSalud;
import Obj_Ejer2.Excepciones.ValorNoValidoException;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public static int contId = 1;

    private int id;
    private TAnimales tipoAnimal;
    private int edad;
    private List<Alimentacion> alimentacion;
    private List<ChequeoSalud> chequeos;

    public Animal(TAnimales tipoAnimal, int edad) throws ValorNoValidoException {
        this.id = contId++;
        this.tipoAnimal = tipoAnimal;
        setEdad(edad);
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

    public void setEdad(int edad) throws ValorNoValidoException {
        if (edad < 0) throw new ValorNoValidoException("No puedes tener una edad negativa");
        this.edad = edad;
    }

    public void registrarAlimentacion(Alimentacion.TAlimentacion tipoAlimentacion) {
        alimentacion.add(new Alimentacion(tipoAlimentacion));
    }

    public void registrarChequeoSalud(TSalud tipoSalud) {
        chequeos.add(new ChequeoSalud(tipoSalud));
    }

    public Alimentacion.TAlimentacion alimentacionActual() {
        if (alimentacion.isEmpty()) return null;
        return alimentacion.get(alimentacion.size() - 1).getAlimentacion();
    }

    public TSalud saludActual() {
        if (chequeos.isEmpty()) return null;
        return chequeos.get(chequeos.size() - 1).getEstadoSalud();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", Animal: ").append(tipoAnimal)
                .append(", edad: ").append(edad)
                .append("\n").append("Última alimentación: ");
        Alimentacion.TAlimentacion tipoAlimentacion = alimentacionActual();
        sb.append(tipoAlimentacion == null ? "Sin registros" : tipoAlimentacion)
                .append("\n").append("Último chequeo de salud: ");
        TSalud saludActual = saludActual();
        sb.append(saludActual == null ? "Sin Chequeos" : saludActual);

        return sb.toString();
    }
}
