public class Principal {
    public static void main(String[] args) {
        Televisor televisor = new Televisor(1920, 1080, "HDMI DISPLAYPORT", "TMDS LVDS HDCP");
        String[][] imagen = Imagen.generateRandomColors(televisor.getWidth(), televisor.getHeight());
        televisor.setImagen(imagen);
        System.out.println("El televisor está defectuoso: " + televisor.isDefectuoso());
        System.out.println("El color promedio de la imagen es: " + televisor.getColorPromedio());
        //System.out.println("El color más alto de la imagen es: " + televisor.getColorMasAlto());

        Dispositivo bluray = new Dispositivo("Blu-ray", "BLAB HDMI", "U3T HDCP");
        try {
            System.out.println(televisor.conectar(bluray));
        } catch (DispositivoNoCompatibleException e) {
            System.out.println(e.getMessage());
        }

        Dispositivo nintendo = new Dispositivo("Nintendo", "VGA", "LLG");
        try {
            System.out.println(televisor.conectar(nintendo));
        } catch (DispositivoNoCompatibleException e) {
            System.out.println(e.getMessage());
        }

        Dispositivo playstation = new Dispositivo("Playstation", "HDMI", "eARC");
        try {
            System.out.println(televisor.conectar(playstation));
        } catch (DispositivoNoCompatibleException e) {
            System.out.println(e.getMessage());
        }
    }
}
