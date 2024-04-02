public class Pixel {
    private boolean funcional;
    private int red = 0, green = 0, blue = 0;

    public Pixel() {

        setFuncional();
    }

    private void setFuncional() {

        if (Math.random() * 100 > 3) funcional = true;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public boolean isFuncional() {
        return funcional;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
