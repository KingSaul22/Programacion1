package Ejer1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilsXML.AyudasXml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    private static Document doc;

    public static void main(String[] args) {
        String rutaXml = "./src/aeropuerto.xml";
        doc = AyudasXml.parsearRuta(rutaXml);

        if (doc == null) {
            System.out.println("No se ha podido parsear la ruta del documento");
        } else {
            formarRegistro();
        }
    }

    private static void formarRegistro() {
        Path outPath = Path.of("./src/Ejer1/registros.csv");
        StringBuilder registro = new StringBuilder();

        NodeList listaVuelos = doc.getElementsByTagName("vuelo");
        for (int i = 0; i < listaVuelos.getLength(); i++) {
            Element vuelo = (Element) listaVuelos.item(i);

            registro.append(vuelo.getElementsByTagName("id").item(0).getTextContent())
                    .append(":")
                    .append(vuelo.getElementsByTagName("codigo").item(0).getTextContent())
                    .append(":")
                    .append(vuelo.getElementsByTagName("compania").item(0).getTextContent())
                    .append(":")
                    .append(vuelo.getElementsByTagName("hora_salida").item(0).getTextContent())
                    .append(":")
                    .append(vuelo.getElementsByTagName("destino").item(0).getTextContent())
                    .append(System.lineSeparator());
        }

        try {
            if (!Files.exists(outPath)) Files.createFile(outPath);
            Files.writeString(outPath, registro.toString(), StandardOpenOption.APPEND);
            System.out.println("Registros completados");
        } catch (IOException e) {
            System.out.println("Se ha producido un error inesperado: " + e.getMessage());
        }
    }
}
