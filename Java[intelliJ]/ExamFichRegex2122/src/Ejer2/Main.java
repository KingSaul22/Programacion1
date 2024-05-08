package Ejer2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilsXML.AyudasXml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static Document doc;

    public static void main(String[] args) {
        String rutaXml = "./src/aeropuerto.xml";
        doc = AyudasXml.parsearRuta(rutaXml);

        if (doc == null) {
            System.out.println("No se ha podido parsear la ruta del documento");
        } else {
            cambiarFormato();
        }
    }

    private static void cambiarFormato() {
        Document newDoc = AyudasXml.crearDocumento();
        if (newDoc == null) {
            System.out.println("No se ha podido crear la ruta del documento nuevo");
            return;
        }

        String outRuta = "./src/Ejer2/aeropuertoB.xml";
        Pattern pt = Pattern.compile("(\\d)(\\d{2})(\\d{2})(\\d{3})");

        NodeList vuelos = doc.getElementsByTagName("vuelo");
        for (int i = 0; i < vuelos.getLength(); i++) {
            Element vuelo = (Element) vuelos.item(i);

            String id = vuelo.getElementsByTagName("id").item(0).getTextContent();
            Matcher m = pt.matcher(id);
            if (!m.matches()) continue;
            id = m.group(3) + m.group(4) + m.group(2) + m.group(1);

            vuelo.getElementsByTagName("id").item(0).setTextContent(id);
        }

        newDoc.appendChild(newDoc.importNode(doc.getDocumentElement(), true));
        NodeList companias = newDoc.getElementsByTagName("compania");
        for (int i = 0; i < companias.getLength(); i++) {
            companias.item(i).getParentNode().removeChild(companias.item(i));
            i--;
        }

        if (AyudasXml.guardarDocumento(newDoc, outRuta)) {
            System.out.println("Se ha guardado el documento correctamente");
        } else {
            System.out.println("Se ha producido un error");
        }
    }

    /*private static void cambiarFormatoA() {
        String outRuta = "./src/Ejer2/aeropuertoB.xml";
        Pattern pt = Pattern.compile("(\\d)(\\d{2})(\\d{2})(\\d{3})");

        NodeList vuelos = doc.getElementsByTagName("vuelo");
        for (int i = 0; i < vuelos.getLength(); i++) {
            Element vuelo = (Element) vuelos.item(i);
            vuelo.removeChild(vuelo.getElementsByTagName("compania").item(0));

            String id = vuelo.getElementsByTagName("id").item(0).getTextContent();
            Matcher m = pt.matcher(id);
            if (!m.matches()) continue;
            id = m.group(3) + m.group(4) + m.group(2) + m.group(1);
            //id = id.substring(3, 5) + id.substring(5) + id.substring(1,3) + id.charAt(0);

            vuelo.getElementsByTagName("id").item(0).setTextContent(id);
        }

        if (AyudasXml.guardarDocumento(doc, outRuta)) {
            System.out.println("Se ha guardado el documento correctamente");
        } else {
            System.out.println("Se ha producido un error");
        }
    }*/
}
