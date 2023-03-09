package org.mcs.tasks.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        Arrays.stream(result).boxed().forEach(System.out::println);
    }

    private static int[] sortedSquares(int[] nums) {
        IntStream values = Arrays.stream(nums).boxed().map(o -> o * o).sorted(Integer::compareTo).mapToInt(Integer::intValue);
        return values.toArray();
    }
}
