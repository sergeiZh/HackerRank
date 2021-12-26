package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * You will be given a list of 32 bit unsigned integers.
 * Flip all the bits (1 -> 0 and 0 -> 1) ( and ) and return the result as an unsigned integer.
 *
 * Example:
 * n = 9 (decimal)
 * binary representation is 1001. Since result should be as 32 bits so it looks like
 * 00000000000000000000000000001001 = 9
 * output should be reversed so it will be
 * 11111111111111111111111111110110 = 4294967286
 *
 * Assumed that incoming decimal is not more than 2 in 32 pow
 */
public class FlippingBits {

    public static long flippingBits(long decimalNumber) {
        String binaryString = Long.toBinaryString(decimalNumber);
        String reverseBinaryString = Arrays.stream(binaryString.split(""))
                                           .map(binaryStr -> convertToOpposite(binaryStr))
                                           .collect(Collectors.joining());
        int amountTo32Length = 32 - reverseBinaryString.length();
        if (amountTo32Length == 0) {
            return Long.parseLong(reverseBinaryString, 2);
        }

        String resultBinaryString = LongStream.range(0, amountTo32Length).mapToObj(number -> "1")
                                              .collect(Collectors.joining())
                                              .concat(reverseBinaryString);
        return Long.parseLong(resultBinaryString, 2);
    }

    private static String convertToOpposite(String binaryString) {
        if(binaryString.equals("1")) {
            return "0";
        }
        return "1";
    }
}
