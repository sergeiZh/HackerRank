package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implement counting sort
 * Counting sort, does not require comparison. Instead, you create an integer array whose index range covers the
 * entire range of values in your array to sort. Each time a value occurs in the original array, you increment
 * the counter at that index. At the end, run through your counting array, printing the value of each non-zero
 * valued index that number of times.
 *
 * Example:
 * arr = [1,1,3,2,1]
 * All of the values are in the range [0 ... 3] , so create an array of zeros, result=[0,0,0,0]
 * The results of each iteration follow:x
 *
 * i    arr[i]  result
 * 0    1       [0,1,0,0]
 * 1    1       [0,2,0,0]
 * 2    3       [0,2,0,1]
 * 3    2       [0,2,1,1]
 * 4    1       [0,3,1,1]
 *
 * The frequency array is [0,3,1,1] These values can be used to create the sorted array as well: [1,1,1,2,3]
 *
 * Note
 * For this exercise, always return a frequency array with 100 elements. The example above shows only the first 4 elements, the remainder being zeros.
 *
 * Challenge
 * Given a list of integers, count and return the number of times each value appears as an array of integers.
 */
public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> output = IntStream.range(0, 100).map(value -> 0).boxed().collect(Collectors.toList());
        for(int i=0; i<arr.size(); i++) {
            Integer indexValue = arr.get(i);
            Integer integer = output.get(indexValue);
            output.set(indexValue, ++integer);
        }
        return output;
    }
}
