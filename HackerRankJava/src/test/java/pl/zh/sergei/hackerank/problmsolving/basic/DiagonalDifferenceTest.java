package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DiagonalDifferenceTest {

    @ParameterizedTest
    @MethodSource("getDiagonalDifferenceHappyPathDataInfo")
    public void diagonalDifference_happyPath(List<List<Integer>> incomingArray, int outputResult) {
        assertThat(DiagonalDifference.diagonalDifference(incomingArray)).isEqualTo(outputResult);
    }

    private static Stream<Arguments> getDiagonalDifferenceHappyPathDataInfo() {
        return Stream.of(
          Arguments.of(List.of(List.of(11,2,4), List.of(4,5,6), List.of(10,8,-12)), 15),
          Arguments.of(List.of(List.of(6,6,7,-10,9,-3,8,9,-1),List.of(9,7,-10,6,4,1,6,1,1),
                               List.of(-1,-2,4,-6,1,-4,-6,3,9), List.of(-8,7,6,-1,-6,-6,6,-7,2),
                               List.of(-10,-4,9,1,-7,8,-5,3,-5), List.of(-8,-3,-4,2,-3,7,-5,1,-5),
                               List.of(-2,-7,-4,8,3,-1,8,2,3), List.of(-3,4,6,-7,-7,-8,-3,9,-6),
                               List.of(-2,0,5,4,4,4,-3,3,0)), 52)
        );
    }
}
