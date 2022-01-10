package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix arr is shown below:
 * 1 2 3
 * 4 5 6
 * 9 8 9
 *
 * The left-to-right diagonal = 1 + 5 + 9 = 15 The right to left diagonal = 3 + 5 + 9 = 17
 * Their absolute difference is |15 - 17 | = 2
 */
public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftToRightDiagonalSum = calculateLeftToRightDiagonalSum(arr);
        int rightToLeftDiagonalSum = calculateRightToLeftDiagonalSum(arr);
        return Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
    }

    private static int calculateLeftToRightDiagonalSum(List<List<Integer>> arr) {
        int sumResult = 0;
        for(int i =0; i < arr.size(); i++) {
            sumResult = sumResult + arr.get(i).get(i);
        }
        return sumResult;
    }

    private static int calculateRightToLeftDiagonalSum(List<List<Integer>> arr) {
        int sumResult = 0;
        for(int i=0, k=arr.size()-1; i < arr.size(); i++, k--) {
            sumResult = sumResult + arr.get(i).get(k);
        }
        return sumResult;
    }

}
