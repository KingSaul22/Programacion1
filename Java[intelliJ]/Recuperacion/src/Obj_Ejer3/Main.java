package Obj_Ejer3;

import Obj_Ejer3.Enums.WeatherCondition;
import Obj_Ejer3.Excepciones.MuerteException;
import Obj_Ejer3.Excepciones.RoundStartException;
import Obj_Ejer3.Excepciones.ValorNoValidoException;
import Obj_Ejer3.Interfaces.Atacable;
import Obj_Ejer3.Model.*;
import utils.UserDataCollector;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pokemon[] pokemons = new Pokemon[6];
        for (int i = 0; i < pokemons.length; i++) {
            pokemons[i] = generateRandomPokemon();
        }

        System.out.println("Los pokemons que han sido seleccionados son:");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getNombre() + " - " + pokemon.getClass().getSimpleName() + " - " + pokemon.getPuntosSalud() + " puntos de salud");
        }

        while (!hayGanador(pokemons)) {
            WeatherCondition weatherCondition = generateRandomWeatherCondition();
            System.out.println();
            System.out.println("##################################################");
            System.out.println("##################################################");
            System.out.println("El clima en esta ronda es " + weatherCondition);

            // Mostramos los mensajes de inicio de ronda, si los hubiera
            for (Pokemon pokemon : pokemons) {
                try {
                    pokemon.roundStart(weatherCondition);
                } catch (RoundStartException e) {
                    System.out.println(e.getMessage());
                }
            }

            /*
            Iremos por turnos, dejando que el pokemon que ocupe la posición que le toca pueda seleccionar otro pokemon
            para atacar
             */
            for (int i = 0; i < pokemons.length; i++) {
                Pokemon pokemon = pokemons[i];

                if (pokemon.estaVivo()) {
                    System.out.println();
                    System.out.println("Es el turno de " + pokemon.getNombre());

                    Atacable atacable = seleccionaPokemonAtacable(pokemons, i);
                    try {
                        pokemon.atacar(atacable, weatherCondition);
                        System.out.println(pokemon.getNombre() + " ha atacado a " + ((Pokemon) atacable).getNombre() + " - " + ((Pokemon) atacable).getPuntosSalud() + " puntos de salud");
                    } catch (MuerteException e) {
                        System.out.println(e.getMessage());
                        if (hayGanador(pokemons)) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("El ganador es " + getGanador(pokemons).getNombre());

    }

    private static Pokemon getGanador(Pokemon[] pokemons) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.estaVivo()) {
                return pokemon;
            }
        }
        return null;
    }

    private static Atacable seleccionaPokemonAtacable(Pokemon[] pokemons, int i) {
        // Mostramos todos los pokemons que están vivos y que no son él mismo
        System.out.println("Estos son tus rivales:");
        int numPokemonVivos = 0;

        ArrayList<Atacable> atacables = new ArrayList<>();

        for (int j = 0; j < pokemons.length; j++) {
            // TODO: comprobar que el pokemon está vivo, que no es él mismo y que puede ser atacado
            if (j != i && pokemons[j].estaVivo() && pokemons[j] instanceof Atacable) {
                System.out.println((numPokemonVivos + 1) + ": " + pokemons[j].getNombre() + " - " + pokemons[j].getClass().getSimpleName() + " - " + pokemons[j].getPuntosSalud() + " puntos de salud");
                numPokemonVivos++;
                atacables.add((Atacable) pokemons[j]);
            }
        }

        int enteroIntroducido = UserDataCollector.getEnteroMinMax("Selecciona un pokemon para atacar", 1, numPokemonVivos);

        return atacables.get(enteroIntroducido - 1);
    }

    private static boolean hayGanador(Pokemon[] pokemons) {
        int contador = 0;
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].getPuntosSalud() > 0) {
                contador++;
            }
        }
        return contador == 1;
    }

    /**
     * Genera un pokemon de tipo aleatorio entre PokemonAgua, PokemonFuego, PokemonElectrico y PokemonTierra. Los datos
     * de ataque, defensa y puntos de salud son aleatorios:
     * - puntos de salud entre 50 y 100
     * - ataque entre 5 y 15
     * - defensa entre 5 y 25
     * <p>
     * Hay que tener en cuenta que cada una de estas clases tiene diferentes parámetros en su constructor.
     *
     * @return Pokemon generado
     */
    private static Pokemon generateRandomPokemon() {
        int random = (int) (Math.random() * 5);
        boolean added = false;

        while (!added) {
            try {
                switch (random) {
                    case 0:
                        return new PokemonAgua(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 11 + 10));
                    case 1:
                        return new PokemonFuego(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 6 + 5));
                    case 2:
                        return new PokemonElectrico(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 6 + 10));
                    case 3:
                        return new PokemonTierra(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 9 + 1));
                    case 4:
                        return new PokemonDivino(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5));
                    default:
                        return null;
                }
            } catch (ValorNoValidoException ignore) {
                // No hacemos nada
            }
            added = true;
        }

        // Nunca llegará aquí
        return null;

    }

    /**
     * Genera un nombre de pokemon aleatorio entre 50 nombres predefinidos
     *
     * @return Nombre de pokemon aleatorio
     */
    private static String generaNombrePokemonAleatorio() {
        String[] nombres = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Jigglypuff", "Meowth", "Psyduck", "Vulpix", "Gengar", "Gyarados", "Lapras", "Eevee", "Snorlax", "Articuno", "Zapdos", "Moltres", "Mewtwo", "Mew", "Chikorita", "Cyndaquil", "Totodile", "Togepi", "Ampharos", "Bellossom", "Marill", "Sudowoodo", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Swinub", "Corsola", "Remoraid", "Delibird", "Mantine", "Skarmory", "Houndour", "Phanpy"};
        return nombres[(int) (Math.random() * nombres.length)];
    }

    private static WeatherCondition generateRandomWeatherCondition() {
        int random = (int) (Math.random() * 4);
        return switch (random) {
            case 0 -> WeatherCondition.LLUVIA;
            case 1 -> WeatherCondition.SOLEADO;
            case 2 -> WeatherCondition.TORMENTA_ELECTRICA;
            case 3 -> WeatherCondition.TORMENTA_ARENA;
            default -> null;
        };
    }
}
