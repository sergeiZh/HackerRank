package pl.zh.sergei.hackerank.problmsolving.basic;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusMinusTest {

    @ParameterizedTest
    @MethodSource("getPlusMinusParametrizedValuesForHappyPath")
    public void plusMinus_happyPath(List<Integer> arr, BigDecimal[] expectedResult) {

        List<BigDecimal> actualResult = PlusMinus.plusMinus(arr);
        assertThat(actualResult).hasSize(3).contains(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("getPlusMinusParametrizedValuesForOneOfInputTypeZero")
    public void plusMinus_returnsZeroRatioForAbsentTypeOfInput(List<Integer> arr, BigDecimal[] expectedResult) {

        List<BigDecimal> actualResult = PlusMinus.plusMinus(arr);
        assertThat(actualResult).hasSize(3).contains(expectedResult);
    }

    private static Stream<Arguments> getPlusMinusParametrizedValuesForHappyPath() {
        BigDecimal positiveRatioExpected1 = new BigDecimal(0.400000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected1 = new BigDecimal(0.200000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected1 = new BigDecimal(0.400000).setScale(6, RoundingMode.HALF_UP);

        BigDecimal positiveRatioExpected2 = new BigDecimal(0.500000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected2 = new BigDecimal(0.333333).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected2 = new BigDecimal(0.166667).setScale(6, RoundingMode.HALF_UP);

        BigDecimal positiveRatioExpected3 = new BigDecimal(0.400000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected3 = new BigDecimal(0.400000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected3 = new BigDecimal(0.200000).setScale(6, RoundingMode.HALF_UP);

        BigDecimal positiveRatioExpected4 = new BigDecimal(1.000000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected4 = new BigDecimal(0.000000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected4 = new BigDecimal(0.000000).setScale(6, RoundingMode.HALF_UP);

        return Stream.of(
                Arguments.of(List.of(0, 0, -1, 1, 1),
                        new BigDecimal[]{positiveRatioExpected1, negativeRatioExpected1, zeroRatioExpected1}),
                Arguments.of(List.of(-4, 3, -9, 0, 4, 1),
                        new BigDecimal[]{positiveRatioExpected2, negativeRatioExpected2, zeroRatioExpected2}),
                Arguments.of(List.of(0, 4, -3, 3, -6),
                        new BigDecimal[]{positiveRatioExpected3, negativeRatioExpected3, zeroRatioExpected3}),
                Arguments.of(List.of(55, 48, 48, 45, 91, 97, 45, 1, 39, 54, 36, 6, 19, 35, 66, 36, 72, 93, 38,
                        21, 65, 70, 36, 63, 39, 76, 82, 26, 67, 29, 24, 82, 62, 53, 1, 50, 47, 65, 67, 19, 66, 90, 77),
                        new BigDecimal[]{positiveRatioExpected4, negativeRatioExpected4, zeroRatioExpected4})
        );
    }

    private static Stream<Arguments> getPlusMinusParametrizedValuesForOneOfInputTypeZero() {
        BigDecimal positiveRatioExpected1 = new BigDecimal(0.428571).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected1 = new BigDecimal(0.571429).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected1 = new BigDecimal(0.000000).setScale(6, RoundingMode.HALF_UP);

        BigDecimal positiveRatioExpected2 = new BigDecimal(0.700000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected2 = new BigDecimal(0.000000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected2 = new BigDecimal(0.300000).setScale(6, RoundingMode.HALF_UP);

        BigDecimal positiveRatioExpected3 = new BigDecimal(0.000000).setScale(6, RoundingMode.HALF_UP);
        BigDecimal negativeRatioExpected3 = new BigDecimal(0.833333).setScale(6, RoundingMode.HALF_UP);
        BigDecimal zeroRatioExpected3 = new BigDecimal(0.166667).setScale(6, RoundingMode.HALF_UP);

        return Stream.of(
                Arguments.of(List.of(1, -2, -7, 9, 1, -8, -5),
                        new BigDecimal[]{positiveRatioExpected1, negativeRatioExpected1, zeroRatioExpected1}),
                Arguments.of(List.of(0, 100, 35, 0, 94, 40, 42, 87, 59, 0),
                        new BigDecimal[]{positiveRatioExpected2, negativeRatioExpected2, zeroRatioExpected2}),
                Arguments.of(List.of(0, -67, -74, -38, -72, -53, 0, -13, -95, -91, -100, -59, 0, -10, -68, -71, -62,
                        -21, 0, -42, -57, -16, -66, -23, 0, -80, -63, -68, -65, -71, 0, -71, -15, -32, -26, -8, 0, -6,
                        -51, -87, -19, -71, 0, -93, -26, -35, -56, -89, 0, -21, -74, -39, -57, -8, 0, -69, -29, -24,
                        -99, -53, 0, -65, -42, -72, -18, -4, 0, -73, -46, -63, -78, -87),
                        new BigDecimal[]{positiveRatioExpected3, negativeRatioExpected3, zeroRatioExpected3})
                );
    }
}
