import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


class Day05 {
    public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
        Path filePath = Paths.get("src/Day05.txt");
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
        String[] piles = {"ZPMHR", "PCJB", "SNHGLCD", "FTMDQSRL", "FSPQBTZM", "TFSZBG", "NRV", "PGLTDVCM", "WQNJFML" }; //the stacks of crates

        /*
            [L] [M]         [M]
        [D] [R] [Z]         [C] [L]
        [C] [S] [T] [G]     [V] [M]
[R]     [L] [Q] [B] [B]     [D] [F]
[H] [B] [G] [D] [Q] [Z]     [T] [J]
[M] [J] [H] [M] [P] [S] [V] [L] [N]
[P] [C] [N] [T] [S] [F] [R] [G] [Q]
[Z] [P] [S] [F] [F] [T] [N] [P] [W]
 1   2   3   4   5   6   7   8   9
         */


        for(int i = 10; i<dataLines.size(); i++)
        {
            String currLine = dataLines.get(i);
            int move = Integer.parseInt(currLine.substring(5, currLine.indexOf("from")-1));
            int from = Integer.parseInt(currLine.substring(currLine.indexOf("from")+5, currLine.indexOf("to")-1))-1;
            int destination = Integer.parseInt(currLine.substring(currLine.indexOf("to")+3))-1;
            //System.out.println("move " + move + " from " + from + " destination " + destination);

            /*
            // part ONE
            for(int j = 0; j<move; j++)
            {
                if(piles[from].length()==0) break;
                piles[destination] += piles[from].substring(piles[from].length()-1);
                piles[from] = piles[from].substring(0, piles[from].length()-1);
            }
*/

            //Part TWO
                if(piles[from].length()<move)
                {
                    piles[destination] += piles[from];
                    piles[from]="";
                }else {
                    piles[destination] += piles[from].substring(piles[from].length() - (move));
                    piles[from] = piles[from].substring(0, piles[from].length() - (move));
                }
        }

        System.out.println(Arrays.toString(piles));
        String answer = "";
        for (String pile : piles) {
            if (pile.length()>0) {
                answer += pile.substring(pile.length() - 1);
            }
        }
        //System.out.println("Part One: " + answer);

        System.out.println("Part Two: " + answer);

        //Part 2 incorrect: MTZHCFNP / ZCFBBLTR / HRRDMMDS / BMDFNDCH

        // Keep this line at the end of your code
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.format("Elapsed time: %dns%n", elapsedTime);
    }
}