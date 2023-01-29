package org.mcs.tasks.binarySearch;

/**
 * Имеется целочисленный массив nums, отсортированный по возрастанию (не обязательно с разными значениями).
 * <p>
 * Перед передачей в вашу функцию nums поворачивается на неизвестный индекс поворота k (0 <= k < nums.length) так,
 * что результирующий массив имеет вид
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-индексированный).
 * Например, [0,1,2,4,4,4,5,6,6,7] может быть повернуто на индекс 5 и стать [4,5,6,6,7,0,1,2,4,4].
 * <p>
 * Учитывая массив nums после поворота и целое число target, возвращает true, если target находится в nums, или false,
 * если не находится в nums.
 * <p>
 * Вы должны максимально сократить общее количество этапов работы.
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int nums[] = {1};
        System.out.println(nums.length - 1);
        System.out.println(0 + (nums.length - 1) / 2);
        System.out.println(search(nums, 1));
        System.out.println(search2(nums, 1));
    }

    private static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (start + end) / 2;
            if (nums[center] == target)
                return true;
            if (nums[start] == nums[center] && nums[center] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[center]) {
                if (nums[start] <= target && target < nums[center])
                    end = center - 1;
                else
                    start = center + 1;
            } else {
                if (nums[center] < target && target <= nums[end])
                    start = center + 1;
                else
                    end = center - 1;
            }
        }

        return false;

    }

    private static boolean search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int center = (end + start) / 2;

            if (target == nums[center]) {
                return true;
            } else if (nums[start] == nums[center] && nums[center] == nums[end]) {
                start++;
                end--;
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

        return false;
    }

}
