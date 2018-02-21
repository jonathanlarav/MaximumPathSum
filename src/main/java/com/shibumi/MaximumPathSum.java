package com.shibumi;

import java.util.Arrays;

public class MaximumPathSum {

    private int[][] matrix;

    public MaximumPathSum(int[][] matrix) {
        this.matrix = matrix;
    }

    public int calculateMaxSum() {
        int[][] maxValuesMatrix = calculateValuesMatrix();
        return maxValuesMatrix[matrix.length-1][matrix[0].length-1];
    }

    private int[][] calculateValuesMatrix() {
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
        return memo;
    }

    public String findMaximumPath() {
        int[][] maxValuesMatrix = calculateValuesMatrix();
        return findPath(maxValuesMatrix);
    }

    private String findPath(int[][] memo) {
        String path="";
        int row=memo.length-1, col=memo[0].length-1;
        while(row != 0 || col != 0){
            path = matrix[row][col] + " " + path;

            int left = col-1 < 0 ? col : memo[row][col-1];
            int top = row-1 < 0 ? row : memo[row-1][col];
            if(left > top) {
                col--;
            } else {
                row--;
            }
        }
        path = matrix[0][0] + " " + path;
        return path.trim();
    }

    private void print(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
