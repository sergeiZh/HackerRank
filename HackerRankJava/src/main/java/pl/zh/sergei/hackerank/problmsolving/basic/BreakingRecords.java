package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;

public class BreakingRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int maxScoreBeatenAmount = 0;
        int minScoreBeatenAmount = 0;
        int maxScoreValue = scores.get(0);
        int minScoreValue = scores.get(0);

        for(int i=1; i<scores.size(); i++) {
            if(scores.get(i) > maxScoreValue) {
                maxScoreBeatenAmount++;
                maxScoreValue = scores.get(i);
            } else if (scores.get(i) < minScoreValue) {
                minScoreBeatenAmount++;
                minScoreValue = scores.get(i);
            }
        }

        return List.of(maxScoreBeatenAmount, minScoreBeatenAmount);
    }
}