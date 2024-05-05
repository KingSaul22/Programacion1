import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Path in = Path.of("D:\\Descargas\\Copia Drive");
        Path out = Path.of("D:\\Descargas\\Copia Drive\\out");
        Pattern pt = Pattern.compile("[cC][oO][pP][iI][aA][rR].*.txt");

        try (Stream<Path> paths = Files.list(in)) {
            paths.filter(Files::isRegularFile)
                    .filter(file -> pt.matcher(file.getFileName().toString()).matches())
                    .filter(file -> {
                        try {
                            return Files.size(file) > 1024;
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .forEach(file -> {
                        try {
                            Files.copy(file, out.resolve(file.getFileName().toString()));
                        } catch (IOException e) {
                            System.out.println("Fail");
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}