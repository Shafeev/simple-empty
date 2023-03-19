package org.mcs.tasks.array;


/**
 * Учитывая массив arr целых чисел, проверьте, существуют ли два индекса i и j такие, что :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * <p>
 * Вход: arr = [3,1,7,11]
 * Выход: ложный
 * Объяснение: Не существует i и j, которые удовлетворяют условиям.
 */
public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 5, 4};
        System.out.println(checkIfExist(arr));
        int[] arr2 = new int[]{3, 1, 7, 11};
        System.out.println(checkIfExist(arr2));
        int[] arr3 = new int[]{7, 1, 14, 11};
        System.out.println(checkIfExist(arr3));
    }

    public static boolean checkIfExist(int[] arr) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
                    result = true;
                    break;
                }
            }

        }
        return result;
    }
}
