package pl.zh.sergei.hackerank.problmsolving.intermediate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FlippingMatrixTest {

    @ParameterizedTest
    @MethodSource("flippingMatrix_happyPathDataInfo")
    public void flippingMatrix_happyPath(List<List<Integer>> incomingMatrix, int expectedMaxSum) {
        assertThat(FlippingMatrix.flippingMatrix(incomingMatrix)).isEqualTo(expectedMaxSum);
    }

    private static Stream<Arguments> flippingMatrix_happyPathDataInfo() {
        return Stream.of(
                Arguments.of(List.of(List.of(12,11,13,35), List.of(15,25,18,41), List.of(15,44,28,39), List.of(20,9,10,25)), 133),
                Arguments.of(List.of(List.of(112,56,15,62), List.of(42,125,78,98), List.of(83,56,101,114), List.of(119,49,43,108)), 414)
        );
    }

    @ParameterizedTest
    @MethodSource("createMatrixCalculationScheme_happyPathDataInfo")
    public void createMatrixCalculationScheme_happyPath(List<List<Integer>> incomingMatrix, List<List<Integer>> expectedResult) {
        List<List<Integer>> actualResult = FlippingMatrix.createMatrixCalculationScheme(incomingMatrix);
        List<Integer> collect = actualResult.stream().flatMap(Collection::stream).collect(Collectors.toList());
        assertThat(collect).contains(expectedResult.stream().flatMap(Collection::stream).collect(Collectors.toList()).toArray(new Integer[]{}));
    }

    private static Stream<Arguments> createMatrixCalculationScheme_happyPathDataInfo() {
        return Stream.of(
                Arguments.of(List.of(List.of(1,3), List.of(2,4)), List.of(List.of(2,2))),
                Arguments.of(List.of(List.of(12,11,13,35), List.of(15,25,18,39), List.of(15,44,28,39), List.of(20,9,10.25)),
                             List.of(List.of(4,4), List.of(4,2), List.of(2,4), List.of(2,2)))
        );
    }

    @ParameterizedTest
    @MethodSource("calculateMaxNumberForEachScheme_happyPathDataInfo")
    public void calculateMaxNumberForEachScheme_happyPath(List<List<Integer>> incomingMatrix,
                                                          List<List<Integer>> calculationScheme,
                                                          List<Integer> expectedResult) {
        List<Integer> actualResult = FlippingMatrix.calculateMaxNumberForEachScheme(incomingMatrix, calculationScheme);
        assertThat(actualResult).contains(expectedResult.toArray(new Integer[]{}));
    }

    private static Stream<Arguments> calculateMaxNumberForEachScheme_happyPathDataInfo() {
        return Stream.of(
                Arguments.of(List.of(List.of(12,11,13,35), List.of(15,25,18,41), List.of(15,44,28,39), List.of(20,9,10,25)),
                             List.of(List.of(4,4), List.of(4,2), List.of(2,4), List.of(2,2)),
                             List.of(35,41,13,44))
        );
    }
}
