package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingValleysTest {

    @ParameterizedTest
    @MethodSource("countingValleysHappyPathDataInfo")
    public void countingValleys_happyPath(int stepsAmount, String hikingPath, int valleysAmount) {
        assertThat(CountingValleys.countingValleys(stepsAmount, hikingPath)).isEqualTo(valleysAmount);
    }

    private static Stream countingValleysHappyPathDataInfo() {
        return Stream.of(
                Arguments.of(8, "DDUUUUDD", 1),
                Arguments.of(8, "UDDDUDUU", 1),
                Arguments.of(10, "DUDDDUUDUU", 2)
        );
    }
}
