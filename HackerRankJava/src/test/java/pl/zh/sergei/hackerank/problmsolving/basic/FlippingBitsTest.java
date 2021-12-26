package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FlippingBitsTest {

    @ParameterizedTest
    @MethodSource("getFlippingBitsDataInfo")
    public void getFlippingBits_happyPath(long incomingValue, long expectedOutput) {
        long resultValue = FlippingBits.flippingBits(incomingValue);
        assertThat(resultValue).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> getFlippingBitsDataInfo() {
        return Stream.of(
          Arguments.of(9L, 4294967286L),
          Arguments.of(2147483647L, 2147483648L),
          Arguments.of(1L, 4294967294L),
          Arguments.of(0L, 4294967295L),
          Arguments.of(123456L, 4294843839L)
        );
    }
}
