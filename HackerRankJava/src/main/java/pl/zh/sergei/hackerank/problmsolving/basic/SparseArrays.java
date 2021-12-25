package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * There is a collection of input strings and a collection of query strings.
 * For each query string, determine how many times it occurs in the list of input strings.
 * Return an array of the results.
 */
public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        return queries.stream().map(query -> getNumberOfEncounter(strings, query)).collect(Collectors.toList());

    }

    private static Integer getNumberOfEncounter(List<String> values, String query) {
        return (int)values.stream().filter(value -> value.equals(query)).count();
    }
}
