package com.shibumi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumPathSumTest {

    @Test
    public void testCalculateMaxSum_firstScenario() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 8;
        matrix[0][1] = 6;
        matrix[0][2] = 7;

        matrix[1][0] = 5;
        matrix[1][1] = 3;
        matrix[1][2] = 0;

        matrix[2][0] = 9;
        matrix[2][1] = 5;
        matrix[2][2] = 1;

        MaximumPathSum maximumPathSum = new MaximumPathSum(matrix);
        int maxValue = maximumPathSum.calculateMaxSum();
        assertEquals(28, maxValue);
    }

    @Test
    public void testCalculateMaxSum_secondScenario() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 1;

        matrix[1][0] = 1;
        matrix[1][1] = 5;
        matrix[1][2] = 1;

        matrix[2][0] = 4;
        matrix[2][1] = 2;
        matrix[2][2] = 1;

        MaximumPathSum maximumPathSum = new MaximumPathSum(matrix);
        int maxValue = maximumPathSum.calculateMaxSum();
        assertEquals(12, maxValue);
    }

}