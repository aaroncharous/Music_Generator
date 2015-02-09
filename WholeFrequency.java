//Aaron Charous
//December 25, 2014

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class WholeFrequency
{
    private static Random generator = new Random();
    static double ratio = 0;
    static double freq;
    public static double[] pcratio = {1,1.498307077,2}; //perfect consonance ratios
    public static double[] cratio = {1,1.25992105,1.498307077,1.681792831,2}; // consonance ratios
    public static double[] iratio = {1.25992105,1.681792831}; // imperfect consonance ratios
    private static String note;
    private static double previous_cp;
    private static int count1;
    private static int count2;
    private static int count3;
    private static int count4;
    private static int count5;
    private static int count6;
    private static int count7;
    private static int count8;
    private static int count9;
    private static int count10;
    public static final int MAX_TRIES = 150; //if a note is impossible, the while statement will go an infinite number of times.  this is the max number of tries before the frequencies are rest.
    
    public static double wholefreq ()
    {
       freq = 0;
       if (Frequency.measurenum == 1 || MainRunner.measures - Frequency.measurenum == 0) //first or last measures
       {
           System.out.println("boop1");
           int random = generator.nextInt(pcratio.length);
           ratio = pcratio[random];
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           freq = (Convert.l2n(note))*ratio;
           System.out.println("boop2");
        }
       if (MainRunner.measures - Frequency.measurenum == 1) //second to last measure
       {
           System.out.println("boop3");
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           ratio = 1.681792831;
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           freq = (Convert.l2n(note))*ratio;
           System.out.println("boop4");
        }
       if (Frequency.measurenum != 1 && MainRunner.measures - Frequency.measurenum != 0 && MainRunner.measures - Frequency.measurenum != 1 && MainRunner.measures - Frequency.measurenum != 2) //can't use else or else it only pertains to the second if statement
       {
           System.out.println("boop5");
           previous_cp = Frequency.Value(Frequency.Length()-1);
           System.out.println("boop6");
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) == (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //oblique motion
           {
               while (Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //no skips by a major sixth
               {
                   System.out.println("boop7");
                   int random = generator.nextInt(cratio.length);
                   ratio = cratio[random];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   System.out.println("boop8");
                   count1++;
                }
            }
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) > (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going up
           {
               System.out.println("boop9");
               int random = generator.nextInt(2); //decide if cp is going up or down
               System.out.println("boop10");
               if (random == 0 && previous_cp >= Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1))) //cp going down, contrary motion; makes sure that the previous cp wasn't greater than current cf so that it go down or stay same
               {
                   while (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0; no skipping by major sixth
                   {
                       System.out.println("boop11");
                       int random_1 = generator.nextInt(cratio.length);
                       ratio = cratio[random_1];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop12");
                       count2++;
                   }
               }
            }   
           else //cp going up, direct motion -- must go into imprefect consonance
           {
                   while (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                       {
                           System.out.println("boop13");
                           int random_2 = generator.nextInt(iratio.length);
                           ratio = iratio[random_2];
                           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                           freq = (Convert.l2n(note))*ratio;
                           System.out.println("boop14");
                           count3++;
                        }
           }
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) < (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going down
               {
               System.out.println("boop15");
               int random = generator.nextInt(2); //decide if cp is going up or down
               System.out.println("boop16");
               if (random == 0 && previous_cp <= 2*Convert.l2n((MainRunner.cantusfirmus.get(Frequency.measurenum -1)))) //cp going up; makes sure that the previous cp is less than or equal to twice the current cf so cp can go up or stay the same
               {
                   while (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05)
                   {
                       System.out.println("boop17");
                       int random_1 = generator.nextInt(cratio.length);
                       ratio = cratio[random_1];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop18");
                       count4++;
                   }
                }   
               else //cp going down, direct motion
               {
                    while (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                    {
                       System.out.println("boop19");
                        int random_2 = generator.nextInt(iratio.length);
                       ratio = iratio[random_2];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop20");
                       count5++;
                    }
               }
            }
        }
       if (MainRunner.measures - Frequency.measurenum == 2) //third to last measure needs to make sure there are no skips by major sixths to the future note since the second to last note is fixed
       {
           System.out.println("boop21");
           String future_note;
           future_note = MainRunner.cantusfirmus.get(Frequency.measurenum);
           double future_ratio;
           future_ratio = 1.681792831;
           double future_freq;
           future_freq = (Convert.l2n(future_note))*ratio;
           previous_cp = Frequency.Value(Frequency.Length()-1);
           System.out.println("boop22");
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) == (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //oblique motion
            {
               while (Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //no skips by a major sixth
               {
                   System.out.println("boop23");
                   int random = generator.nextInt(cratio.length);
                   ratio = cratio[random];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   System.out.println("boop24");
                   count6++;
                }
            }
            if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) > (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going up
                {
               System.out.println("boop25");
               int random = generator.nextInt(2); //decide if cp is going up or down
               System.out.println("boop26");
               if (random == 0 && previous_cp >= Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1))) //cp going down, contrary motion; makes sure that the previous cp wasn't greater than current cf so that it go down or stay same
               {
                   while (freq > previous_cp || freq == 0 ||Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0; no skipping by major sixth
                   {
                       System.out.println("boop27");
                       int random_1 = generator.nextInt(cratio.length);
                       ratio = cratio[random_1];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop28");
                       count7++;
                    }
                }   
               else //cp going up, direct motion -- must go into imprefect consonance
               {
                   while (freq < previous_cp|| Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                       {
                           System.out.println("boop29");
                           int random_2 = generator.nextInt(iratio.length);
                           ratio = iratio[random_2];
                           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                           freq = (Convert.l2n(note))*ratio;
                           System.out.println("boop30");
                           count8++;
                        }
               }
            }
            if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) < (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going down
                {
               System.out.println("boop31");
               int random = generator.nextInt(2); //decide if cp is going up or down
               System.out.println("boop32");
               if (random == 0 && previous_cp <= 2*Convert.l2n((MainRunner.cantusfirmus.get(Frequency.measurenum -1)))) //cp going up; makes sure that the previous cp is less than or equal to twice the current cf so cp can go up or stay the same
               {
                   while (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05)
                   {
                       System.out.println("boop33");
                       int random_1 = generator.nextInt(cratio.length);
                       ratio = cratio[random_1];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop34");
                       count9++;
                   }
                }   
               else //cp going down, direct motion
               {
                   
                    while (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                    {
                       System.out.println("boop35");
                        int random_2 = generator.nextInt(iratio.length);
                       ratio = iratio[random_2];
                       note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                       freq = (Convert.l2n(note))*ratio;
                       System.out.println("boop36");
                       count10++;

                   }
               }
            }
        }
       System.out.println("boop37");
       return freq;
    }
}