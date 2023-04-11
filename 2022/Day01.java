import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Day01 {
    public static void main(String[] args) throws FileNotFoundException
    {
        File importFile = new File("src/Day01.txt");
        Scanner myScanner = new Scanner(importFile);
        ArrayList<Integer> elvesCount = new ArrayList<Integer>();
        Integer currentSum= 0;

        while(myScanner.hasNext())
        {
            String currLine = myScanner.nextLine();
            if(!currLine.equals(""))
            {
                currentSum += Integer.parseInt(currLine);
            }else
            {
             elvesCount.add(currentSum);
             currentSum=0;
            }
        }

        Collections.sort(elvesCount);


        int numberElves = elvesCount.size();
        System.out.println("Part 1: Max Val: " + elvesCount.get(numberElves-1));
        System.out.println("Part 2: Top 3 Values : " + elvesCount.get(numberElves-1) + " " + elvesCount.get(numberElves-2) + " " + elvesCount.get(numberElves-3));
        System.out.println("Sum of three values: " + (elvesCount.get(numberElves-1) + elvesCount.get(numberElves-2) +  elvesCount.get(numberElves-3)));


    }
}
