package Ejer1;


import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("./src/Ejer1/web1.html");
            Element raiz = doc.getDocumentElement();
            Element titulo = (Element) raiz.getElementsByTagName("title").item(0);
            System.out.println(titulo.getTextContent());

            NodeList listDiv = raiz.getElementsByTagName("div");
            System.out.printf("En la página hay %d divisores\n", listDiv.getLength());

            int cont = 0;
            for (int i = 0; i < listDiv.getLength(); i++) {
                Element div = (Element) listDiv.item(i);
                if (div.hasAttribute("id") && !div.getAttribute("id").isBlank()) {
                    cont++;
                }
            }
            System.out.println("El número de elementos div con valor en el atributo id: " + cont);

            NodeList listImg = raiz.getElementsByTagName("img");
            for (int i = 0; i < listImg.getLength(); i++) {
                Element img = (Element) listImg.item(i);
                if (img.hasAttribute("alt") && !img.getAttribute("alt").isBlank()) {
                    System.out.printf("La imagen %d tiene el siguiente texto alternativo: %s\n", i + 1, img.getAttribute("alt"));
                } else {
                    System.out.println("La imagen " + (i + 1) + " no tiene texto alternativo");
                }
            }

            for (int i = 0; i < listDiv.getLength(); i++) {
                Element div = (Element) listDiv.item(i);
                if (div.getAttribute("class").equals("noticia")) {
                    System.out.printf("""
                                    Titular:
                                      %s
                                    Texto alternativo de la imagen:
                                      %s""",
                            div.getElementsByTagName("h2").item(0).getTextContent(),
                            ((Element) div.getElementsByTagName("img").item(0)).getAttribute("alt"));
                }
                System.out.println();
            }


            //TODO: Sin revisar otrasNoticias

        } catch (ParserConfigurationException e) {
            System.out.println("Fallo de configuracion en el Parser");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura");
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
