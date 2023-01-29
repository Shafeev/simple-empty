package org.mcs.tasks.binarySearch;

/**
 * Имеется целочисленный массив nums, отсортированный по возрастанию (с отличными значениями).
 * <p>
 * Перед передачей в вашу функцию nums, возможно, * повернут на неизвестный индекс поворота k (1 <= k < nums.length) так,
 * что результирующий массив имеет вид
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-индексированный).
 * Например, [0,1,2,4,5,6,7] может быть повернут на индекс поворота 3 и стать [4,5,6,7,0,1,2].
 * <p>
 * Учитывая массив nums после возможного поворота и целое число target, верните индекс target, если он есть в nums,
 * или -1, если его нет в nums.
 * <p>
 * Вы должны написать алгоритм со сложностью выполнения O(log n).
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * Input: nums = [1], target = 0
 * Output: -1
 * <p>
 * Решение:
 * шаг 1: нужно найти поворот. Зная k-ый элемент поворота мы можем разделить поиск и искать в нужной части
 * шаг 2: ищем значение в левой или правой части от k элемента
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {10, 12, 13, 14, 15, 0, 2, 3, 4, 5};
        int target = 3;
        System.out.println("Result: " + search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (end + start) / 2;

            if (target == nums[center]) {
                return center;
            } else if (nums[center] <= nums[end]) {
                if (target >= nums[center] && target <= nums[end]) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            } else {
                if (target >= nums[start] && target < nums[center]) {
                    end = center - 1;
                } else {
                    start = center + 1;
                }
            }
        }

        return -1;
    }
}
