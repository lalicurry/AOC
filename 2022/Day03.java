import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;


class Day03 {
    public static void main(String[] args) throws IOException{
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day03.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> dataLines;
        dataLines = Files.readAllLines(filePath, charset);

        long start = System.nanoTime();


        int sumMe = 0;

        // PART One
        for (String str:
             dataLines) {
            String firstHalf = str.substring(0, str.length() / 2);
            String secondHalf = str.substring(str.length() / 2);
            char sameLetter = ' ';
            for (int i = 0; i < firstHalf.length(); i++) {
                if (secondHalf.contains(Character.toString(firstHalf.charAt(i)))) {
                    sameLetter = firstHalf.charAt(i);
                    break;
                }
            }
            if(((int) sameLetter -96)>0)
            {
                sumMe+=((int) sameLetter -96);
            }else {
                sumMe+=((int) sameLetter -38);
            }

        }
        System.out.println("Part One: " + sumMe);
        sumMe=0;

        // PART TWO
        for (int i=0; i<dataLines.size()-2; i+=3) {
            String elf1 = dataLines.get(i);
            String elf2 = dataLines.get(i+1);
            String elf3 = dataLines.get(i+2);

            char sameLetter = ' ';
            for (int j = 0; j < elf1.length(); j++) {
                char currChar = elf1.charAt(j);
                if (elf2.contains(Character.toString(currChar)) && elf3.contains(Character.toString(currChar)))
                {
                    sameLetter = currChar;
                    break;
                }
            }

            if(((int) sameLetter -96)>0)
            {
                sumMe+=((int) sameLetter -96);
            }else {
                sumMe+=((int) sameLetter -38);
            }


        }
        System.out.println("Part 2: " + sumMe);

        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}