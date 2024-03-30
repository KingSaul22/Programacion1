import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private TDemarcacion demarcacion;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;
    
    
    public Jugador(String nombre, TDemarcacion demarcacion, LocalDate fechaNacimiento, String paisNacimiento) {
        super();
        this.nombre = nombre;
        this.demarcacion = demarcacion;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
    }

    public String getNombre() {
        return nombre;
    }


    public TDemarcacion getDemarcacion() {
        return demarcacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaNacimiento, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(fechaNacimiento.format(formatter)).append(". ")
            .append(demarcacion).append(" (").append(paisNacimiento).append(")");
        
        return sb.toString();

    }

    @Override
    /**
     * Elijo que el orden natural sea por fecha de nacimiento
     */
    public int compareTo(Jugador o) {
        return this.fechaNacimiento.compareTo(o.fechaNacimiento);
    }
    
    
           
}
