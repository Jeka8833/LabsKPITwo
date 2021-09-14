package com.Jeka8833.LabsKPITwo.lab.labs;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Laba8Test {

    private static final double[][] a1 = new double[][]{
            {2, 2, -1, 1},
            {-3, 0, 3, 0},
            {-1, 3, 3, 2},
            {1, 0, 0, 4}};
    private static final double[][] a2 = new double[][]{
            {-7, -6, -6, 6},
            {7, 6, 8, -13},
            {4, 17, -16, 10},
            {-5, 18, 19, 0}
    };
    private static final double[][] a3 = new double[][]{
            {3, -2, -7, -1},
            {7, -10, -5, 1},
            {4, 0, -15, -9},
            {-8, 8, 13, 4}
    };

    private static final double[] b1 = new double[]{3, -9, -7, 4};
    private static final double[] b2 = new double[]{144, -170, 21, -445};
    private static final double[] b3 = new double[]{2, 28, -21, -11};

    private static final double[] r1 = new double[]{4, -2, 1, 0};
    private static final double[] r2 = new double[]{0, -11, -13, 0};
    private static final double[] r3 = null;

    @Test(timeOut = 10_000)
    public void testCalc() {
        assertEquals(Laba8.calc(4, a1, b1), r1, 0.000_000_1f);
        assertEquals(Laba8.calc(4, a2, b2), r2, 0.000_000_1f);
        assertEquals(Laba8.calc(4, a3, b3), r3, 0.000_000_1f);
    }
}