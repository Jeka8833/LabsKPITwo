package com.Jeka8833.LabsKPITwo.lab.labs;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Laba13Test {

    @Test
    public void testCalc() {
        assertEquals(Laba13.calc(3, 4, 0.000_000_1, true), 3.259559824439547668953373, 0.000_000_1);
        assertEquals(Laba13.calc(-5, 1, 0.000_000_1, false), 0.2583923655030188419772680, 0.000_000_1);
    }
}