package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba15 implements Lab {
    @Override
    public String getName() {
        return "No 15. Інтерполяція даних. Рівномірне (чебишовське) наближення функцій";
    }

    @Override
    public void run() throws ForceStopException {
        final int n = Reader.readInt("Введите n: ");
        final double a = Reader.readDouble("Введите a: ");
        final double b = Reader.readDouble("Введите b: ");
        for (int i = 0; i < n; i++) {
            final double xi = a + (b - a) / (n - 1) * i;
            Writer.add(i, xi, Laba3.F(xi));
        }
        Writer.saveResult();
    }
}
