package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMaxSum {

    public static List<Long> miniMaxSum(List<Integer> arr) {
        List<Long> sumHolder = new ArrayList<>();
        List<Long> resultArr = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            List<Long> tempArr = arr.stream().mapToLong(value -> value).boxed().collect(Collectors.toList());
            tempArr.remove(i);
            sumHolder.add(tempArr.stream().mapToLong(value -> value).sum());
        }
        resultArr.add(sumHolder.stream().mapToLong(value -> value).min().getAsLong());
        resultArr.add(sumHolder.stream().mapToLong(value -> value).max().getAsLong());
        System.out.print(resultArr.get(0) + " " + resultArr.get(1));
        return resultArr;
    }
}
