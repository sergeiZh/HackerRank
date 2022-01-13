package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.Arrays;

/**
 * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
 * Given the signal received by Earth as a string, , determine how many letters of the SOS message
 * have been changed by radiation.
 *
 * Example:
 * s = SOSTOT
 *
 * The original message was SOSSOS. Two of the message's characters were changed in transit.
 * Output must be 2 since 2 letters has been changed
 */
public class MarsExploration {

    public static int marsExploration(String s) {
        int amountOfChangedLetters = 0;
        for(int i=0; i<s.length()-2; i=i+3) {
            String sosSubstractedPart = s.substring(i, i + 3);
            if(sosSubstractedPart.equals("SOS")) {
                continue;
            }

            if(!sosSubstractedPart.substring(0,1).equals("S")) {
                amountOfChangedLetters++;
            }
            if(!sosSubstractedPart.substring(1,2).equals("O")) {
                amountOfChangedLetters++;
            }
            if(!sosSubstractedPart.substring(2,3).equals("S")) {
                amountOfChangedLetters++;
            }
        }
        return amountOfChangedLetters;
    }
}
