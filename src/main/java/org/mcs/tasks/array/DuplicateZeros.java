package org.mcs.tasks.array;

import java.util.Arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        System.out.println("" + arr);
        Arrays.stream(arr).boxed().forEach(o -> System.out.print(" " + o));
        duplicateZeros(arr);
//        System.arraycopy(arr, 2, arr, 1, arr.length - 1);
        System.out.println("");
        Arrays.stream(arr).boxed().forEach(o -> System.out.print(" " + o));
    }

    private static void duplicateZeros(int[] arr) {
        int count = arr.length;

        for (int index = 0; index < count; index++) {
            if (arr[index] == 0) {
                for (int j = arr.length - 1; j >= index + 2; j--) {
                    arr[j] = arr[j-1];
                }
                if ((index + 1) < count) {
                    arr[index + 1] = 0;
                    index++;
                }
            }
        }
    }
}
