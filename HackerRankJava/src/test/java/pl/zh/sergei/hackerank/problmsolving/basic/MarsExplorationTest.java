package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsExplorationTest {

    @ParameterizedTest
    @MethodSource("marsExplorationHappyPathTestInfo")
    public void marsExploration_happyPath(String incomingValue, int expectedAmountOfIncorrectLetters) {
        assertThat(MarsExploration.marsExploration(incomingValue)).isEqualTo(expectedAmountOfIncorrectLetters);
    }

    private static Stream marsExplorationHappyPathTestInfo() {
        return Stream.of(
                Arguments.of("SOSSPSSQSSOR", 3),
                Arguments.of("SOSSOSSOS", 0),
                Arguments.of("SSSSSSSSSSSSSSSOOOOOOOOOOOOOOOOOOOOOOOOOSSSSSSSO", 26)
        );
    }
}
