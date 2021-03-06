//Aaron Charous
//December 25, 2014

import java.util.Scanner;
import java.util.ArrayList;

public class WholeFrequency extends FrequencyParent
{
    
    public static double wholefreq ()
    {
       freq = 0;
       if (Frequency.measurenum == 1 || MainRunner.measures - Frequency.measurenum == 0) //first or last measures
       {
           int random = generator.nextInt(pcratio.length);
           ratio = pcratio[random];
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           freq = (Convert.l2n(note))*ratio;
        }
       if (MainRunner.measures - Frequency.measurenum == 1) //second to last measure
       {
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           ratio = 1.681792831;
           note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
           freq = (Convert.l2n(note))*ratio;
        }
       if (Frequency.measurenum != 1 && MainRunner.measures - Frequency.measurenum != 0 && MainRunner.measures - Frequency.measurenum != 1 && MainRunner.measures - Frequency.measurenum != 2) //can't use else or else it only pertains to the second if statement
       {
           previous_cp = Frequency.Value(Frequency.Length()-1);
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) == (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //oblique motion
           {
               int random = generator.nextInt(cratio.length);
               ratio = cratio[random];
               note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
               freq = (Convert.l2n(note))*ratio;
               if (Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //no skips by a major sixth
               {
                   freq = wholefreq();
                }
            }
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) > (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going up
           {
               int random = generator.nextInt(2); //decide if cp is going up or down
               if (random == 0 && previous_cp >= Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1))) //cp going down, contrary motion; makes sure that the previous cp wasn't greater than current cf so that it can go down or stay same
               {
                   int random_1 = generator.nextInt(cratio.length);
                   ratio = cratio[random_1];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0; no skipping by major sixth
                   {
                       freq = wholefreq();
                   }
               }
               
               else //cp going up, direct motion -- must go into imperfect consonance
               {
                   int random_2 = generator.nextInt(iratio.length);
                   ratio = iratio[random_2];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio; 
                   if (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                       {
                           freq = wholefreq();
                        }
               }
           }
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) < (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going down
               {
               int random = generator.nextInt(2); //decide if cp is going up or down
               if (random == 0 && previous_cp <= 2*Convert.l2n((MainRunner.cantusfirmus.get(Frequency.measurenum -1)))) //cp going up; makes sure that the previous cp is less than or equal to twice the current cf so cp can go up or stay the same
               {
                   int random_1 = generator.nextInt(cratio.length);
                   ratio = cratio[random_1];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05)
                   {
                       freq = wholefreq();
                   }
                }   
               else //cp going down, direct motion
               {
                   int random_2 = generator.nextInt(iratio.length);
                   ratio = iratio[random_2];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio; 
                   if (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                    {
                     freq = wholefreq();
                    }
               }
            }
        }
       if (MainRunner.measures - Frequency.measurenum == 2) //third to last measure needs to make sure there are no skips by major sixths to the future note since the second to last note is fixed
       {
           String future_note;
           future_note = MainRunner.cantusfirmus.get(Frequency.measurenum);
           double future_ratio;
           future_ratio = 1.681792831;
           double future_freq;
           future_freq = (Convert.l2n(future_note))*ratio;
           previous_cp = Frequency.Value(Frequency.Length()-1);
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) == (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //oblique motion
            {
               int random = generator.nextInt(cratio.length);
               ratio = cratio[random];
               note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
               freq = (Convert.l2n(note))*ratio;
               if (Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //no skips by a major sixth
               {
                   freq = wholefreq();
                }
            }
           if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) > (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going up
            {
               int random = generator.nextInt(2); //decide if cp is going up or down
               if (random == 0 && previous_cp >= Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1))) //cp going down, contrary motion; makes sure that the previous cp wasn't greater than current cf so that it go down or stay same
               {
                   int random_1 = generator.nextInt(cratio.length);
                   ratio = cratio[random_1];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq > previous_cp || freq == 0 ||Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0; no skipping by major sixth
                   {
                       freq = wholefreq();
                    }
                }   
               else //cp going up, direct motion -- must go into imprefect consonance
               {
                   int random_2 = generator.nextInt(iratio.length);
                   ratio = iratio[random_2];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq < previous_cp|| Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                       {
                           freq = wholefreq();
                        }
               }
            }
            if (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 1)) < (Convert.l2n(MainRunner.cantusfirmus.get(Frequency.measurenum - 2)))) //cf is going down
                {
               int random = generator.nextInt(2); //decide if cp is going up or down
               if (random == 0 && previous_cp <= 2*Convert.l2n((MainRunner.cantusfirmus.get(Frequency.measurenum -1)))) //cp going up; makes sure that the previous cp is less than or equal to twice the current cf so cp can go up or stay the same
               {
                   int random_1 = generator.nextInt(cratio.length);
                   ratio = cratio[random_1];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq < previous_cp || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05)
                   {
                       freq = wholefreq();   
                   }
                }   
               else //cp going down, direct motion
               {
                   int random_2 = generator.nextInt(iratio.length);
                   ratio = iratio[random_2];
                   note = MainRunner.cantusfirmus.get(Frequency.measurenum-1);
                   freq = (Convert.l2n(note))*ratio;
                   if (freq > previous_cp || freq == 0 || Math.abs((freq/previous_cp)-1.681792831)<.05 || Math.abs((previous_cp/freq)-1.681792831)<.05 || Math.abs((freq/future_freq)-1.681792831)<.05 || Math.abs((future_freq/freq)-1.681792831)<.05) //need not equal to 0 becuase freq is initialized at 0
                   {
                       freq = wholefreq();
                   }
               }
            }
        }
       return freq;
    }
}