package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

import java.io.IOException;

public class Laba3 implements Lab {

    @Override
    public String getName() {
        return "No 3. Дослідження функцій";
    }

    @Override
    public void run() throws ForceStopException {
        Writer.init(new Column("x", Double.class), new Column("F", Double.class), new Column("F'", Double.class), new Column("F''", Double.class));
        for (int i = -10_000; i < 10_000; i += 10) {
            final double value = i / 1000d;
            Writer.add(value, calculateF(value), Math.cosh(value) - 4 * value, Math.sinh(value) - 4);
        }
        try {
            Writer.saveResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ForceStopException();
    }

    public static double calculateF(final double value) {
        return Math.sinh(value) - 2 * (value * value) + 3;
    }
}
