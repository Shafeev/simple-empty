package org.mcs.tasks.binarySearch;


import java.util.Random;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * <p>
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int vertical = 10;
        int horizontal = 20;

        int matrix[][] = new int[][]{
                {1,2,3,4,5,6,7},
                {18,19,20,25,30,40,55},
                {60,62,63,64,65,66,67}
        };

        System.out.println(matrix[0][0]);
        System.out.println(matrix[0][1]);
        System.out.println(matrix[1][0]);
        System.out.println(matrix[2][0]);

        int target = 20;
//        generateMatrix(vertical, horizontal, matrix);

        System.out.println(matrix.length);

        System.out.println("IsExist " + searchMatrix(matrix, target));
        System.out.println("IsExist " + searchMatrix2(matrix, target));
    }

    private static void generateMatrix(int vertical, int horizontal, int[][] matrix) {
        int value = new Random().nextInt(100);
        for (int index = 0; index < vertical; index++) {
            for (int secondIdex = 0; secondIdex < horizontal; secondIdex++) {
                matrix[index][secondIdex] = value++;
            }
        }
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int startY = 0;
        int endY = matrix.length;

        int startX = 0;

        while (startY <= endY) {
            int centerY = startY + (endY - startY) / 2;
            System.out.println("CenterY " + centerY);
            System.out.println("matrix " +  matrix.length);
            System.out.println("endY " +  endY);
            if (centerY < matrix.length && startX < matrix[centerY].length){
                int endX = matrix[centerY].length - 1;
                if (target < matrix[centerY][startX]) {
                    System.out.println("target < Y " + matrix[centerY][startX]);
                    endY = centerY - 1;
                } else if (target > matrix[centerY][endX]) {
                    System.out.println("target > Y " +  matrix[centerY][endX]);
                    startY = centerY + 1;
                } else if (target >= matrix[centerY][startX] && target <= matrix[centerY][endX]) {
                    while (startX <= endX) {
                        int centerX = startX + (endX - startX) / 2;
                        System.out.println("centerX " + centerX);
                        if (centerX < matrix[centerY].length) {
                            if (target < matrix[centerY][centerX]) {
                                endX = centerX - 1;
                                System.out.println("endX " + endX);
                            }
                            if (target > matrix[centerY][centerX]) {
                                startX = centerX + 1;
                                System.out.println("startX " + startX);
                            }
                            if (matrix[centerY][centerX] == target) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                break;
            }

        }

        return false;

    }

    private static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int end = rows * columns - 1;

        while (start <= end) {
            int center = (start + end) / 2;
            int row = center / columns;
            int col = center % columns;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = center + 1;
            } else if (matrix[row][col] > target) {
                end = center - 1;
            }
        }

        return false;
    }

}
