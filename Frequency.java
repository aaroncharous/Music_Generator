//Aaron Charous
//November, 24, 2014
//Music Generator

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Frequency
{
    private static double[] frequency = {880.000, 830.609, 783.991, 698.456, 659.255, 622.254, 587.330, 554.365, 523.251, 493.883, 466.164, 440.000, 415.305, 391.995, 369.994, 349.228, 329.628, 311.127, 293.665, 277.183, 261.626, 246.942, 233.082, 220.000};
    public static ArrayList<Double> tone = new ArrayList<Double>();
    private static Random generator = new Random();
    public static double mcount; //necessary for measurenum
    public static int measurenum; //number of measure the program is currently on
    public static ArrayList<Integer> measurenum_arraylist = new ArrayList<Integer>();
    
    public static void Create () //adds a certain number of random frequencies to the arraylist based on the number of values in the time arraylist
    {
        double freq;
        for (int x=0; x<Time.Length(); x++)
        {
            
            if (Time.Value(x) != "")
            {
                if (Time.Value(x).equals("Whole Note"))
                {
                    tone.add(WholeFrequency2.wholefreq());
                }
                
                else 
                {
                    int random = generator.nextInt(frequency.length);
                    freq = frequency[random];
                    tone.add(freq);
                }
                
                
                measurenum_arraylist.add(measurenum);
                mcount = mcount + Time.NumValue(x);
                measurenum = (int) mcount;
            }
        }
    }
   
    public static int Length () //returns length of arraylist
    {
        int length;
        length = tone.size();
        return length;
    }
    
    public static Double Value (int x) //returns a value of the arraylist
    {
        double arrayvalue;
        arrayvalue = tone.get(x);
        
        return arrayvalue;
      
    }
    
     public static ArrayList Get () //returns arraylist
    {
        return tone;
    }
    
    public static void Clear () //clears arraylist
    {
       tone.clear();
    }
}
    