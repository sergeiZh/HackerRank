package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisibleSumPairsTest {

    @ParameterizedTest
    @MethodSource("getDivisibleSumPairsData")
    public void divisibleSumPairs_happyPath(int arrSize, int valueToMatch, List<Integer> inputValues, int expectedResult) {
        int actualAmountOfPairs = DivisibleSumPairs.divisibleSumPairs(arrSize, valueToMatch, inputValues);
        assertThat(actualAmountOfPairs).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> getDivisibleSumPairsData() {
        return Stream.of(
          Arguments.of(6, 5, List.of(1, 5, 4, 3, 2, 6), 3),
          Arguments.of(6, 3, List.of(1, 3, 2, 6, 1, 2), 5),
          Arguments.of(100, 40, List.of(13, 91, 5, 100, 5, 12, 5, 79, 99, 87, 59, 65, 62, 73,
                  93, 73, 63, 65, 59, 46, 67, 35, 22, 55, 50, 53, 38, 79, 75, 44, 95, 53, 5,
                  73, 44, 94, 95, 21, 60, 2, 32, 48, 72, 13, 91, 74, 79, 99, 17, 31, 53, 20,
                  88, 17, 54, 47, 56, 79, 23, 49, 95, 81, 9, 50, 12, 20, 45, 82, 44, 82, 93,
                  15, 73, 51, 65, 96, 4, 77, 37, 41, 30, 11, 65, 100, 62, 51, 64, 48, 12, 11,
                  68, 81, 46, 37, 10, 46, 75, 82, 21, 23),
                  109)
        );
    }
}
