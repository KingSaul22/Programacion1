import static java.lang.Integer.parseInt;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean hola = false;
        Random random = new Random();
        System.out.println(String.format("#%06X", random.nextInt(0xFFFFFF + 1)).substring(5,7));
        System.out.println(parseInt("FF",16));
        /*System.out.println(parseInt("#FF", 255));
        Color color = Color.decode(String.format("#%06X", random.nextInt(0xFFFFFF + 1)));
        System.out.println(color);*/
        System.out.println(hola);
        System.out.println("#" + Integer.toHexString(255) + Integer.toHexString(255) + Integer.toHexString(255));
    }
}