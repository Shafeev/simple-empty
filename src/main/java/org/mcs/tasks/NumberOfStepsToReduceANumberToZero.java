package org.mcs.tasks;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * <p>
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(10));
        System.out.println(numberOfSteps(3));
    }

    private static int numberOfSteps(int num) {
        int step = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            step++;
        }
        return step;
    }
}
