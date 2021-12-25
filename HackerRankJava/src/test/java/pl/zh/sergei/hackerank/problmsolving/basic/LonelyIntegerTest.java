package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LonelyIntegerTest {

    @ParameterizedTest
    @MethodSource("getLonelyIntegerDataInfo")
    public void getLonelyInteger_happyPath(List<Integer> inputValues, int expectedLonelyInteger) {
        int actualLonelyInteger = LonelyInteger.lonelyinteger(new ArrayList<>(inputValues));
        assertThat(actualLonelyInteger).isEqualTo(expectedLonelyInteger);
    }

    private static Stream<Arguments> getLonelyIntegerDataInfo() {
        return Stream.of(
          Arguments.of(List.of(1,2,3,4,3,2,1), 4),
          Arguments.of(List.of(59,88,14,8,85,1,94,74,57,96,39,2,47,43,35,17,53,52,92,31,99,48,94,30,92,60,32,45,88
                  ,13,39,50,22,65,89,46,65,76,57,67,99,35,76,46,85,82,45,62,53,80,74,22,31,52,82,13,41,96,2,1,80
                  ,62,4,20,50,89,59,67,60,8,41,14,47,48,17,4,43,30,32), 20),
          Arguments.of(List.of(1), 1)
        );
    }
}
