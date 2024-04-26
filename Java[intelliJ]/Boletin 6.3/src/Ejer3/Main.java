package Ejer3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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
                plato.setAttribute("id", String.valueOf(i + 1));
            }

        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de saxe del parser\n" + e.getMessage());
        }
    }
}
