package pl.zh.sergei.hackerank.problmsolving.basic;

/**
 * Code would help hikers to count how many valleys they went through during their journey
 * Path hikers took would be described as movement UP and DOWN. So 'D' means moving 1 step UP and
 * 'U' - moving 1 step DOWN. Hikers can climb mountains and visit valleys.
 * In this case only valleys should be taken into consideration.
 * Example:
 * Hiker made 8 steps DDUUUUDD
 *              /    \
 *   ___       /      \____
 *      \     /
 *       \   /
 *  Here hiker visited 1 valley and climbed 1 mountain. Since we count only valleys OUTPUT should be 1
 *
 *  One more example
 *  Hiker made 8 steps UDDDUDUU
 *
 *  ___/    \             ______
 *           \           /
 *            \   / \   /
 *  1 mountain and 1 valley. Output - 1
 */
public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        int stepsDownCounter = 0;
        int stepsUpCounter = 0;
        int amountOfValleys = 0;
        String[] splittedSteps = path.split("");
        for(int i=0; i<splittedSteps.length; i++) {
            if(splittedSteps[i].equals("D")) {
                stepsDownCounter++;
            } else if(splittedSteps[i].equals("U")) {
                stepsUpCounter++;
            }

            if(splittedSteps[i].equals("U") && stepsDownCounter - stepsUpCounter == 0) {
                amountOfValleys++;
            }
        }
        return amountOfValleys;
    }
}
