package org.mcs.tasks.array;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
//        Arrays.stream(nums1).boxed().forEach(o -> System.out.print(" " + o));
//        [1,2,2,3,5,6]
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int index = 0; index < n; index++) {
            int index1 = m + index;
            nums1[index1] = nums2[index];
        }


        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < nums1.length - 1; i++) {
                if (nums1[i] > nums1[i + 1]) {
                    isSorted = false;
                    int value = nums1[i];
                    nums1[i] = nums1[i + 1];
                    nums1[i + 1] = value;
                }
            }
        }
    }
}
