//Aaron Charous
//November 24, 2014
//Random Music Generator

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class MainRunner
{
    public static int measures;
    public static ArrayList<String> cantusfirmus = new ArrayList<String>();
    public static void main (String [] args)
    {
        DecimalFormat fmt = new DecimalFormat ("0.000");
        Scanner scan = new Scanner(System.in);
        String another = "y";
        String cf;
        String cf_char = " ";
        String cf_char_2 = " ";

        
        while (another.equalsIgnoreCase ("y")) //allows the program to be run multiple times
        {
            Frequency.Clear(); //clears frequency array in case run multiple times
            Time.Clear(); //clears time array
            double count = 0; //resets the count to separate measures
            cantusfirmus.clear();
            Frequency.measurenum = 1; //sets the measure number to 1;
            Frequency.mcount = 1;

            Frequency.measurenum_arraylist.clear();

            
            System.out.print ("Enter the notes of the cantus firmus (use lowercase for low octave, uppercase for high octave, + for sharp, - for flat): ");
            cf = scan.nextLine();
            
            for (int x=0; x<cf.length(); x++)
            {
                if (x<cf.length()-1 && (cf.charAt(x+1) =='+' || cf.charAt(x+1) == '-'))
                {
                    cf_char_2 = String.valueOf(cf.charAt(x)) + String.valueOf(cf.charAt(x+1));
                    cantusfirmus.add(cf_char_2);
                    x++;
                }
                else
                {
                    cf_char = String.valueOf(cf.charAt(x)); //makes a character into a string so it can be added to the arraylist
                    cantusfirmus.add(cf_char);
                }
            }
            
            measures = cantusfirmus.size();
            System.out.println (cantusfirmus);
            
            System.out.println ();
            System.out.println ("Frequency: \tDuration: \tMeasure Number:");
            
            TimeRunner.RunTime(); //make sure this runs first the frequency depends on the length of the time array
            FrequencyRunner.RunFreq();
           
            for (int x=0; x<Time.Length(); x++) //prints parallel arrays
                {
                 System.out.println (fmt.format(Frequency.Value(x)) + " \t" + Time.Value(x) + "\t" + Frequency.measurenum_arraylist.get(x)); //prints values


                 count = count + Time.NumValue(x); //counts the time values
                    
                    if (count%1 == 0) //If it's the end of the measure, a new line is printed to separate the measures
                    {
                        System.out.println ();
                    }
                    
                }
            
            System.out.print ("Would you like to generate more music? (y/n) ");
            another = scan.nextLine();
            System.out.println ();
        }
    }
}