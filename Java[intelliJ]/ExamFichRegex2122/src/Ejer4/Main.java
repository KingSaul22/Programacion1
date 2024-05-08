package Ejer4;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import utilsXML.AyudasXml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Document doc;

    public static void main(String[] args) {
        String rutaXml = "./src/aeropuerto.xml";
        doc = AyudasXml.parsearRuta(rutaXml);

        if (doc == null) {
            System.out.println("No se ha podido parsear la ruta del documento");
        } else {
            continentesVuelos();
        }
    }

    private static void continentesVuelos() {
        Map<Integer, List<Node>> continentes = new HashMap<>();
        //TODO: Ejer 4 - Extra
    }
}
