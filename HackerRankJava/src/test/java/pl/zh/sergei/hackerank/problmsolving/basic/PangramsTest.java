package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PangramsTest {

    @ParameterizedTest
    @MethodSource("pangramsHappyPathDataInfo")
    public void pangrams_happyPath(String incomingSentence, String expectedResult) {
        assertThat(Pangrams.pangrams(incomingSentence)).isEqualTo(expectedResult);
    }

    private static Stream pangramsHappyPathDataInfo() {
        return Stream.of(
                Arguments.of("We promptly judged antique ivory buckles for the next prize", "pangram"),
                Arguments.of("We promptly judged antique ivory buckles for the prize", "not pangram")
        );
    }
}
