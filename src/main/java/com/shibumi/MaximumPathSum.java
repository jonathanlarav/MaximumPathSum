package com.shibumi;

import java.util.Arrays;

public class MaximumPathSum {

    private int[][] matrix;

    public MaximumPathSum(int[][] matrix) {
        this.matrix = matrix;
    }

    public int calculateMaxSum() {
        int[][] memo = new int[matrix.length][matrix[0].length];

        for (int i=0; i< this.matrix.length; i++) {
            for (int j=0; j< this.matrix[i].length; j++) {
                int value = this.matrix[i][j];
                int up = i-1 < 0 ? 0 : memo[i-1][j];
                int left = j-1 < 0 ? 0 : memo[i][j-1];

                value += left > up ? left : up;
                memo[i][j] = value;
            }
        }
        //print(memo);
        return memo[matrix.length-1][matrix[0].length-1];
    }

    private void print(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}