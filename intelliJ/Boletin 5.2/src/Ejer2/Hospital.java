package Ejer2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private List<Paciente> pacientes;
    private int numPaciente;

    public Hospital() {
        pacientes = new LinkedList<>();
        numPaciente = 0;
    }

    public void aniadirPaciente(Paciente paciente) {
        int posPaciente=0;
        Iterator<Paciente> it = pacientes.iterator();
        while(it.hasNext()){
            posPaciente++;
            Paciente pc = it.next();
            if (paciente.compareTo(pc) < 0) {
                pacientes.add(posPaciente, paciente);
                //TODO: repasar lógica de posPaciente y el .add()
                break;
            }
        }
    }
}