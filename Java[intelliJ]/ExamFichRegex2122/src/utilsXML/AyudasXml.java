package utilsXML;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class AyudasXml {

    public static Document parsearRuta(String ruta) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(ruta);
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        }
        return null;
    }

    public static boolean guardarDocumento(Document doc, String outRuta) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outRuta);

            DOMSource source = new DOMSource(doc);

            transformer.transform(source, streamResult);
            return true;
        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
        return false;
    }

    public static Document crearDocumento() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.newDocument();
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        }
        return null;
    }
}
