package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
 *
 * Lily decides to share a contiguous segment of the bar selected such that:
 *
 *     The length of the segment matches Ron's birth month, and,
 *     The sum of the integers on the squares is equal to his birth day.
 *
 * Determine how many ways she can divide the chocolate.
 *
 * Examples:
 * [2,2,1,3,2], 4, 2.
 * First criteria - birthday month - 2, so moving by 2. Each 2 neighboring elements should sum as - 4
 * 2 pairs match that criteria - 2,2 and 1,3
 * Output - 2
 *
 * [4], 4, 1.
 * First criteria - birthday month - 1, so moving by 1. Each 1 neighboring element should sum as - 4
 * 1 pair match that criteria - 4
 * Output - 1
 *
 * [1,2,1,3,2], 3, 2.
 * First criteria - birthday month - 2, so moving by 2. Each 2 neighboring elements should sum as - 3
 * 2 pairs match that criteria - 1,2 and 2,1
 * Output - 2
 */
public class SubarrayDivision2 {

    public static int birthday(List<Integer> birthdayChocolate, int birthDay, int birthMonth) {
        int matchingValuesCount = 0;
        for(int i=0; i<birthdayChocolate.size(); i++) {
            // to not go outside the array
            if(i+birthMonth > birthdayChocolate.size()) {
                break;
            }

            int sum = IntStream.range(i, i + birthMonth).map(birthdayChocolate::get).sum();
            if(sum == birthDay){
                matchingValuesCount++;
            }
        }
        return matchingValuesCount;
    }
}
