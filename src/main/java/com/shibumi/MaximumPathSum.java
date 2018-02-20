package com.shibumi;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumPathSum {

    private int[][] matrix;

    public MaximumPathSum(int[][] matrix) {
        this.matrix = matrix;
    }

    public String findMaximumPath() {

        TreeMap<Integer, String> paths = new TreeMap<>();
        accumulateAllPaths(0, 0, "", 0, paths);
        return paths.lastEntry().getValue().trim();
    }

    public void accumulateAllPaths(int row, int col, String path, int total, TreeMap<Integer, String> paths) {
        if (row == matrix.length - 1) {
            for (int i = col; i < matrix[0].length; i++) {
                path += " " + matrix[row][i];
                total += matrix[row][i];
            }
            paths.put(total, path);
            return;
        }
        if (col == matrix[0].length - 1) {
            for (int i = row; i <= matrix.length - 1; i++) {
                path += " " + matrix[i][col];
                total += matrix[i][col];
            }
            paths.put(total, path);
            return;
        }
        path = path + " " + matrix[row][col];
        total += matrix[row][col];
        accumulateAllPaths(row + 1, col, path, total, paths);
        accumulateAllPaths(row, col + 1, path, total, paths);
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
