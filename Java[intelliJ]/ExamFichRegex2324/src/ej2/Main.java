package ej2;

import Exceptions.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utils.AyudasNIO;
import utils.AyudasXml;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private static final String BASE_PATH = "./src/ej2/";

    /**
     * Fíjate en el archivo productos.xml. Necesitamos reconfigurar su estructura. Para ello:
     * Crea un nuevo archivo productosCategorizados.xml, en el que metas los productos agrupados por categorías.
     * Es decir, habrá un nodo raíz llamado categorías, dentro del mismo, una categoría con un atributo nombre,
     * y dentro de la misma, todos los productos que compartan dicha categoría y que cumplan las siguientes condiciones:
     * Su nombre no debe tener menos de 5 ni más de 45 caracteres. Se permite CUALQUIER carácter, incluidos letras,
     * símbolos, espacios, etc.
     * La descripción debe tener entre 10 y 50 palabras.
     * Debe tener categoría.
     * La categoría deberá desaparecer del elemento producto, pues ahora estarán agrupados bajo un elemento categoría.
     * Los precios vienen indistintamente con un punto o una coma. En el nuevo fichero todos los productos deben tener un punto.
     * Eso no significa que los productos con una coma sean incorrectos.
     * Aquellos productos que no cumplan con algún requisito, deberán ir a otro fichero llamado productosIncompletos.xml.
     * En el mismo, deberás introducir los productos también separados por categorías, igual que el original.
     * Aquellos productos sin categoría deben agruparse bajo una categoría llamada “Sin categoría”.
     */
    public static void main(String[] args) {
        Document doc = null, newDocValid = null, newDocInvalid = null;
        try {
            doc = AyudasXml.parsearRuta(BASE_PATH + "productos.xml");
            newDocValid = AyudasXml.crearDocumentoConRaiz("categorias");
            newDocInvalid = AyudasXml.crearDocumentoConRaiz("categorias");
        } catch (XmlException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        HashMap<String, ArrayList<Element>> categoriasProductos = productosPorCategorias(doc);
        ArrayList<Element> sinCategoria = categoriasProductos.get("");
        categoriasProductos.put("Sin Categoria", sinCategoria);
        categoriasProductos.remove("");

        HashMap<String, ArrayList<Element>> categoriasProductosValidos = new HashMap<>();
        HashMap<String, ArrayList<Element>> categoriasProductosNoValidos = new HashMap<>();

        for (String categoria : categoriasProductos.keySet()) {
            for (Element producto : categoriasProductos.get(categoria)) {
                if (validProducto(producto)) {
                    organizarMapaCategorias(categoriasProductosValidos, producto, categoria);
                } else {
                    organizarMapaCategorias(categoriasProductosNoValidos, producto, categoria);
                }
            }
        }

        completarDocPorCategorias(newDocValid, categoriasProductosValidos);
        guardarDocumento(newDocValid, "productosCategorizados.xml");
        completarDocPorCategorias(newDocInvalid, categoriasProductosNoValidos);
        guardarDocumento(newDocInvalid, "productosIncompletos.xml");
    }

    /**
     * A un Documento dado, se le crean los elementos categoria y
     * dentro de cada categoria se importan los productos correspondientes
     *
     * @param doc                 Documento al que se importará
     * @param categoriasProductos Categorias con un ArrayList de Productos
     */
    private static void completarDocPorCategorias(Document doc, HashMap<String, ArrayList<Element>> categoriasProductos) {
        for (String categoria : categoriasProductos.keySet()) {
            Element newCateg = doc.createElement("categoria");
            newCateg.setAttribute("nombre", categoria);

            for (Element producto : categoriasProductos.get(categoria)) {
                Element newProducto = cloneElement(doc, producto);
                Element precio = (Element) newProducto.getElementsByTagName("precio").item(0);
                precio.setTextContent(precio.getTextContent().replace(',', '.'));
                newCateg.appendChild(newProducto);

                producto.getParentNode().removeChild(producto);
            }
            doc.getDocumentElement().appendChild(newCateg);
        }
    }

    /**
     * Devuelve un nuevo Mapa cuyas claves son las categorias y
     * los valores una lista con todos los productos de esa categoria
     *
     * @param doc Documento del que comprobar los Productos
     * @return Un mapa con la categoria y los producctos bajo esa categoria
     */
    private static HashMap<String, ArrayList<Element>> productosPorCategorias(Document doc) {
        HashMap<String, ArrayList<Element>> productoCategorias = new HashMap<>();

        NodeList productos = doc.getElementsByTagName("producto");
        for (int i = 0; i < productos.getLength(); i++) {
            Element producto = (Element) productos.item(i);
            organizarMapaCategorias(productoCategorias, producto);
        }

        return productoCategorias;
    }

    /**
     * Guarda en el mapa el Elemento según la categoria indicada por parametros
     *
     * @param productosCategorias Mapa donde se organizan los productos por Categorias
     * @param producto            Elemento a guardar
     * @param categoria           Nombre de la categoria donde asignar el producto
     */
    private static void organizarMapaCategorias(HashMap<String, ArrayList<Element>> productosCategorias, Element producto, String categoria) {
        ArrayList<Element> listProductos = productosCategorias.get(categoria);
        if (listProductos == null) {
            listProductos = new ArrayList<>();
            listProductos.add(producto);
            productosCategorias.put(categoria, listProductos);
        } else {
            listProductos.add(producto);
        }
    }

    /**
     * Guarda en el mapa el Elemento según su categoria propia
     *
     * @param productosCategorias Mapa donde se organizan los productos por Categorias
     * @param producto            Elemento a guardar
     */
    private static void organizarMapaCategorias(HashMap<String, ArrayList<Element>> productosCategorias, Element producto) {
        String categoria = producto.getElementsByTagName("categoria").item(0).getTextContent();
        organizarMapaCategorias(productosCategorias, producto, categoria);
    }

    /**
     * Se comprueba que el producto pertenezca a una categoria;
     * que el nombre esté dentro del rango de letras permitido
     * y que la descripción esté dentro del rango de palabras permitido.
     *
     * @param producto Producto a examinar caracteristicas
     * @return {@code true} si es un Producto con información valida
     */
    private static boolean validProducto(Element producto) {
        final int MIN_LETRAS = 5, MAX_LETRAS = 45, MIN_DESCRIP = 10, MAX_DESCRIP = 50;

        int numLetrasNombre = producto.getElementsByTagName("nombre").item(0).getTextContent().length();
        if (numLetrasNombre < MIN_LETRAS || numLetrasNombre > MAX_LETRAS) return false;

        String descripcion = producto.getElementsByTagName("descripcion").item(0).getTextContent();
        long palabras = AyudasNIO.contarPalabrasString(List.of(descripcion), "\\b(\\p{L}+)\\b", Pattern.CASE_INSENSITIVE);
        if (palabras < MIN_DESCRIP || palabras > MAX_DESCRIP) return false;

        if (producto.getElementsByTagName("categoria").getLength() == 0) return false;
        String categoria = producto.getElementsByTagName("categoria").item(0).getTextContent();
        return !categoria.isBlank() && !categoria.equals("Sin Categoria");
    }

    /**
     * Se hace uso del método {@link AyudasXml#guardarDocumento(Document, String) guardarDocumento}
     * de la clase {@link AyudasXml}.
     *
     * @param doc           Documento a guardar.
     * @param nombreFichero Fichero donde se guarda.
     */
    private static void guardarDocumento(Document doc, String nombreFichero) {
        String base = "./src/ej2/";
        try {
            AyudasXml.guardarDocumento(doc, base + nombreFichero);
            System.out.println("Documento guardado en el archivo: " + nombreFichero);
        } catch (XmlException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que clona un elemento de un documento a otro.
     *
     * @param doc     El Documento que será el padre
     * @param element Elemento a clonar
     * @return El Elemento con un nuevo padre
     */
    private static Element cloneElement(Document doc, Element element) {
        Element nuevoElemento = doc.createElement(element.getTagName());
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            nuevoElemento.setAttribute(element.getAttributes().item(i).getNodeName(), element.getAttributes().item(i).getNodeValue());
        }
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Element.ELEMENT_NODE) {
                nuevoElemento.appendChild(cloneElement(doc, (Element) element.getChildNodes().item(i)));
            } else {
                if (!element.getChildNodes().item(i).getTextContent().isBlank())
                    nuevoElemento.appendChild(doc.createTextNode(element.getChildNodes().item(i).getTextContent()));
            }
        }
        return nuevoElemento;
    }
}
