package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.CocheException;
import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;

public class DepositoGasolina {
    /**
     * La presión es correcta(true) o incorrecta(false)
     */
    boolean presionCorrecta;
    //Capacidad medida en Litros (L)
    int capacidad;
    double nivelCombustible;

    public DepositoGasolina(boolean presionCorrecta, int capacidad, double nivelCombustible) throws ValorNoValidoException {
        this.presionCorrecta = presionCorrecta;
        setCapacidad(capacidad);
        setNivelCombustible(nivelCombustible);
    }

    public void setCapacidad(int capacidad) throws ValorNoValidoException {
        if (capacidad < 1) {
            throw new ValorNoValidoException("La capacidad del deposito no puede ser inferior a 1");
        }
        this.capacidad = capacidad;
    }

    public void setNivelCombustible(double nivelCombustible) throws ValorNoValidoException {
        if (nivelCombustible < 0 || nivelCombustible > capacidad) {
            throw new ValorNoValidoException("Nivel de combustible fuera del rango permitido [0," + capacidad + "]");
        }
        this.nivelCombustible = nivelCombustible;
    }

    /**
     * Comprueba que el nivel de combustible y {@link DepositoGasolina#presionCorrecta presión} sean correctos;
     * en caso contrario, se lanza una excepción que incluye un mensaje con los errores concretos
     *
     * @return {@code true} cuando el deposito funciona correctamente
     * @throws CocheException Cuando el deposito tiene fallos
     * @see <a href="https://github.com/iker0411">GitHub Iker Mendez</a>
     */
    public boolean isFuncional() throws CocheException {
        StringBuilder fallos = new StringBuilder();
        if (!presionCorrecta) fallos.append(" ·Presión incorrecta\n");
        if (nivelCombustible <= 0) fallos.append(" ·Deposito vacio");

        if (fallos.isEmpty()) return true;
        throw new CocheException("Errores del deposito de gasolina:\n" + fallos);
    }
}
