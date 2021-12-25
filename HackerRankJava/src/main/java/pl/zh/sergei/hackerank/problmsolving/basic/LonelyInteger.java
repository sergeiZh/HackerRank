package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 *
 * Example
 * Given array a = [1,2,3,4,3,2,1]
 * The unique element is 4.
 */
public class LonelyInteger {

    /**
     * The idea is that:
     * 1. if arr is of length 1 than the only element is unique
     * 2. if 1-st and 2-nd elements are different then 1-st element is unique
     * 3. if last and pre-last elements are different then last element is unique
     * 4. unique element can be only on odd position since all previous elements has couples. So to find that
     * unique element need to check all elements starting from 3-rd, compare 3rd and 4th, after that 5th and 6th and
     * so on. After each check if it's failed i counter should be increased on 2 to start new check from odd element
     */
    public static int lonelyinteger(List<Integer> arr) {
        if(arr.size() == 1) {
            return arr.get(0);
        }

        int lonelyInteger = 0;
        Collections.sort(arr);
        if(arr.get(0) != arr.get(1)) {
            return arr.get(0);
        }

        if(arr.get(arr.size()-1) != arr.get(arr.size()-2)) {
            return arr.get(arr.size()-1);
        }

        for(int i=2; i<arr.size()-1; i++) {
            if(arr.get(i) != arr.get(i+1)) {
                lonelyInteger = arr.get(i);
                break;
            }
            i++;
        }
        return lonelyInteger;
    }
}
