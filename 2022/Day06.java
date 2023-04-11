import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


class Day06 {
    public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day06.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> dataLines;
        try {
            dataLines = Files.readAllLines(filePath, charset);
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
            return;
        }
        long start = System.nanoTime();
        int answer = -1;
        String currString = dataLines.get(0);
        //Part One

        for(int i=4; i<currString.length(); i++) {
            String fourChar = currString.substring(i - 4, i);
            //System.out.println(fourChar);
            String charOneR = fourChar.replaceFirst(Character.toString(fourChar.charAt(0)), "-");
            String charTwoR = fourChar.replaceFirst(Character.toString(fourChar.charAt(1)), "-");
            String charThreeR = fourChar.replaceFirst(Character.toString(fourChar.charAt(2)), "-");
            String charFourR = fourChar.replaceFirst(Character.toString(fourChar.charAt(3)), "-");

            if((charOneR.indexOf(fourChar.charAt(0)) == -1) && (charTwoR.indexOf(fourChar.charAt(1)) == -1)
                    && (charThreeR.indexOf(fourChar.charAt(2)) == -1) && (charFourR.indexOf(fourChar.charAt(3)) == -1)){
                answer = i;
                break;
            }
        }

            System.out.println("Part One: " + answer);

        //Part Two

        int answer2 = -1;

        for(int i = 14; i<currString.length(); i++)
        {
            String fourChar = currString.substring(i - 14, i);
            //System.out.println(fourChar);
            String[] characters = new String[14];
            for(int j =0; j<characters.length(); j++) {
                characters[j] = fourChar.replaceFirst(Character.toString(fourChar.charAt(j)), "=");
            }
            boolean exists = false;
            for(String x: characters)
            {
                if characters




            if(){
                answer = i;
                break;
            }
            }

        }


        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}