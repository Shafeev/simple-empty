package org.mcs.tasks.binary;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Учитывая целочисленный массив nums и целое число k, вернуть k-й наибольший элемент в массиве.
 *
 * Обратите внимание, что это k-й наибольший элемент в отсортированном порядке, а не k-й отдельный элемент.
 *
 * Вы должны решить ее с временной сложностью O(n).
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
        int[] nums2 = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums2, 2));
    }

    private static int findKthLargest(int[] nums, int k) {
        List<Integer> listNums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return listNums.get(k-1);
    }
}
