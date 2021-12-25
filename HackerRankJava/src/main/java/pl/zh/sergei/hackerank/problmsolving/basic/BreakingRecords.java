package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;

/**
 * Maria plays college basketball and wants to go pro. Each season she maintains a
 * record of her play. She tabulates the number of times she breaks her season
 * record for most points and least points in a game. Points scored in the first
 * game establish her record for the season, and she begins counting from there.
 *
 * Example
 * scores = [12, 24, 10, 24];
 *
 * Scores are in the same order as the games played. She tabulates her results as follows:
 *
 *                                      Count
 *     Game  Score  Minimum  Maximum   Min Max
 *      0      12     12       12       0   0
 *      1      24     12       24       0   1
 *      2      10     10       24       1   1
 *      3      24     10       24       1   1
 *
 * Given the scores for a season, determine the number of times Maria breaks her records
 * for most and least points scored during the season.
 *
 * Function Description
 *
 * Complete the breakingRecords function in the editor below.
 *
 * breakingRecords has the following parameter(s):
 *
 *     int scores[n]: points scored per game
 *
 * Returns
 *
 *     int[2]: An array with the numbers of times she broke her records. Index
 *
 * is for breaking most points records, and index is for breaking least points records.
 */
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