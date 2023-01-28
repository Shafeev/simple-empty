package org.mcs.tasks.binarySearch;

/**
 * Дан массив целых чисел nums, отсортированный в порядке возрастания, и целочисленная цель,
 * напишите функцию для поиска цели в nums. Если цель существует, верните ее индекс. В противном случае вернуть -1.
 *
 * Вы должны написать алгоритм со сложностью выполнения O(log n).
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("Result: " + search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length;
        int result = -1;

        while (startIndex <= endIndex) {
            int centerIndex = startIndex + (endIndex - startIndex)/2;
            if (centerIndex < nums.length) {
                if (nums[centerIndex] > target) {
                    endIndex = centerIndex - 1;
                } else if (nums[centerIndex] < target) {
                    startIndex = centerIndex + 1;
                } else if (nums[centerIndex] == target) {
                    result = centerIndex;
                    break;
                }
            } else {
                break;
            }
        }
        return result;
    }

    private static int searchO_n(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            if (value == target) {
                return index;
            }
        }
        return -1;
    }
}
