package org.mcs.tasks.binarySearch;

/**
 * Предположим, что массив длины n, отсортированный по возрастанию, поворачивается от 1 до n раз.
 * Например, массив nums = [0,1,2,4,5,6,7] может стать:
 *
 * [4,5,6,7,0,1,2], если он был повернут 4 раза.
 * [0,1,2,4,5,6,7], если он был повернут 7 раз.
 *
 * Обратите внимание, что при повороте массива [a[0], a[1], a[2], ..., a[n-1]] 1 раз получается массив
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Учитывая отсортированный повернутый массив nums уникальных элементов, верните минимальный элемент этого массива.
 *
 * Вы должны написать алгоритм, который выполняется за время O(log n).
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {10, 12, 13, 14, 15, -1, 0, 2, 3, 4, 5};
        System.out.println("Min value: " + findMin(nums));
        System.out.println("Min value: " + findMin2(nums));
    }


    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int center = (end + start) / 2;

            if (nums[center] > nums[end]) {
                start = center + 1;
            } else {
                end = center;
            }
        }
        return nums[start];
    }


    private static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
