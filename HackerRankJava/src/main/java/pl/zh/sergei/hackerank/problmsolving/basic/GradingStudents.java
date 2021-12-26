package pl.zh.sergei.hackerank.problmsolving.basic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * HackerLand University has the following grading policy:
 *
 *    - Every student receives a grade in the inclusive range from to 0 to 100
 *    - Any grady less than 40 is a failing grade.
 *
 * Sam is a professor at the university and likes to round each student's grade according to these rules:
 *    - If the difference between the grade and the next multiple of 5 is less than 3, round up to the next
 *      multiple of 5.
 *    - If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 *
 * Examples:
 *    - grade = 84 round to 85 (85 - 84 is less than 3)
 *    - grade = 29 do not round (result is less than 40)
 *    - grade = 57 do not round (60 - 57 is 3 or higher)
 *    - grade = 38 don not round (40-38 is 2 which is less than 3. Only works for 38 and 39 since under 40
 *      is university failing grade)
 *
 * Given the initial value of grade for each of Sam's N students, write code to automate the rounding process.
 */
public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(GradingStudents::roundGrade).collect(Collectors.toList());

    }

    private static int roundGrade(int grade) {
        // professor doesn't round values under 38
        if(grade < 38) {
            return grade;
        }

        // find closest divisible by 5 number using recursion. Just incrementing incoming values till it will be found
        int closetDivisibleByFiveNumber = findClosestDivisibleByFiveNumber(grade);
        if(closetDivisibleByFiveNumber - grade < 3) {
            return closetDivisibleByFiveNumber;
        }
        return grade;
    }

    private static int findClosestDivisibleByFiveNumber(int grade) {
        if(grade % 5 == 0){
            return grade;
        }
        grade++;
        return findClosestDivisibleByFiveNumber(grade);
    }
}
