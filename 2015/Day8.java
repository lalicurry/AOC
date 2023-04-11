import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day8 {

    public static void main(String[] args) throws FileNotFoundException
    {
        ImportInput a = new ImportInput("Day8Tester.txt");
        ArrayList<String> day8Input = a.getInputStrings();

        int codeChar = 0;
        int stringChar = 0;

        for(String currLine : day8Input)
        {
            codeChar+=currLine.length();
            if(currLine.length()>2){
                String countMe = currLine.substring(1, currLine.length() - 1);

                //remove \\ characters
                // remove \" characters
                // remove \x characters
                while(countMe.contains("\\\\"))
                {
                    countMe = countMe.replaceAll("\\\\", "");
                }
                System.out.println("After Double Escape Char: " + countMe);

                while(countMe.contains("\\\""))
                {
                    countMe = countMe.replaceAll("\\ \"", "");
                    System.out.println("Running");
                }

                System.out.println("After Single Quote: " + countMe);

                stringChar+=countMe.length();
            }

            System.out.println("codeChar =" + codeChar);
            System.out.println("stringChar = " + stringChar);
        }
    }
}
