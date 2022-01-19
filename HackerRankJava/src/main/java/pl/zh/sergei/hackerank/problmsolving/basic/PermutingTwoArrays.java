package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * There are two n-element arrays of integers, A and B.
 * Permute them into some A' and B' such that the relation A'[i] + B'[i]>= k holds for all i where 0<=i<n.
 * If it's possible method should return "YES". If at least there is 1 pair which is less than provided
 * value, method should return "NO"
 *
 * In other words sum of every elements of 2 arrays should be more or equal provided value.
 * STDIN       Function
 * -----       --------
 * 2           q = 2
 * 3 10        A[] and B[] size n = 3, k = 10
 * 2 1 3       A = [2, 1, 3]
 * 7 8 9       B = [7, 8, 9]
 * Will return "YES"
 * 4 5         A[] and B[] size n = 4, k = 5
 * 1 2 2 1     A = [1, 2, 2, 1]
 * 3 3 3 4     B = [3, 3, 3, 4]
 * Will return "NO"
 */
public class PermutingTwoArrays {

    /**
     * Idea is to iterate over 2 arrays and find pairs which greater or equal to 'etalonValue'
     * Important note - it's possible that for 1 element there are more than 1 pair of fitting
     * elements from second array. In that case I store all matching results and after that
     * find index of element of the 2-nd array with which summ is the lowest
     */
    public static String twoArrays(int etalonValue, List<Integer> firstArr, List<Integer> secondArr) {
        String twoArraysPermutableStatement = "YES";
        List<Integer> cloneOfSecArr = new ArrayList<>(secondArr);
        for(int firstArrIndex=0; firstArrIndex < firstArr.size(); firstArrIndex++) {
            Map<Integer, Integer> indexOfPossiblePairs = new HashMap<>();
            for(int secondArrIndex=0; secondArrIndex<cloneOfSecArr.size(); secondArrIndex++) {
                if(firstArr.get(firstArrIndex) + cloneOfSecArr.get(secondArrIndex) >= etalonValue) {
                    indexOfPossiblePairs.put(secondArrIndex, cloneOfSecArr.get(secondArrIndex));
                    continue;
                }

            }
            if(indexOfPossiblePairs.isEmpty()) {
                twoArraysPermutableStatement = "NO";
                break;
            }

            Optional<Map.Entry<Integer, Integer>> mapWithOnlyValueWithLeastSumm =
                    indexOfPossiblePairs.entrySet().stream().reduce((accum, currValue) -> accum.getValue() < currValue.getValue() ? accum :
                            currValue);
            cloneOfSecArr.remove(mapWithOnlyValueWithLeastSumm.get().getKey().intValue());
            indexOfPossiblePairs.clear();
        }
        return twoArraysPermutableStatement;
    }
}
