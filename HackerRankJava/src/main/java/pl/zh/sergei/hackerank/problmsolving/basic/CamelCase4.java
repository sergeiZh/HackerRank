package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Camel Case is a naming style common in many programming languages.
 * In Java, method and variable names typically start with a lowercase letter,
 * with all subsequent words starting with a capital letter (example: startThread).
 * Names of classes follow the same pattern, except that they start with a
 * capital letter (example: BlueCar).
 *
 * Your task is to write a program that creates or splits Camel Case variable,
 * method, and class names.
 *
 * Input Format
 *
 *     Each line of the input file will begin with an operation (S or C) followed by
 *     a semi-colon followed by M, C, or V followed by a semi-colon followed by
 *     the words you'll need to operate on.
 *
 *     The operation will either be S (split) or C (combine)
 *     M indicates method, C indicates class, and V indicates variable
 *
 *     In the case of a split operation, the words will be a camel case method,
 *     class or variable name that you need to split into a space-delimited list
 *     of words starting with a lowercase letter.
 *
 *     In the case of a combine operation, the words will be a space-delimited list
 *     of words starting with lowercase letters that you need to combine into the
 *     appropriate camel case String. Methods should end with an empty set of parentheses
 *     to differentiate them from variable names.
 *
 *     Output Format
 *
 *     For each input line, your program should print either the space-delimited
 *     list of words (in the case of a split operation) or the appropriate camel
 *     case string (in the case of a combine operation).
 *
 *     Sample Input
 *
 *     S;M;plasticCup()
 *     C;V;mobile phone
 *     C;C;coffee machine
 *     S;C;LargeSoftwareBook
 *     C;M;white sheet of paper
 *     S;V;pictureFrame
 *
 *     Sample Output
 *     plastic cup
 *     mobilePhone
 *     CoffeeMachine
 *     large software book
 *     whiteSheetOfPaper()
 *     picture frame
 */
public class CamelCase4 {

    // I don't know why but on HackerRank they decided to provide values as keyboard input
    // here is {@link Scanner} class is saving the situation. Very weird but had to solve the
    // task somehow
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        while (scan.hasNext()){
            System.out.println(convertToCamelCase(scan.nextLine()));
        }

    }

    public static List<String> camelCaseConverter(String [] args) {
        return Arrays.asList(args).stream()
                .map(CamelCase4::convertToCamelCase)
                .collect(Collectors.toList());
    }

    private static String convertToCamelCase(String inputForConversion) {
        List<String> formattingParts = Arrays.asList(inputForConversion.split(";"));
        String[] split = formattingParts.get(2).split("");
        String resultWord = "";
        if(formattingParts.get(0).equals("S")) {
            resultWord = Stream.of(split).map(letter -> {
                if (letter.matches("[A-Z]")) {
                    return " " + letter.toLowerCase();
                }
                return letter;
            }).collect(Collectors.joining()).trim();
            if(formattingParts.get(1).equals("M")) {
                resultWord = resultWord.replace("()", "");
            }
        } else {
            String[] splittedBySpace = formattingParts.get(2).split(" ");
            resultWord = Stream.of(splittedBySpace)
                    .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                    .collect(Collectors.joining());
            if(formattingParts.get(1).equals("V")) {
                resultWord = Character.toLowerCase(resultWord.charAt(0)) + resultWord.substring(1);
            } else if(formattingParts.get(1).equals("M")) {
                resultWord = Character.toLowerCase(resultWord.charAt(0)) + resultWord.substring(1) + "()";
            }
        }

        return resultWord;
    }
}