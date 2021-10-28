package com.Jeka8833.LabsKPITwo.lab.labs;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class Laba15Test {

    @Test
    public void testCalcPolinom() {
        final int n = 6;
        final double[] randX = new double[n];
        final double[] randY = new double[n];
        for (int i = 0; i < n; i++) {
            randX[i] = i;
            randY[i] = new Random().nextInt(10);
        }

        for (int i = 0; i < n; i++) {
            assertEquals(Laba15.calcPolinom(randX, randY, i), randY[i], 0.000_1);
        }
    }
}