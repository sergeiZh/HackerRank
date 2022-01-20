package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SubarrayDivision2Test {

    @ParameterizedTest
    @MethodSource("birthdayHappyPathDataInfo")
    public void birthday_happyPath(List<Integer> birthdayChocolate, int birthDay, int birthMonth, int expectedOutput) {
        assertThat(SubarrayDivision2.birthday(birthdayChocolate, birthDay, birthMonth)).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> birthdayHappyPathDataInfo() {
        return Stream.of(
          Arguments.of(List.of(2,2,1,3,2), 4, 2, 2),
          Arguments.of(List.of(4), 4, 1, 1),
          Arguments.of(List.of(1,2,1,3,2), 3, 2, 2)
        );
    }
}
