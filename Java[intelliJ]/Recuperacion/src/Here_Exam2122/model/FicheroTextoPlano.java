package Here_Exam2122.model;

import Here_Exam2122.interfaces.Representables;

public class FicheroTextoPlano extends FicheroTexto implements Representables {
    public FicheroTextoPlano(String nombre, String[] contenido) {
        super(nombre, contenido);
    }

    @Override
    public void representar() {
        for (String parrafo : contenido) System.out.println(parrafo);
    }
}
