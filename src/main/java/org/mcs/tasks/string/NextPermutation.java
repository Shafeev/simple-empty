package org.mcs.tasks.string;

import java.util.Arrays;

/**
 * Перестановка массива целых чисел — это расположение его элементов в последовательности или линейном порядке.
 * <p>
 * Например, для arr = [1,2,3] следующие все перестановки arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * Следующая перестановка массива целых чисел — это следующая лексикографически большая перестановка его целого числа.
 * Более формально, если все перестановки массива отсортированы в одном контейнере в соответствии с их
 * лексикографическим порядком, то следующей перестановкой этого массива будет перестановка, следующая за ней в
 * отсортированном контейнере. Если такое расположение невозможно, массив необходимо переупорядочить в самом низком
 * возможном порядке (т. е. отсортировать по возрастанию).
 * <p>
 * Например, следующая перестановка arr = [1,2,3] — это [1,3,2].
 * Точно так же следующая перестановка arr = [2,3,1] будет [3,1,2].
 * В то время как следующей перестановкой arr = [3,2,1] является [1,2,3], потому что [3,2,1] не имеет лексикографически
 * большей перестановки.
 * Дан массив целых чисел nums, найти следующую перестановку nums.
 * <p>
 * Замена должна быть на месте и использовать только постоянную дополнительную память.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int p = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        int q = 0;
        for (int i = nums.length - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

        if (p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

        if (p < nums.length - 1) {
            reverse(nums, p + 1, nums.length - 1);
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
