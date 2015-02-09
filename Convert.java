import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Convert
{
    public static String n2l (double x) //number to letter
    {
        return "Write this method!";
        //might not need this   
    }
    
    public static double l2n (String x) //letter to String
    {
        double f=0; //frequency
        if (x.equals("c"))
        {
            f = 261.626;
        }
        if (x.equals("c+"))
        {
            f = 277.183;
        }
        if (x.equals("d-"))
        {
            f = 277.183; 
        }
        if (x.equals("d"))
        {
            f = 293.665;
        }
        if (x.equals("d+"))
        {
            f = 311.127;
        }
        if (x.equals("e-"))
        {
            f = 311.127;
        }
        if (x.equals("e"))
        {
            f = 329.628;
        }
        if (x.equals("f"))
        {
            f = 349.228;
        }
        if (x.equals("f+"))
        {
            f = 369.994;
        }
        if (x.equals("g-"))
        {
            f = 369.994;
        }
        if (x.equals("g"))
        {
            f = 391.995;
        }
        if (x.equals("g+"))
        {
            f = 415.305;
        }
        if (x.equals("a-"))
        {
            f = 415.305;
        }
        if (x.equals("a"))
        {
            f = 440.000;
        }
        if (x.equals("a+"))
        {
            f = 466.164;
        }
        if (x.equals("b-"))
        {
            f = 466.164;
        }
        if (x.equals("b"))
        {
            f = 493.883;
        }
        if (x.equals("C"))
        {
            f = 523.251;
        }
        if (x.equals("C+"))
        {
            f = 554.365;
        }
        if (x.equals("D-"))
        {
            f = 554.365;
        }
        if (x.equals("D"))
        {
            f = 587.330;
        }
        if (x.equals("D+"))
        {
            f = 622.254;
        }
        if (x.equals("E-"))
        {
            f = 622.254;
        }
        if (x.equals("E"))
        {
            f = 659.255;
        }
        if (x.equals("F"))
        {
            f = 698.456;
        }
        if (x.equals("F+"))
        {
            f = 739.989;
        }
        if (x.equals("G-"))
        {
            f = 739.989;
        }
        if (x.equals("G"))
        {
            f = 783.991;
        }
        if (x.equals("G+"))
        {
            f = 830.609;
        }
        if (x.equals("A-"))
        {
            f = 830.609;
        }
        if (x.equals("A"))
        {
            f = 880.000;
        }
        if (x.equals("A+"))
        {
            f = 932.328;
        }
        if (x.equals("B-"))
        {
            f = 932.328;
        }
        if (x.equals("B"))
        {
            f = 987.767;
        }
  
        return f;
    }
}