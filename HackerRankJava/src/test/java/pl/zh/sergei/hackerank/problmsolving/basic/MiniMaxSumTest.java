package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MiniMaxSumTest {

    @ParameterizedTest
    @MethodSource("getMiniMaxSumHappyPathData")
    public void miniMaxSum_happyPath(List<Integer> incomingArr, Long [] expectedResult) {

        List<Long> receivedResult = MiniMaxSum.miniMaxSum(incomingArr);
        assertThat(receivedResult).hasSize(expectedResult.length).contains(expectedResult);
    }

    private static Stream<Arguments> getMiniMaxSumHappyPathData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), new Long [] {10L, 14L}),
                Arguments.of(List.of(256741038, 623958417, 467905213, 714532089, 938071625),
                        new Long [] {2063136757L, 2744467344L}),
                Arguments.of(List.of(256741038, 623958417, 467905213, 714532089, 938071625),
                        new Long [] {2063136757L, 2744467344L}),
                Arguments.of(List.of(396285104, 573261094, 759641832, 819230764, 364801279),
                        new Long [] {2093989309L, 2548418794L})
        );
    }
}
