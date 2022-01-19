package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class PermutingTwoArraysTest {

    @ParameterizedTest
    @MethodSource("twoArraysHappyPathDataInfo")
    public void twoArrays_happyPath(int etalon, List<Integer> firstArr, List<Integer> secondArr, String expectedValue) {
        assertThat(PermutingTwoArrays.twoArrays(etalon, firstArr, secondArr)).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> twoArraysHappyPathDataInfo() {
        return Stream.of(
          Arguments.of(10, List.of(2,1,3), List.of(7,8,9), "YES"),
          Arguments.of(5, List.of(1,2,2,1), List.of(3,3,3,4), "NO"),
          Arguments.of(4, List.of(1,3), List.of(3,1), "YES"),
          Arguments.of(5, List.of(2,3,1,1,1), List.of(1,3,4,3,3), "NO"),
          Arguments.of(9, List.of(1,5,1,4,4,2,7,1,2,2), List.of(8,7,1,7,7,4,4,3,6,7), "NO"),
          Arguments.of(9, List.of(3,6,8,5,9,9,4,8,4,7), List.of(5,1,0,1,6,4,1,7,4,3), "YES")
        );
    }
}
