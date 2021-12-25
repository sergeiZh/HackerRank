package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SparseArraysTest {

    @ParameterizedTest
    @MethodSource("getMatchingStringsDataInfo")
    public void matchingStrings_happyPath(List<String> incomingValues, List<String> queries, List<Integer> expectedResult) {
        List<Integer> actualResult = SparseArrays.matchingStrings(incomingValues, queries);
        assertThat(actualResult).hasSize(expectedResult.size()).contains(expectedResult.toArray(new Integer[]{}));
    }

    private static Stream<Arguments> getMatchingStringsDataInfo() {
        return Stream.of(
            Arguments.of(List.of("4", "aba", "baba", "aba", "xzxb", "3"), List.of("aba", "xzxb", "ab"), List.of(2, 1, 0)),
            Arguments.of(List.of("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf"
            , "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
                    List.of("abcde", "sdaklfj", "asdjf", "na", "basdn"), List.of(1, 3, 4, 3, 2))
        );
    }
}

