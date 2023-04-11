import java.util.*;
import java.io.*;


/**
 * Write a description of class Day7 here.
 *
 * @author Lali
 * @version 11.24.2022
 */
public class Day7
{
    //Holds the puzzle Input
    private HashMap<String, Integer> wires;
    private ArrayList<String> day7;
    
    public Day7() throws FileNotFoundException
    {
        wires = new HashMap<String, Integer>();
        ImportInput a = new ImportInput("Day7TESTER.txt");
        day7 = a.getInputStrings();
    }
    
    public void runProcess()
    {
        for(String a: day7)
        {
            if(a.contains("AND"))
            {
                addBit(a);
                //System.out.println("AND!");
            } else if(a.contains("NOT"))
            {
                notBit(a);
                //System.out.println("NOT!");
            }else if(a.contains("SHIFT"))
            {
                shiftBit(a);
                //System.out.println("SHIFT!");
            }else if(a.contains("OR"))
            {
                orBit(a);
            }else
            {
                valueBit(a);
            }
        }
        System.out.println("Finished!");
        System.out.println("Value in wire d: " + wires.get("d"));
        System.out.println("Value in wire e: " + wires.get("e"));
        System.out.println("Value in wire f: " + wires.get("f"));
        System.out.println("Value in wire g: " + wires.get("g"));
        System.out.println("Value in wire h: " + wires.get("h"));
        System.out.println("Value in wire i: " + wires.get("i"));
        System.out.println("Value in wire x: " + wires.get("x"));
        System.out.println("Value in wire y: " + wires.get("y"));
    }
        
    public void addBit(String str)
    {
        String[] strArr = str.split(" ");
        String s1 = strArr[0];
        String s2 = strArr[2];
        String s3 = strArr[4];
        int s1Val = 0;
        int s2Val = 0;
        
        if(isNumeric(s1))
        {
            s1Val = Integer.parseInt(s1);
            //System.out.println("Add Number!");
        }else if(wires.containsKey(s1))
        {
            s1Val = wires.get(s1);
        }
        if(isNumeric(s1))
        {
            s1Val = Integer.parseInt(s1);
            //System.out.println("Add Number!");
        }else if(wires.containsKey(s2))
        {
            s2Val = wires.get(s2);
        }
        
        wires.put(s3, (s1Val & s2Val));        
    }
    public void notBit(String str)
    {
        String[] strArr = str.split(" ");
        String numberValue = strArr[1]; // number
        String s2 = strArr[3]; // put where
        int numberValueVal = 0;
        if(isNumeric(numberValue))
        {
            numberValueVal = Integer.parseInt(numberValue);
        }else if(wires.containsKey(numberValue))
        {
            numberValueVal = wires.get(numberValue);
        }


        wires.put(s2, ~numberValueVal);
    }
 
    public void shiftBit(String str)
    {
        String[] strArr = str.split(" ");
        String s1 = strArr[0]; // firstWire name
        int shiftNum = Integer.parseInt(strArr[2]); //number to shift by

        int s1Val = 0; // Value in first wire
        
        int value = 0;
        if(wires.containsKey(s1))
        {
            s1Val = wires.get(s1);
        }
        
        if(strArr[1].contains("RSHIFT"))
        {
            value = s1Val>>shiftNum;
        }else
        {
            value = s1Val<<shiftNum;
        }
        
        String s3 = strArr[4]; // Wire to put in
        wires.put(s3, value);
        //System.out.println("Shifting!");
    }
    public void orBit(String str)
    {
        String[] strArr = str.split(" ");
        String s1 = strArr[0];
        String s2 = strArr[2];
        String s3 = strArr[4];
        
        int s1Val = 0;
        int s2Val = 0;
        
        if(isNumeric(s1))
        {
            s1Val = Integer.parseInt(s1);
            //System.out.println("Or Number!");
        }else if(wires.containsKey(s1))
        {
            s1Val = wires.get(s1);
        }
        if(isNumeric(s1))
        {
            s1Val = Integer.parseInt(s1);
            //System.out.println("Or Number!");
        }else if(wires.containsKey(s2))
        {
            s2Val = wires.get(s2);
        }
        
        wires.put(s3, (s1Val | s2Val));
        
    }
    public void valueBit(String str)
    {
        String[] strArr = str.split(" ");
        String s1 = strArr[0]; //get number val
        String s2 = strArr[2]; // where to put value
        int s1Val = 0;
        if(isNumeric(s1))
        {
            s1Val = Integer.parseInt(s1);
            //System.out.println("Value Number!");
        }else if(wires.containsKey(s1))
        {
            s1Val = wires.get(s1);
        }
        
        
        wires.put(s2, s1Val);
        //System.out.println("Value IN!");
    }
    
    public boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
    }
}
