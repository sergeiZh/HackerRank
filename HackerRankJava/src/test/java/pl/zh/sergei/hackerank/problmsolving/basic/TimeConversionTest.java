package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeConversionTest {

    @ParameterizedTest
    @MethodSource("getTimeConversionHappyPathData")
    public void timeConversion_happyPath(String input, String expectedOutput) {
        assertThat(TimeConversion.timeConversion(input)).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> getTimeConversionHappyPathData() {
        return Stream.of(
                Arguments.of("07:05:45PM", "19:05:45"),
                Arguments.of("12:40:22AM", "00:40:22"),
                Arguments.of("04:59:59AM", "04:59:59")
        );
    }
}
