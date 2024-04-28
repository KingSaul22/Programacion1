package Ejer3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(".\\src\\Ejer3\\desayuno.xml");

            //PARTE UNO
            double precioMax = 5.0;
            System.out.println("Platos que cuestan menos de " + precioMax + "€");

            NodeList platos = doc.getElementsByTagName("food");
            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                String precio = plato.getElementsByTagName("price").item(0)
                        .getTextContent().replace(",", ".");
                if (precioMax > Double.parseDouble(precio.substring(0, precio.length() - 1))) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }


            //PARTE DOS
            int calMax = 500;
            System.out.println("\nPlatos que tienen menos de " + calMax + " calorias");

            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                String calorias = plato.getElementsByTagName("calories").item(0).getTextContent();
                if (calMax > Integer.parseInt(calorias)) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }


            //PARTE TRES
            System.out.println("\nAgregación del atributo id");
            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                Node parent = plato.getParentNode();
                parent.removeChild(plato);
                plato.setAttribute("id", String.valueOf(i + 1));
                parent.appendChild(plato);
            }


            //PARTE CUATRO
            Element platoNuevo = doc.createElement("food");
            Element dataPlatoNuevo = doc.createElement("name");
            dataPlatoNuevo.setTextContent("Churros Bermudo");
            platoNuevo.appendChild(dataPlatoNuevo);
            dataPlatoNuevo = doc.createElement("price");
            dataPlatoNuevo.setTextContent("1.50€");
            platoNuevo.appendChild(dataPlatoNuevo);
            dataPlatoNuevo = doc.createElement("description");
            dataPlatoNuevo.setTextContent("Unos deliciosos churros, hechos con todo el amor del profesor a sus alumnos");
            platoNuevo.appendChild(dataPlatoNuevo);
            dataPlatoNuevo = doc.createElement("calories");
            dataPlatoNuevo.setTextContent("500");
            platoNuevo.appendChild(dataPlatoNuevo);

            File outFile = new File(".\\src\\Ejer3\\desayunoB.xml");
            Files.deleteIfExists(outFile.toPath());
            Files.createFile(outFile.toPath());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outFile);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, streamResult);


            //PARTE CINCO
            platos = doc.getElementsByTagName("food");
            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                if (Integer.parseInt(plato.getAttribute("calories")) > 500) {
                    plato.getParentNode().removeChild(plato);
                }
            }
            File outFileB = new File(".\\src\\Ejer3\\desayuno_saludable.xml");
            Files.deleteIfExists(outFileB.toPath());
            Files.createFile(outFileB.toPath());
            streamResult = new StreamResult(outFileB);
            transformer.transform(source, streamResult);

        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        } catch (TransformerConfigurationException e) {
            System.out.println("Error en la configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }
}
