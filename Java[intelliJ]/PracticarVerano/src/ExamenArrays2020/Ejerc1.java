package ExamenArrays2020;

import java.util.Arrays;

public class Ejerc1 {
    public static void main(String[] args) {
        //Arrays que nos dan

        String[] estados = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte", "Carolina del Sur",
                "Colorado", "Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware", "Distrito de Columbia",
                "Florida", "Georgia", "Hawái", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
                "Luisiana", "Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota", "Mississippi",
                "Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire",
                "Nuevo México", "Ohio", "Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Virginia Occidental", "Washington", "Wisconsin", "Wyoming"};

        int[] electores = {9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4, 5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3};

        int[] votosDemocrata = {729547, 116454, 1161167, 380494, 8753788, 1338870, 897572, 235603, 282830, 4504975, 1877963, 266891, 189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326, 1677928, 1995196, 2268839, 1367716, 485131, 1071068, 177709, 568988, 539260, 348526, 2148278, 385234, 4556124, 2189316, 93758, 2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695, 3877868, 310676, 178573, 1981473, 1742718, 188794, 1382536, 55973};

        int[] votosRepublicano = {1318255, 163387, 1252401, 684872, 4483810, 1202484, 673215, 185127, 12723, 4617886, 2089104, 128847, 409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154, 943169, 1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922, 512058, 345790, 1601933, 319667, 2819534, 2362631, 216794, 2841005, 949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047, 515231, 95369, 1769443, 1221747, 489371, 1405284, 174419};
        // calcula los resultados

        int totalElectores = Arrays.stream(electores).sum();
        int totalVotosDemocrata = Arrays.stream(votosDemocrata).sum();
        int totalVotosRepublicano = Arrays.stream(votosRepublicano).sum();
        //Saber el partido que ha ganado con mas votos
        String partidoGanador = (totalVotosDemocrata > totalVotosRepublicano) ? "Demócrata" : " Republicano";
        //Valores iniciales

        int estadosDemocrata = 0;
        int estadosRepublicano = 0;
        String estadoMaxElectoresDemocrata = "";
        String estadoMaxElectoresRepublicano = "";
        int maxElectoresDemocrata = 0;
        int maxElectoresRepublicano = 0;

        for (int i = 0; i < estados.length; i++) {
            if (votosDemocrata[i] > votosRepublicano[i]) {
                estadosDemocrata++;
                if (electores[i] > maxElectoresDemocrata) {
                    maxElectoresDemocrata = electores[i];
                    estadoMaxElectoresDemocrata = estados[i];
                }
            } else {
                estadosRepublicano++;
                if (electores[i] > maxElectoresRepublicano) {
                    maxElectoresRepublicano = electores[i];
                    estadoMaxElectoresRepublicano = estados[i];
                }
            }
        }
        //Imprimir lso resultados
        System.out.println("Presidente electo de los Estados Unidos: " + partidoGanador);
        System.out.println("Total de electores: " + totalElectores);
        System.out.println("Partido más votado (número total de votos): " + ((totalVotosDemocrata > totalVotosRepublicano) ? "Demócrata" : "Republicano"));
        System.out.println("Estados que apoyan al partido Demócrata: " + estadosDemocrata);
        System.out.println("Estados que apoyan al partido Republicano: " + estadosRepublicano);
        System.out.println("Estado con más electores para el partido Demócrata: " + estadoMaxElectoresDemocrata + " (" + maxElectoresDemocrata + " electores)");
        System.out.println("Estado con más electores para el partido Republicano: " + estadoMaxElectoresRepublicano + " (" + maxElectoresRepublicano + " electores)");
    }


}
