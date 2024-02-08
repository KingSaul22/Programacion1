import Interfaces.Representable;

public class FicheroTextoPlano extends FicheroTexto implements Representable {
    public FicheroTextoPlano(String name,  String[] contenido) {
        super(name, contenido);
    }


    @Override
    public void imprimir() {
        for (int i = 0; i < contenido[0].length; i++) System.out.println(contenido[0][i]);
    }
}
