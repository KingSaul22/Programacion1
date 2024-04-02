package interfaces;

import exception.JugueteException;
import modelo.Juguete;

public interface Apilable {
    public default void apilar(Juguete juguete) throws JugueteException {
        if (!(juguete instanceof Apilable)) throw new JugueteException("Juguete no apilable");
        if (this == juguete) throw new JugueteException("No puedes apilarte a ti mismo");
        if (juguete.getClass() != this.getClass())
            throw new JugueteException("No puedes apilar un objeto de tipo " +
                    this.getClass().getSimpleName() + " y tipo " +
                    juguete.getClass().getSimpleName()
            )
        ;

    }
}
