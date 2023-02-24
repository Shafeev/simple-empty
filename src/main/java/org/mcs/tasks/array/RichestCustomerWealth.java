package org.mcs.tasks.array;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] accounts = new int[][] {{1,4}, {1,2,4,4}, {1,2,5,5,7}};

        int result = maximumWealth(accounts);
        System.out.println(result);
    }

    private static int maximumWealth(int[][] accounts) {
        int[] sum = new int[accounts.length];
        System.out.println(sum.length);
        for(int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum[i] = sum[i] + accounts[i][j];
            }
        }

        int max = 0;

        for (int i : sum) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}
