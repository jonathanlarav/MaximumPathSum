package com.shibumi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumPathSum {

    private int[][] matrix;

    public MaximumPathSum(int[][] matrix) {
        this.matrix = matrix;
    }

    public MaxWithPath calculateMaxSum() {
        MaxWithPath[][] maxValuesMatrix = calculateValuesMatrix();
        return maxValuesMatrix[matrix.length-1][matrix[0].length-1];
    }

    private MaxWithPath[][] calculateValuesMatrix() {
        MaxWithPath[][] memo = new MaxWithPath[matrix.length][matrix[0].length];

        for (int i=0; i< this.matrix.length; i++) {
            for (int j=0; j< this.matrix[i].length; j++) {
                int value = this.matrix[i][j];
                MaxWithPath up = i-1 < 0 ? null : memo[i-1][j];
                MaxWithPath left = j-1 < 0 ? null : memo[i][j-1];

                MaxWithPath mwp;
                
                if (up == null && left ==  null) {
                    // Start position
                    mwp = new MaxWithPath(value, new ArrayList<>());
                } else if ((up == null && left != null) || (left != null && (left.getMax() >= up.getMax()))) {
                    // Go right
                    List<Direction> directions = new ArrayList<>(left.getDirections());
                    directions.add(Direction.right);
                    mwp = new MaxWithPath(value + left.getMax(), directions);
                } else if ((left == null && up != null) || (up != null && (left.getMax() < up.getMax()))) {
                    // Go Down
                    List<Direction> directions = new ArrayList<>(up.getDirections());
                    directions.add(Direction.down);
                    mwp = new MaxWithPath(value + up.getMax(), directions);
                } else {
                    throw new RuntimeException("This shouldn't happen");
                }
                
                memo[i][j] = mwp;
            }
        }
        return memo;
    }

//    public String findMaximumPath() {
//        int[][] maxValuesMatrix = calculateValuesMatrix();
//        return findPath(maxValuesMatrix);
//    }
//
//    private String findPath(int[][] memo) {
//        String path="";
//        int row=memo.length-1, col=memo[0].length-1;
//        while(row != 0 || col != 0){
//            path = matrix[row][col] + " " + path;
//
//            int left = col-1 < 0 ? col : memo[row][col-1];
//            int top = row-1 < 0 ? row : memo[row-1][col];
//            if(left > top) {
//                col--;
//            } else {
//                row--;
//            }
//        }
//        path = matrix[0][0] + " " + path;
//        return path.trim();
//    }
//
//    public static void print(int[][] array) {
//        for (int[] row : array) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//    }
}
