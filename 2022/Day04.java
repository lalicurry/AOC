import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;


class Day04 {
    public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day04.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> dataLines;
        try {
            dataLines = Files.readAllLines(filePath, charset);
        } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
            return;
        }
        long start = System.nanoTime();

        //PART ONE
        int retMe1 = 0;

        for (String currS:
             dataLines) {
            String[] workAreas = currS.split(",", 0);
            String[] elf1Work = workAreas[0].split("-",0);
            String[] elf2Work = workAreas[1].split("-",0);

            if(Integer.parseInt(elf1Work[0])>=Integer.parseInt(elf2Work[0])
                    && Integer.parseInt(elf1Work[1])<=Integer.parseInt(elf2Work[1])) retMe1++;
            else if(Integer.parseInt(elf2Work[0])>=Integer.parseInt(elf1Work[0])
                    && Integer.parseInt(elf2Work[1])<=Integer.parseInt(elf1Work[1])) retMe1++;
        }

        System.out.println("Part 1: " + retMe1);

        // PART TWO

        int retMe2 = 0;
        for (String currS:
                dataLines) {
            String[] workAreas = currS.split(",", 0);
            String[] elf1Work = workAreas[0].split("-",0);
            String[] elf2Work = workAreas[1].split("-",0);

            //Test if first value is within range of other elf
            if(Integer.parseInt(elf1Work[0])>=Integer.parseInt(elf2Work[0])
                    && Integer.parseInt(elf1Work[0])<=Integer.parseInt(elf2Work[1])) {
                retMe2++; //Elf1 first digit is greater than elf 2 digit 1 and less than dig 2
            } else if(Integer.parseInt(elf2Work[0])>=Integer.parseInt(elf1Work[0])
                    && Integer.parseInt(elf2Work[0])<=Integer.parseInt(elf1Work[1])) {
                retMe2++; //Elf2 first digit is greater than elf 1 digit 1 and less than dig 2
            } else if(Integer.parseInt(elf1Work[1])<=Integer.parseInt(elf2Work[1])
                    && Integer.parseInt(elf1Work[1])>=Integer.parseInt(elf2Work[0])) {
                retMe2++; // Elf1 second digit is less than elf 2 digit 2 and greater than dig 1
            }else if(Integer.parseInt(elf2Work[1])<=Integer.parseInt(elf1Work[1])
                    && Integer.parseInt(elf2Work[1])>=Integer.parseInt(elf1Work[0])) {
                retMe2++; // Elf1 second digit is less than elf 2 digit 2 and greater than dig 1
            }

        }
        System.out.println("Part 2: " + retMe2);



        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}