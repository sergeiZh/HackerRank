package pl.zh.sergei.hackerank.problmsolving.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class CamelCase4Test {

    @ParameterizedTest
    @MethodSource("getCamelCaseConverterDataInfo")
    public void camelCaseConverter_happyPath(String[] inputValues, String[] expectedResult) {
        List<String> actualResult = CamelCase4.camelCaseConverter(inputValues);
        assertThat(actualResult).hasSize(inputValues.length).contains(expectedResult);

    }

    private static Stream<Arguments> getCamelCaseConverterDataInfo() {
        return Stream.of(
            Arguments.of(new String[]{"S;V;iPad", "C;M;mouse pad", "C;C;code swarm",
                            "S;C;OrangeHighlighter"},
                    new String[]{"i pad", "mousePad()", "CodeSwarm", "orange highlighter"}),
            Arguments.of(new String[]{"S;M;plasticCup()", "C;V;mobile phone", "C;C;coffee machine",
                    "S;C;LargeSoftwareBook", "C;M;white sheet of paper", "S;V;pictureFrame"},
                    new String[]{"plastic cup", "mobilePhone", "CoffeeMachine", "large software book",
                    "whiteSheetOfPaper()", "picture frame"})
        );
    }
}
