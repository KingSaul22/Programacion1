package Ejer2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static Ejer2.Paciente.MIN_PRIORIDAD;
import static Ejer2.Paciente.MAX_PRIORIDAD;

public class Hospital {
    private List<Paciente> pacientes;
    private static Integer numPaciente;

    public Hospital() {
        pacientes = new LinkedList<>();
        numPaciente = 1;
    }

    public void aniadirPaciente(Paciente paciente) {
        int posPaciente = 0;
        Iterator<Paciente> it = pacientes.iterator();
        while (it.hasNext()) {
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
     *
     * @return Una copia de la {@link Hospital#pacientes cola de pacientes}
     */
    public List<Paciente> getPacientesOrdenAtender() {
        //return pacientes.stream().toList();
        return (List<Paciente>) (((LinkedList<Paciente>) pacientes).clone());
    }

    public List<Paciente> getPacientesOrdenPorEdad() {
        return pacientes.stream().sorted((a, b) -> b.getEdad() - a.getEdad()).toList();
    }

    public Paciente atenderPaciente() {
        return ((LinkedList<Paciente>) pacientes).poll();
    }

    public String getEstadisticasPrioridades() {
        StringBuilder estadisticas = new StringBuilder();
        /*List<Paciente> pacientesPorEdad = getPacientesOrdenPorEdad();

        int edadMin, edadMax, numPac;
        double edadMedia = 0;
        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            int tempI = i;
            LinkedList<Paciente> pacientesEnPrioridad =(LinkedList<Paciente>) pacientesPorEdad.stream().filter(a -> a.getPrioridad() == tempI).toList();

            edadMedia = (double) pacientesEnPrioridad.stream().mapToInt(Paciente::getEdad).sum() / pacientesEnPrioridad.size();

            estadisticas.append("Estadisticas para la prioridad '").append(i).append("':")
                    .append("\n  · Numero de pacientes: ").append(pacientesEnPrioridad.size())
                    .append("\n  · Paciente más Mayor: ").append(pacientesEnPrioridad.peekFirst().getEdad())
                    .append("\n  · Paciente más Joven").append(pacientesEnPrioridad.peekLast().getEdad())
                    .append("\n  · Media de edad: ").append(edadMedia);
        }*/

        for (int i = MIN_PRIORIDAD; i <= MAX_PRIORIDAD; i++) {
            int tempI = i;
            List<Paciente> pacientesPrioridad = pacientes.stream().filter(a -> a.getPrioridad() == tempI).toList();

            if (pacientesPrioridad.isEmpty()) {
                estadisticas.append("\nNo hay pacientes para la prioridad '").append(i).append("'.\n");
                continue;
            }

            estadisticas.append("\nEstadisticas para la prioridad '").append(i).append("':")
                    .append("\n  · Numero de pacientes: ").append(pacientesPrioridad.size())
                    .append("\n  · Paciente más Mayor: ")
                    .append(pacientesPrioridad.stream().mapToInt(Paciente::getEdad).max())
                    .append("\n  · Paciente más Joven")
                    .append(pacientesPrioridad.stream().mapToInt(Paciente::getEdad).min())
                    .append("\n  · Media de edad: ")
                    .append(pacientesPrioridad.stream().mapToInt(Paciente::getEdad).average())
                    .append("\n");
        }


        return estadisticas.toString();
        //TODO: Con la Clase Record
        //TODO: mapMultiToInt <- flat(?)
    }


}