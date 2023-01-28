package org.mcs.tasks.binarySearch;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class GuessNumberHigherOrLower {
    private static int pick = 10;

    public static void main(String[] args) {
        System.out.println(guessNumber(55));
    }

    private static int guessNumber(int n) {
        int start = 0;
        int end = n;
        int answer = guess(n);
        int center = n;
        while(answer != 0) {
            center = start + (end - start)/2;
            System.out.println(center);
            answer = guess(center);
            if (answer == -1) { // загаданное число больше
                end = center - 1;
            } else if (answer == 1) { // загаданное число меньше
                start = center + 1;
            }
        }

        return center;
    }

    private static int guess(int num) {
        return Integer.compare(pick, num);

    }
}
