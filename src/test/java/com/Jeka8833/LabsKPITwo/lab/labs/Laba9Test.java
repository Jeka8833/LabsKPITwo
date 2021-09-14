package com.Jeka8833.LabsKPITwo.lab.labs;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Laba9Test {

    private static final double[][] a4 = new double[][]{
            {8, 0, 2, 0},
            {0, 6, 0, 5},
            {2, 0, 5, 0},
            {0, 5, 0, 10}
    };

    private static final double[] b4 = new double[]{15, 10, 5, 0};

    private static final double[] r4 = new double[]{65 / 36d, 20 / 7d, 5 / 18d, -10 / 7d};

    @Test(timeOut = 10_000)
    public void testCalc() {
        assertEquals(Laba9.calc(4, a4, b4, 0.000_001), r4, 0.000_001);
    }
}