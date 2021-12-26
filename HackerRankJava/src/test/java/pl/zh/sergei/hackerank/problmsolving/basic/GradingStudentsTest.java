package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GradingStudentsTest {

    @ParameterizedTest
    @MethodSource("getGradingStudentsDataInfo")
    public void gradingStudents_happyPath(List<Integer> inputValues, Integer[] expectedResult) {
        List<Integer> actualResult = GradingStudents.gradingStudents(new ArrayList<>(inputValues));
        assertThat(actualResult).hasSize(expectedResult.length).contains(expectedResult);
    }

    private static Stream<Arguments> getGradingStudentsDataInfo() {
        return Stream.of(
                Arguments.of(List.of(84, 29, 57), new Integer[]{85, 29, 57}),
                Arguments.of(List.of(73, 67, 38, 33), new Integer[]{75, 67, 40, 33}),
                Arguments.of(List.of(6, 98, 25, 97, 24, 25, 70, 50, 71, 30, 14, 28, 100, 3, 26, 61, 98, 50, 41, 5, 3, 28, 34, 0),
                             new Integer[]{6, 100, 25, 97, 24, 25, 70, 50, 71, 30, 14, 28, 100, 3, 26, 61, 100, 50, 41, 5, 3, 28, 34, 0})
        );
    }
}
