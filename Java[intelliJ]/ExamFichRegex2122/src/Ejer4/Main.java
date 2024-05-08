package Ejer4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utilsXML.AyudasXml;

import java.util.*;

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
        Map<Integer, Set<Node>> continentes = new HashMap<>();
        
        NodeList ids = doc.getElementsByTagName("id");
        for (int i = 0; i < ids.getLength(); i++) {
            continentes.put(Integer.parseInt(String.valueOf(ids.item(i).getTextContent().charAt(0))), new HashSet<>());
        }

        NodeList vuelos = doc.getElementsByTagName("vuelo");
        for (int i = 0; i < vuelos.getLength(); i++) {
            Element vuelo = (Element) vuelos.item(i);
            continentes.get(Integer.parseInt(String.valueOf(ids.item(i).getTextContent().charAt(0)))).add(vuelo);
        }

        String baseOutRuta = "./src/Ejer4/continente";
        for (int codContinente : continentes.keySet()) {
            Document newDoc = AyudasXml.crearDocumento();
            if (newDoc == null) continue;
            newDoc.appendChild(newDoc.createElement("vuelos"));
            newDoc.getDocumentElement().setAttribute("continente", String.valueOf(codContinente));
            for (Node vuelo : continentes.get(codContinente)) {
                newDoc.getDocumentElement().appendChild(newDoc.importNode(vuelo, true));
            }
            if (AyudasXml.guardarDocumento(newDoc, baseOutRuta + codContinente + ".xml")) {
                System.out.println("Creado el fichero para el continente con código " + codContinente);
            }
        }
    }
}
