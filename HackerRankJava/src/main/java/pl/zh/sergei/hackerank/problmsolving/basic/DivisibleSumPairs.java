package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers and a positive integer k, determine the number of (i, j)
 * pairs where i < j (i and j here is an index of provided array and not elements of the array
 * itself) and ar[i] + ar[j] is divisible by k
 *
 * Example:
 * ar = [1, 2, 3, 4, 5, 6]
 * k = 5;
 *
 * Three pairs meet the criteria: [1,4], [2,3] and [4,6]
 *
 * Function Description
 *
 * Complete the divisibleSumPairs function in the editor below.
 *
 * divisibleSumPairs has the following parameter(s):
 *
 *     int n: the length of array ar
 *
 *     int ar[n]: an array of integers
 *     int k: the integer divisor
 *
 * Returns
 * - int: the number of pairs
 *
 * Input Format
 *
 * The first line contains 2 space-separated integers, n and k.
 * The second line contains n space-separated integers, each a value of arr[i].
 */
public class DivisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        List<Integer> numbersToEvaluate = new ArrayList<>(ar);
        int pairsAmount = 0;
        Collections.sort(numbersToEvaluate);
        for(int i=0; i < numbersToEvaluate.size() - 1; i++) {
            for (int j=i+1; j < numbersToEvaluate.size(); j++) {
                int firstNumber = numbersToEvaluate.get(i);
                int secondNumber = numbersToEvaluate.get(j);
                int elementSum = firstNumber + secondNumber;

                if(elementSum < k) {
                    continue;
                }

                if(elementSum % k == 0) {
                    pairsAmount++;
                }
            }
        }
        return pairsAmount;
    }

}
