package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A pangram is a string that contains every letter of the alphabet.
 * Given a sentence determine whether it is a pangram in the English alphabet.
 * Ignore case. Return either pangram or not pangram as appropriate.
 *
 * Example:
 * We promptly judged antique ivory buckles for the next prize is pangram so "pangram" should be returned
 * We promptly judged antique ivory buckles for the prize is not a pangram so "not pangram" should be returned
 */
public class Pangrams {

    public static String pangrams(String s) {
        int aLetterValue = "a".charAt(0);
        int zLetterValue = "z".charAt(0);
        s = s.replaceAll(" ", "");
        List<Character> letterValues = new ArrayList<>(Arrays.stream(s.split(""))
                                                           .map(letter -> letter.toLowerCase())
                                                           .map(letter -> letter.charAt(0))
                                                           .collect(Collectors.toSet()));
        Collections.sort(letterValues);
        if(aLetterValue != letterValues.get(0) || zLetterValue != letterValues.get(letterValues.size()-1)) {
            return "not pangram";
        }

        for(int i=0; i<letterValues.size()-1; i++) {
            if(letterValues.get(i+1) - letterValues.get(i) !=1) {
                return "not pangram";
            }
        }

        return "pangram";
    }
}
