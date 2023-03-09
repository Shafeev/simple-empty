package org.mcs.tasks.array;

public class FindNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 123, 1234, 2};
        System.out.println(findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int length = String.valueOf(num).length();

            if (length%2 == 0) {
                count++;
            }
        }
        return count;
    }
}
