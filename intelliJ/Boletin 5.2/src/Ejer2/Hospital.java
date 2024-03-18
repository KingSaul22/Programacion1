package Ejer2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private List<Paciente> pacientes;
    private static Integer numPaciente;

    public Hospital() {
        pacientes = new LinkedList<>();
        numPaciente = 1;
    }

    public void aniadirPaciente(Paciente paciente) {
        int posPaciente=0;
        Iterator<Paciente> it = pacientes.iterator();
        while(it.hasNext()){
            Paciente pc = it.next();
            if (paciente.compareTo(pc) < 0) {
                pacientes.add(posPaciente, paciente);
                //TODO: repasar lógica de posPaciente y el .add()
                break;
            }
            posPaciente++;
        }
    }

    /**
     * Este método aprovecha los flujos para devolver una copia de la cola  de pacientes,
     * esta cola ya esta ordenada de manera natural por el orden en que se atenderan
     * @return Una copia de la {@link Hospital#pacientes cola de pacientes}
     */
    public List<Paciente> getPacientesOrdenAtender() {
        //return pacientes.stream().toList();
        return (List<Paciente>) (((LinkedList<Paciente>) pacientes).clone());
    }

    public Paciente atenderPaciente() {
        return ((LinkedList<Paciente>) pacientes).poll();
    }

    public int getNumPacienteSize() {
        return pacientes.size();
    }

    public List<Paciente> getPacientesOrdenPorEdad() {
        return pacientes.stream().sorted((a, b) -> b.getEdad() - a.getEdad()).toList();
    }
}