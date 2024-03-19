package colecciones.ejercicio1;

public class Opinion {
	private int valoracion;
	private String texto;
	public Opinion(int valoracion, String texto) {
		super();
		this.valoracion = valoracion;
		this.texto = texto;
	}
	public int getValoracion() {
		return valoracion;
	}
	
	public String getTexto() {
		return texto;
	}
	@Override
	public String toString() {
		return "Opinion [valoracion=" + valoracion + ", texto=" + texto + "]";
	}
	
	
	
}
