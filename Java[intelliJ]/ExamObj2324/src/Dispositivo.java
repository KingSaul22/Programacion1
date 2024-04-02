public class Dispositivo {
    private String nombre, conexion, protocolo;
    private String conexionActivo, protocoloActivo;

    public Dispositivo(String nombre, String conexion, String protocolo) {
        this.nombre = nombre;
        this.conexion = conexion;
        this.protocolo = protocolo;
    }

    public void setConexionActivo(String conexionActivo) {
        this.conexionActivo = conexionActivo;
    }

    public void setProtocoloActivo(String protocoloActivo) {
        this.protocoloActivo = protocoloActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConexion() {
        return conexion;
    }

    public String getProtocolo() {
        return protocolo;
    }

    @Override
    public String toString() {
        return "El dispositivo " + nombre + " se ha conectado usando la conexion " + conexionActivo
                + " a traves del protocolo " + protocoloActivo + ".";
    }
}
