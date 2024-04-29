package Ejer3b;

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

public class Main {
    private static Document doc;
    private static Node raiz;

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(".\\src\\Ejer3b\\desayuno.xml");
            raiz = doc.getDocumentElement();
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        }

        //PARTE UNO
        getDesayunosRangoPrecio(0, 5);
        System.out.println();

        //PARTE DOS
        getDesayunosRangoCalorias(0, 500);
        System.out.println();

        //PARTE TRES
        addIdToPlato();

        //PARTE CUATRO
        Element churros = newPlato(
                "Churros Bermudo",
                1.50,
                "Unos deliciosos churros, hechos con todo el amor del profesor a sus alumnos",
                500);
        aniadirPlato(churros);

        //PARTE CINCO
        copyDesayunosSaludables(true);
    }

    private static void getDesayunosRangoPrecio(double min, double max) {
        NodeList platos = doc.getElementsByTagName("food");
        if (platos == null) return;

        System.out.println("Lista de platos con un precio dentro del rango [" + min + ", " + max + "]:");
        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);
            String precioStr = plato.getElementsByTagName("price").item(0)
                    .getTextContent().replace(',', '.');
            double precio = Double.parseDouble(precioStr.substring(0, precioStr.length() - 1));
            if (precio >= min && precio <= max) {
                System.out.println("  · " + plato.getElementsByTagName("name").item(0).getTextContent() +
                        " (" + plato.getElementsByTagName("price").item(0).getTextContent() + ")");
            }
        }
    }

    private static void getDesayunosRangoCalorias(int min, int max) {
        NodeList platos = doc.getElementsByTagName("food");
        if (platos == null) return;

        System.out.println("Lista de platos con unas calorias dentro del rango [" + min + ", " + max + "]:");
        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);
            int calorias = Integer.parseInt(plato.getElementsByTagName("calories").item(0).getTextContent());
            if (calorias >= min && calorias <= max) {
                System.out.println("  · " + plato.getElementsByTagName("name").item(0).getTextContent() +
                        " (" + plato.getElementsByTagName("calories").item(0).getTextContent() + ")");
            }
        }
    }

    private static void addIdToPlato() {
        NodeList platos = doc.getElementsByTagName("food");
        if (platos == null) return;

        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);
            plato.setAttribute("id", String.valueOf(i + 1));
        }
    }

    private static Element newPlato(String nombre, double precio, String descripcion, int calorias) {
        Element plato = doc.createElement("food");

        Element nombrePlato = doc.createElement("name");
        nombrePlato.setTextContent(nombre);
        plato.appendChild(nombrePlato);

        Element precioPlato = doc.createElement("price");
        precioPlato.setTextContent(precio + "€");
        plato.appendChild(precioPlato);

        Element descripcionPlato = doc.createElement("description");
        descripcionPlato.setTextContent(descripcion);
        plato.appendChild(descripcionPlato);

        Element caloriasPlato = doc.createElement("calories");
        caloriasPlato.setTextContent(String.valueOf(calorias));
        plato.appendChild(caloriasPlato);

        return plato;
    }

    private static void aniadirPlato(Element plato) {
        String nameBase = plato.getElementsByTagName("name").item(0).getTextContent();
        NodeList platos = doc.getElementsByTagName("food");
        for (int i = 0; i < platos.getLength(); i++) {
            Element nPlato = (Element) platos.item(i);
            if (nPlato.getElementsByTagName("name").item(0).getTextContent().equals(nameBase)) {
                System.out.println("Ya existe un plato con el nombre " + nameBase);
                return;
            }
        }

        int lastId = getLastIntIdFood();
        plato.setAttribute("id", String.valueOf(++lastId));
        platos.item(platos.getLength() - 1).appendChild(plato);

        File outFile = new File(".\\src\\Ejer3b\\desayunoB.xml");
        raiz.appendChild(plato);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outFile);

            DOMSource source = new DOMSource(doc);

            transformer.transform(source, streamResult);
            System.out.println("Se ha guardado con exito el nuevo palto");
        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }

    private static void copyDesayunosSaludables(final boolean sobreEscribir) {
        File outFile = new File(".\\src\\Ejer3b\\desayuno_saludable.xml");
        if (outFile.exists() && !sobreEscribir) {
            System.out.println("Ya existe el desayuno saludable");
            return;
        }


        NodeList platos = doc.getElementsByTagName("food");
        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);
            if (Integer.parseInt(plato.getElementsByTagName("calories").item(0).getTextContent()) > 500) {
                raiz.removeChild(plato);
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
            System.out.println("Fichero 'desayuno_saludable.xml' creado con exito");
        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }

    private static int getLastIntIdFood() {
        int last = 0;
        NodeList platos = doc.getElementsByTagName("food");
        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);
            int id = Integer.parseInt(plato.getAttribute("id"));
            if (last < id) {
                last = id;
            }
        }

        return last;
    }
}
