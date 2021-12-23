package pl.zh.sergei.hackerank.problmsolving.basic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with
 *
 * places after the decimal.
 *
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places,
 * though answers with absolute error of up to 10 pow(-4)
 *
 * are acceptable.
 *
 * Example
 * arr = [1, 1, 0, -1, -1]
 * There are n=5 elements, two positive, two negative and one zero.
 * Their ratios are 2/5 = 0.400000, 2/5 = 0.400000 and 1/5 = 0.200000
 *
 * . Results are printed as:
 *
 * 0.400000
 * 0.400000
 * 0.200000
 */
public class PlusMinus {

    public static List<BigDecimal> plusMinus(List<Integer> arr) {
        double positiveCounter = 0.0;
        double negativeCounter = 0.0;
        double zeroCounter = 0.0;
        BigDecimal arrSizeBigDecimal = new BigDecimal((double) arr.size());

        for(int i=0; i < arr.size(); i++) {
            if(arr.get(i) > 0) {
                positiveCounter++;
            } else if(arr.get(i) == 0) {
                zeroCounter++;
            } else {
                negativeCounter++;
            }
        };

        BigDecimal positiveRatio = divideBigDecimals(new BigDecimal(positiveCounter), arrSizeBigDecimal);
        BigDecimal negativeRatio = divideBigDecimals(new BigDecimal(negativeCounter), arrSizeBigDecimal);
        BigDecimal zeroRatio = divideBigDecimals(new BigDecimal(zeroCounter), arrSizeBigDecimal);

        // system out is required by task description
        System.out.println(positiveRatio);
        System.out.println(negativeRatio);
        System.out.println(zeroRatio);

        return List.of(positiveRatio, negativeRatio, zeroRatio);
    }

    private static BigDecimal divideBigDecimals(BigDecimal devidedValue, BigDecimal devideValue) {
        return devidedValue.divide(devideValue, 6, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        plusMinus(List.of(-4, 3, -9, 0, 4, 1));

    }
}
