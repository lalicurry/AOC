import java.io.*;
import java.util.*;

/**
 * Class for parsing input from text file
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImportInput
{
    private ArrayList<String> inputStrings;
    
    /** Constructor to put the puzzle input into 
     * inputStrings to hold the strings to start to process them.
     */
    public ImportInput(String textFile) throws FileNotFoundException
    {
        inputStrings = new ArrayList<String>(100);
        fillImport(textFile);
        System.out.println("Import Complete! Elements: " 
        + inputStrings.size());
    }
    
    /**
     * Helper method that fills the ArrayList
     */
    public void fillImport(String textFile) throws FileNotFoundException
    {
        File myFile = new File(textFile);
        Scanner myScanner = new Scanner(myFile);
        while (myScanner.hasNextLine())
        {
            inputStrings.add(myScanner.nextLine());
        }
    }
    
    public ArrayList<String> getInputStrings()
    {
        return inputStrings;
    }


}
