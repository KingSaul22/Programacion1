package Ejer3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import utilsXML.AyudasXml;

public class Main {
    private static Document doc;

    public static void main(String[] args) {
        String rutaXml = "./src/aeropuerto.xml";
        doc = AyudasXml.parsearRuta(rutaXml);

        if (doc == null) {
            System.out.println("No se ha podido parsear la ruta del documento");
        } else {
            nombresAerolineasXml();
        }
    }

    private static void nombresAerolineasXml() {
        String outRuta = "./src/Ejer3/aerolineas.xml";
        Document newDoc = AyudasXml.crearDocumento();
    }
}
