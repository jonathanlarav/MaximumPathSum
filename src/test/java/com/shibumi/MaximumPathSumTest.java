package com.shibumi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumPathSumTest {

    /**
     * Input grid:
     *
     * 8 6 7
     * 5 3 0
     * 9 5 1
     *
     **/
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

    /**
     * Input grid:
     *
     * 1 3 1
     * 1 5 1
     * 4 2 1
     *
     **/
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


    /**
     * Input grid:
     *
     * 1 3 -1
     * -1 -5 1
     * 4 2 1
     *
     **/
    @Test
    public void testCalculateMaxSum_withNegativeValues() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 1;

        matrix[1][0] = -1;
        matrix[1][1] = -5;
        matrix[1][2] = 1;

        matrix[2][0] = 4;
        matrix[2][1] = 2;
        matrix[2][2] = 1;

        MaximumPathSum maximumPathSum = new MaximumPathSum(matrix);
        int maxValue = maximumPathSum.calculateMaxSum();
        assertEquals(7, maxValue);
    }


    /**
     * Input grid:
     *
     * 1 3 1 8
     * 1 5 1 5
     * 4 2 1 7
     *
     **/
    @Test
    public void testCalculateMaxSum_MultipleSizeGrid3x4() {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 1;
        matrix[0][3] = 8;

        matrix[1][0] = 1;
        matrix[1][1] = 5;
        matrix[1][2] = 1;
        matrix[1][3] = 5;

        matrix[2][0] = 4;
        matrix[2][1] = 2;
        matrix[2][2] = 1;
        matrix[2][3] = 7;

        MaximumPathSum maximumPathSum = new MaximumPathSum(matrix);
        int maxValue = maximumPathSum.calculateMaxSum();
        assertEquals(25, maxValue);
    }

    /**
     * Input grid:
     *
     * 1 3 1 8
     * 1 5 1 5
     * 4 2 1 7
     * 9 5 8 3
     *
     **/
    @Test
    public void testCalculateMaxSum_MultipleSizeGrid4x4() {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 1;
        matrix[0][3] = 8;

        matrix[1][0] = 1;
        matrix[1][1] = 5;
        matrix[1][2] = 1;
        matrix[1][3] = 5;

        matrix[2][0] = 4;
        matrix[2][1] = 2;
        matrix[2][2] = 1;
        matrix[2][3] = 7;

        matrix[3][0] = 9;
        matrix[3][1] = 5;
        matrix[3][2] = 8;
        matrix[3][3] = 3;

        MaximumPathSum maximumPathSum = new MaximumPathSum(matrix);
        int maxValue = maximumPathSum.calculateMaxSum();
        assertEquals(31, maxValue);
    }

    /**
     * Input grid:
     *
     * 8 6 7
     * 5 3 0
     * 9 5 1
     *
     **/
    @Test
    public void testGetMaxSumPath() {
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
        String path = maximumPathSum.findMaximumPath();
        assertEquals("8 5 9 5 1", path);
    }

}