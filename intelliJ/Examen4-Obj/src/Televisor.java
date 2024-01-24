import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Televisor {
    private int width, height;
    private String conexion, protocolo;
    private Pixel[][] pxTelevisor;
    private boolean panelDefectuoso;

    public Televisor(int ancho, int alto, String conexion, String protocolo) {
        this.conexion = conexion;
        this.protocolo = protocolo;
        this.width = ancho;
        this.height = alto;

        generarPanel();
    }

    private void generarPanel() {
        pxTelevisor = new Pixel[height][width];
        int numDefectuoso = 0;

        for (int fila = 0; fila < height; fila++) {
            for (int colum = 0; colum < width; colum++) {

                pxTelevisor[fila][colum] = new Pixel();
                //Creamos el pixel y ccontamos si es funcional.
                if (!pxTelevisor[fila][colum].isFuncional()) numDefectuoso++;
            }
        }

        //En el caso de que haya más de un 3% defectusos, el panel esta dañado.
        if (numDefectuoso > (int) (3 * width * height / 100)) panelDefectuoso = true;
    }

    /*public String getConexion() {
        return conexion;
    }

    public String getProtocolo() {
        return protocolo;
    }*/ //getter conexion y protocolo

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isDefectuoso() {
        return panelDefectuoso;
    }

    public void setImagen(String[][] imagen) {

        for (int fila = 0; fila < height; fila++) {
            for (int colum = 0; colum < width; colum++) {

                if (pxTelevisor[fila][colum].isFuncional()) {
                    //Si un px es funcional, le daremos los valores transformados a RGB.
                    pxTelevisor[fila][colum].setRed(parseInt(imagen[fila][colum].substring(1, 3), 16));
                    pxTelevisor[fila][colum].setGreen(parseInt(imagen[fila][colum].substring(3, 5), 16));
                    pxTelevisor[fila][colum].setBlue(parseInt(imagen[fila][colum].substring(5, 7), 16));
                }
            }
        }

    } //Método que da color a los píxeles.

    public String getColorPromedio() {
        String mediaColor = "#";
        int r = 0, g = 0, b = 0;

        //Repasamos la matriz de pixeles de la que recogeremos los colores.
        for (int fila = 0; fila < height; fila++) {
            for (int colum = 0; colum < width; colum++) {

                if (pxTelevisor[fila][colum].isFuncional()) {
                    //Siempre que sea funcional...

                    //Añadimos el valor del pixel.
                    r += pxTelevisor[fila][colum].getRed();
                    g += pxTelevisor[fila][colum].getGreen();
                    b += pxTelevisor[fila][colum].getBlue();
                }
            }
        }

        //Obtenemos su media.
        r /= (width * height);
        g /= (width * height);
        b /= (width * height);

        //Lo transformamos a String
        return mediaColor = mediaColor + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
    } //Método que calcula el color promedio.

    public String conectar(Dispositivo dispositivo) throws DispositivoNoCompatibleException{
        boolean compatibleProt = false;
        boolean compatibleConex = false;

        String[] protDisp = dispositivo.getProtocolo().split(" ");
        String[] protTV = protocolo.split(" ");

        for (int i = 0; i < protDisp.length; i++) {

            if (Arrays.asList(protTV).contains(protDisp[i].trim())) {
                compatibleProt = true;
                break;
            }
        }

        String[] conexDisp = dispositivo.getConexion().split(" ");
        String[] conexTV = conexion.split(" ");

        for (int i = 0; i < conexDisp.length; i++) {

            if (Arrays.asList(conexTV).contains(conexDisp[i].trim())) {
                compatibleConex = true;
                break;
            }
        }


        if (!compatibleConex && !compatibleProt) {
            throw new DispositivoNoCompatibleException("00");

        } else if (!compatibleConex) {
            throw new DispositivoNoCompatibleException("01");

        } else if (!compatibleProt){
            throw new DispositivoNoCompatibleException("10");

        }

        return "El dispositivo está conectado.";
    }
}
