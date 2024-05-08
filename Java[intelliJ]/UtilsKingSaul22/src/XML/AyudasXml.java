package XML;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * La clase AyudasXml proporciona un conjunto de utilidades para facilitar el manejo de archivos XML,
 * incluyendo la lectura y escritura de documentos XML.
 * Esta clase busca evitar repetir código.
 * <p>
 * {@author <a href="https://github.com/KingSaul22">@KingSaul22</a>}
 * Fecha: [2024/05/08]
 */
public class AyudasXml {
    /**
     * Una instancia de {@link DocumentBuilder} que se usará para los métodos de esta clase.
     */
    private static DocumentBuilder db = null;

    /**
     * Se parsea el archivo XML y devuelve un {@link Document} con la información.
     *
     * @param rutaXML Ruta del fichero XML a leer y parsear.
     * @return Un nuevo {@link Document} con la información del archivo indicado.
     */
    public static Document parsearRuta(String rutaXML) {
        crearDocumentBuilder();
        try {
            return db.parse(rutaXML);
        } catch (IllegalArgumentException e) {
            System.out.println("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error de SAX del parser\n" + e.getMessage());
        }
        return null;
    }

    /**
     * Haciendo uso del {@link DocumentBuilder#newDocument() newDocument()}
     * de nuestra variable {@link AyudasXml#db db}, se crea un nuevo {@link Document}.
     *
     * @return Una nueva instancia de {@link Document}.
     */
    public static Document crearDocumento() {
        crearDocumentBuilder();
        return db.newDocument();
    }

    /**
     * Guarda el {@link Document} en la ruta especificada, ambos introducidos por parametros.
     *
     * @param doc     El documento a guardar.
     * @param outRuta La ruta donde guardar el documento.
     * @return {@code true} en el caso de que se guarde exitosamente, {@code false} en el caso contrario.
     */
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

    /**
     * Crea un nuevo DocumentBuilder, si no existe ya uno, y lo asigna a la variable {@link AyudasXml#db db}.
     */
    private static void crearDocumentBuilder() {
        if (db != null) return;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (FactoryConfigurationError e) {
            System.out.println("Error al crear una instancia de DocumentBuilderFactory\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del parser\n" + e.getMessage());
        }
    }
}
