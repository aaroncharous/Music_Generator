//Aaron Charous
//November, 24, 2014
//Music Generator

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Time
{
    private static double [] timeoptions1 = {.0625, .125, .25, .5, 1}; //need multiple arrays because you can only use some notes at some times since they have to add to 1
    private static double [] timeoptions2 = {.0625, .125, .25, .5};
    private static double [] timeoptions3 = {.0625, .125, .25,};
    private static double [] timeoptions4 = {.0625, .125};
    private static double [] timeoptions5 = {.0625};
    private static Random generator = new Random();
    public static ArrayList<Double> duration_double = new ArrayList<Double>();
    public static ArrayList<String> duration_text = new ArrayList<String>();
    
    private static void Selection () //generates times for one measure
    {
        double count = 0;
        double time = 0;
        while (count<1)
        {
            if (count==0)
            {
                int random = generator.nextInt(timeoptions1.length);
                time = timeoptions1[random];
            }
        
            if (count<=.5 && count>0)
            {
                int random = generator.nextInt(timeoptions2.length);
                time = timeoptions2[random]; 
            }
        
            if (count<=.75 && count>.5)
            {
                int random = generator.nextInt(timeoptions3.length);
                time = timeoptions3[random]; 
            }
        
            if (count<=.875 && count>.75)
            {
                int random = generator.nextInt(timeoptions4.length);
                time = timeoptions4[random]; 
            }
            
            if (count>.875)
            {
                int random = generator.nextInt(timeoptions5.length);
                time = timeoptions5[random];
            }
            count = count + time;
            duration_double.add(time);
        }
    }
    
    public static void AddtoArray (int measures)  //implements selection for each measure
    {   
        for (int x = 0; x<measures; x++)
        {
            Time.Selection();
        }
    }
    
    public static void Convert () //converts the double arraylist into a string arraylist
    {
        String converter = new String ();
        
        for (int x = 0; x<duration_double.size(); x++)
        {
           
           Double getum = new Double (duration_double.get(x));
           if (getum.equals(0.000))
           {
               converter = "";
            }
           if (getum.equals(.0625))
           {
               converter ="Sixteenth Note";
            }
           if (getum.equals(.125))
           {
               converter = "Eigth Note";
            }
           if (getum.equals(.25))
           {
               converter = "Quarter Note";
            }
           if (getum.equals(.5))
           {
               converter = "Half Note";
            }
           if (getum.equals(1.0))
           {
               converter = "Whole Note";
            }
           duration_text.add(converter);
        }
    }
    
    public static int Length () //returns length of arraylist
    {
        int length;
        length = duration_text.size();
        return length;
    }
    
    public static String Value (int x) //returns a value of the arraylist
    {
        String arrayvalue;
        arrayvalue = duration_text.get(x);
        return arrayvalue;
    }
    
    public static ArrayList Get () //returns arraylist
    {
        return duration_text;
    }
    
     public static void Clear () //clears both arraylists
    {
           duration_double.clear();
           duration_text.clear();
    }
    
    public static double NumValue (int x) //returns the numeric value of the arraylist
    {
     double arrayvalue;
     arrayvalue = duration_double.get(x);
     return arrayvalue;
    }
}