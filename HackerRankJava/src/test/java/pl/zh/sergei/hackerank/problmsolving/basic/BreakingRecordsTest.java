package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BreakingRecordsTest {

    @ParameterizedTest
    @MethodSource("getBreakingRecordsHappyPathData")
    public void breakingRecords_happyPath(List<Integer> incomingValues, Integer[] expectedResult) {
        List<Integer> integers = BreakingRecords.breakingRecords(incomingValues);

        assertThat(integers).hasSize(2).contains(expectedResult);
    }

    private static Stream<Arguments> getBreakingRecordsHappyPathData() {
        return Stream.of(
                Arguments.of(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1), new Integer[]{2, 4}),
                Arguments.of(List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42), new Integer[]{4, 0})
        );
    }
}
