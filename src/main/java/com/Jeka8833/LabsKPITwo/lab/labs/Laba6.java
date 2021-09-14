package com.Jeka8833.LabsKPITwo.lab.labs;

import com.Jeka8833.LabsKPITwo.Column;
import com.Jeka8833.LabsKPITwo.ForceStopException;
import com.Jeka8833.LabsKPITwo.Reader;
import com.Jeka8833.LabsKPITwo.Writer;
import com.Jeka8833.LabsKPITwo.lab.Lab;

public class Laba6 implements Lab {

    @Override
    public String getName() {
        return "No 6. Розв’язання нелінійних рівнянь з одним невідомим. Метод Ньютона-Рафсона (дотичних)";
    }

    @Override
    public void run() throws ForceStopException {
        final double x = Reader.readDouble("Введите x: ");
        final double e = Reader.readDouble("Введите e: ");
        final double res = calc(x, e);
        Writer.saveResult();
        System.out.println("Ответ x: " + res);
    }

    public static double calc(double x, final double e) {
        Writer.add(new Column("i", Integer.class), new Column("gamma", Double.class));
        double gamma;
        int i = 0;
        do {
            gamma = F(x) / Fq(x);
            x -= gamma;
            Writer.add(i++, gamma);
        } while (Math.abs(gamma) > e);
        return x;
    }

    public static double F(final double value) {
        return Laba3.F(value);
    }

    public static double Fq(final double value) {
        return Laba3.Fq(value);
    }
}
