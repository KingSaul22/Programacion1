package Ejer2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static DocumentBuilder db;
    private static Document doc;

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse("./src/Ejer2/simpsons.xml");
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        }

        //APARTADO UNO
        int anio = 1992;
        capitulosPosterioresAnio(anio);

        //APARTADO DOS
        int minPalabras = 30;
        copyCapitulosMasPalabras(minPalabras);

        //APARTADO TRES
        try {
            doc = db.parse("./src/Ejer2/simpsons.xml");
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        }
        copySimpsonsProtasResaltados();
    }

    private static void capitulosPosterioresAnio(final int anio) {
        NodeList capitulos = doc.getElementsByTagName("capitulo");

        boolean hayCapitulos = false;
        for (int i = 0; i < capitulos.getLength(); i++) {
            Element capitulo = (Element) capitulos.item(i);
            String fecha = capitulo.getElementsByTagName("fecha_emision").item(0).getTextContent();
            if (anio < Integer.parseInt(fecha.substring(fecha.length() - 4))) {
                System.out.printf("""
                                
                                Titulo: %s
                                Emisión: %s""",
                        capitulo.getElementsByTagName("nombre").item(0).getTextContent(),
                        fecha);
                hayCapitulos = true;
            }
        }
        if (!hayCapitulos) {
            System.out.println("No hay capitulos posteriores al año " + anio);
        } else {
            System.out.println();
        }
    }

    private static void copyCapitulosMasPalabras(final int MIN_PALABRAS) {
        File outFile = new File("./src/Ejer2/simpsonsB.xml");
        Pattern pt = Pattern.compile("\\b(\\p{L}+)\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        NodeList capitulos = doc.getElementsByTagName("capitulo");
        for (int i = 0; i < capitulos.getLength(); i++) {
            long palabras = 0;
            Element capitulo = (Element) capitulos.item(i);
            String sinopsis = capitulo.getElementsByTagName("sinopsis").item(0).getTextContent();

            Matcher m = pt.matcher(sinopsis);
            palabras = m.results().count();
            /*while (m.find()) {
                palabras++;
            }*/

            if (palabras <= MIN_PALABRAS) {
            //if (m.groupCount() <= MIN_PALABRAS) {
                capitulo.getParentNode().removeChild(capitulo);
                i--;
            }
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outFile);

            DOMSource source = new DOMSource(doc);

            transformer.transform(source, streamResult);
            System.out.println("\nFichero 'simpsonsB.xml' creado con exito");
        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }

    private static void copySimpsonsProtasResaltados() {
        File outFile = new File("./src/Ejer2/simpsonsC.xml");
        Pattern pt = Pattern.compile("\\b(marge|lisa|bart|homer|maggie)\\b", Pattern.CASE_INSENSITIVE);
        NodeList sinopsis = doc.getElementsByTagName("sinopsis");

        for (int i = 0; i < sinopsis.getLength(); i++) {
            Element sinopsisItem = (Element) sinopsis.item(i);
            String contenido = sinopsisItem.getTextContent();
            contenido = pt.matcher(contenido).replaceAll("**$1**");
            sinopsisItem.setTextContent(contenido);
        }

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outFile);

            DOMSource source = new DOMSource(doc);

            transformer.transform(source, streamResult);
            System.out.println("\nFichero 'simpsonsC.xml' creado con exito");
        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }
}