import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;


class Day02 {
    public static void main(String[] args) throws IOException{
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day02.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> dataLines;
            dataLines = Files.readAllLines(filePath, charset);

        long start = System.nanoTime();

        int totalScore = 0;

        // PART ONE
        for (String str: dataLines) {
            //calculate score for what you're throwing
            if(str.contains("X"))
            {
                totalScore+=1;
            }else if (str.contains("Y"))
            {
                totalScore+=2;
            }else if (str.contains("Z"))
            {
                totalScore+=3;
            }

            // A is Rock B is Paper, C is Scissors
            // X is Rock, Y is Paper, Z is Scissors
            //calculate win
            if((str.contains("A")&&str.contains("Y"))||(str.contains("B")&&str.contains("Z")) || (str.contains("C")&&str.contains("X")))
            {
                totalScore+=6;
            }
            //calculate tie
            if((str.contains("A")&&str.contains("X"))||(str.contains("B")&&str.contains("Y")) || (str.contains("C")&&str.contains("Z")))
            {
                totalScore+=3;
            }
        }
        System.out.println("PART ONE: \tTotal Score: " + totalScore);

        // PART 2
        /* Instructions to calculate score
        A is Rock B is Paper, C is Scissors
        X is Lose , Y is TIE, Z is WIN

        (1 for Rock, 2 for Paper, and 3 for Scissors)
        plus the score for the outcome of the round
        (0 if you lost, 3 if the round was a draw, and 6 if you won).
         */
        totalScore =0;

        for (String str: dataLines) {
            //calculate score for what you're throwing
            if(str.contains("Y"))
            {
                totalScore+=3;
                if(str.contains("A"))
                {
                    totalScore+=1;
                }else if(str.contains("B"))
                {
                    totalScore+=2;
                }else if(str.contains("C"))
                {
                    totalScore+=3;
                }
            }else if (str.contains("Z")) {
                totalScore += 6;
                if(str.contains("A"))
                {
                    totalScore+=2;
                }else if(str.contains("B"))
                {
                    totalScore+=3;
                }else if(str.contains("C"))
                {
                    totalScore+=1;
                }
            }else if(str.contains("X"))
            {
                if(str.contains("A"))
                {
                    totalScore+=3;
                }else if(str.contains("B"))
                {
                    totalScore+=1;
                }else if(str.contains("C"))
                {
                    totalScore+=2;
                }
            }
        }
        System.out.println("PART TWO: \tTotal Score: " + totalScore);






        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}