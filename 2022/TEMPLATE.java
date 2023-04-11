import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


class TEMPLATE {
    public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day06Tester.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> dataLines;
        try {
            dataLines = Files.readAllLines(filePath, charset);
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
            return;
        }
        long start = System.nanoTime();


        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}