package XML;

import Exceptions.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
     * @throws XmlException Al llamar al método {@link AyudasXml#crearDocumentBuilder()} o al {@link DocumentBuilder#parse(String) parsear} el XML indicado.
     */
    public static Document parsearRuta(String rutaXML) throws XmlException {
        crearDocumentBuilder();
        try {
            return db.parse(rutaXML);
        } catch (IllegalArgumentException e) {
            throw new XmlException("No se reconoce el fichero asignado\n" + e.getMessage());
        } catch (IOException e) {
            throw new XmlException("Error en la lectura del archivo\n" + e.getMessage());
        } catch (SAXException e) {
            throw new XmlException("Error de SAX del parser\n" + e.getMessage());
        }
    }

    /**
     * Haciendo uso del {@link DocumentBuilder#newDocument() newDocument()}
     * de nuestra variable {@link AyudasXml#db db}, se crea un nuevo {@link Document}.
     *
     * @return Una nueva instancia de {@link Document}.
     * @throws XmlException Cuando se necesitaba crear un {@link DocumentBuilder} pero se ha producido un error.
     */
    public static Document crearDocumento() throws XmlException {
        crearDocumentBuilder();
        return db.newDocument();
    }

    /**
     * Se crea un nuevo {@link Document} con el método {@link AyudasXml#crearDocumento()}
     * y se le asigna un elemento raiz.
     *
     * @param raiz nombre que se asignará al {@link org.w3c.dom.Element elemento} padre o raiz.
     * @return Una nueva instancia de {@link Document} con un elemento raiz.
     * @throws XmlException Al llamar al método {@link AyudasXml#crearDocumento()}.
     */
    public static Document crearDocumentoConRaiz(String raiz) throws XmlException {
        Document doc = crearDocumento();
        doc.appendChild(doc.createElement(raiz));
        return doc;
    }

    /**
     * Se crea un nuevo {@link Document} con el método {@link AyudasXml#crearDocumento()}
     * y se le asigna un elemento raiz.
     * Este elemento raiz es el resultado de {@link Document#importNode(Node, boolean) importar}
     * el Nodo indicado al nuevo Document.
     *
     * @param raiz {@link Element} que se usará como raiz para el nuevo Document.
     * @param deep En el caso de {@code true} se importarán, no solo el Nodo indicado, sino también sus hijos.
     * @return Una nueva instancia de {@link Document} con un elemento raiz.
     * @throws XmlException Al llamar al método {@link AyudasXml#crearDocumento()}.
     */
    public static Document crearDocumentoConRaiz(Element raiz, boolean deep) throws XmlException {
        Document doc = crearDocumento();
        doc.appendChild(doc.importNode(raiz, deep));
        return doc;
    }

    /**
     * Guarda el {@link Document} en la ruta especificada, ambos introducidos por parametros.
     *
     * @param doc     El documento a guardar.
     * @param outRuta La ruta donde guardar el documento.
     * @throws XmlException Cuando se produce un error con el {@link Transformer}.
     */
    public static void guardarDocumento(Document doc, String outRuta) throws XmlException {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            StreamResult streamResult = new StreamResult(outRuta);

            DOMSource source = new DOMSource(doc);

            transformer.transform(source, streamResult);
        } catch (TransformerConfigurationException e) {
            throw new XmlException("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            throw new XmlException("Error al transformar\n" + e.getMessage());
        }
    }

    /**
     * Se buscará al último nodo con el atributo a buscar y se devolverá su valor.
     * La busqueda se realizara unicamente entre los hijos directos del nodo indicado.
     *
     * @param node El nodo al que se le revisarán los hijos
     * @param attr El nombre del atributo a buscar
     * @return El valor del atributo del último nodo que tenga el atributo
     */
    public static String getLastValueAttr(Node node, String attr) {
        NodeList listChildren = node.getChildNodes();
        for (int i = listChildren.getLength() - 1; i >= 0; i--) {
            if (listChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) listChildren.item(i);
                if (element.hasAttribute(attr)) {
                    return element.getAttribute(attr);
                }
            }
        }
        return null;
    }

    /**
     * Crea un nuevo DocumentBuilder, si no existe ya uno, y lo asigna a la variable {@link AyudasXml#db db}.
     * <p>
     * MÉTODO PRIVADO.
     *
     * @throws XmlException Cuando hay un error relacionado con {@link DocumentBuilderFactory}
     *                      o con la configuración del {@link DocumentBuilder}.
     */
    private static void crearDocumentBuilder() throws XmlException {
        if (db != null) return;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (FactoryConfigurationError e) {
            throw new XmlException("Error al crear una instancia de DocumentBuilderFactory\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new XmlException("Error de configuración del parser\n" + e.getMessage());
        }
    }
}
